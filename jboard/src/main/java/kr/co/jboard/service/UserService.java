package kr.co.jboard.service;

import kr.co.jboard.dao.UserDAO;
import kr.co.jboard.dto.UserDTO;

public enum UserService {

	// 열거 상수 객체 (싱글톤)
	INSTANCE;

	// DAO 가져오기
	private UserDAO dao = UserDAO.getInstance();

	// 회원가입
	public void register(UserDTO dto) {
		dao.insert(dto);
	}

	// 로그인
	public UserDTO login(String userid, String pass) {
		return dao.selectUser(userid, pass);
	}

	// 중복체크 (존재하면 1, 없으면 0 반환)
	public int countUser(String type, String value) {
		return dao.selectCount(type, value);
	}
}