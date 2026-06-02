package kr.co.jboard.service;

import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {

	// 열거 상수 객체 (싱글톤)
	INSTANCE;

	// DAO 가져오기
	private FileDAO dao = FileDAO.getInstance();

	// 파일 정보 등록
	public void register(FileDTO dto) {
		dao.insert(dto);
	}

	// 특정 게시글 번호로 파일 정보 조회
	public FileDTO findByAno(int ano) {
		return dao.selectFileByAno(ano);
	}
}