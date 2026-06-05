package kr.co.jboard.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection; // ✅ 1. 정상적인 java.util.Collection 으로 수정
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {

	// 열거 상수 객체 (싱글톤)
	INSTANCE;

	// DAO 가져오기
	private FileDAO dao = FileDAO.getInstance();

	// 파일 업로드
	public List<FileDTO> upload(HttpServletRequest request) {
		
		// 반환용 파일 리스트 생성
		List<FileDTO> dtoList = new ArrayList();
		
		// 파일 업로드 디렉터리 경로 구하기
		ServletContext ctx = request.getServletContext();
		String uploadpath = ctx.getRealPath("/upload");
		System.out.println("업로드 경로: " + uploadpath);
		
		File uploadDir = new File(uploadpath);
		
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			// 첨부파일 객체 구하기
			Collection<Part> parts = request.getParts(); // 폼태그의 입력 필드 5개가 part
			
			for(Part part : parts) { // 폼태그의 입력 필드 갯수가 5개이므로 5회 반복
				
				// 파일명 구하기
				String ofName = part.getSubmittedFileName();
			
				if(ofName != null && !ofName.isEmpty()) {
					// 저장 파일명 구하기
					int idx = ofName.lastIndexOf(".");
					String ext = ofName.substring(idx);
					String sfName = UUID.randomUUID().toString() + ext;
			
					part.write(uploadpath + File.separator + sfName);
					
					// 반환용 FileDTO 생성 및 리스트 저장
					FileDTO fileDTO = new FileDTO();
					fileDTO.setOfname(ofName);
					fileDTO.setSfname(sfName);
					dtoList.add(fileDTO);
				}
			} 
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	// 파일 다운로드
	public void download() {
		
	}
	
	// 파일 정보 등록
	public void register(FileDTO dto) {
		dao.insert(dto);
	}

	// 특정 게시글 번호로 파일 정보 조회
	public FileDTO findByAno(int ano) {
		return dao.selectFileByAno(ano);
	}
}