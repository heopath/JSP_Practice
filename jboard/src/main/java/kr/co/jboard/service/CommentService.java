package kr.co.jboard.service;

import java.util.List;
import kr.co.jboard.dao.CommentDAO;
import kr.co.jboard.dto.CommentDTO;

public enum CommentService {

	// 열거 상수 객체 (싱글톤)
	INSTANCE;

	// DAO 가져오기
	private CommentDAO dao = CommentDAO.getInstance();

	// 댓글 등록
	public void register(CommentDTO dto) {
		dao.insert(dto);
	}

	// 특정 게시글(parent)의 댓글 목록 조회
	public List<CommentDTO> findAll(int parent) {
		return dao.selectAll(parent);
	}
}