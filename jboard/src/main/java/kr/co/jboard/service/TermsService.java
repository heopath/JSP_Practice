package kr.co.jboard.service;

import kr.co.jboard.dao.TermsDAO;
import kr.co.jboard.dto.TermsDTO;

public enum TermsService {

	// 열거 상수 객체 (싱글톤)
	INSTANCE;

	// DAO 가져오기
	private TermsDAO dao = TermsDAO.getInstance();

	// 약관 조회
	public TermsDTO findTerms() {
		return dao.selectTerms();
	}
}