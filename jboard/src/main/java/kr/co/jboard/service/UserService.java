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

	// 아이디 중복체크 (존재하면 1, 없으면 0 반환)
	public int countUserid(String userid) {
		return dao.selectCountUserid(userid);
	}

	// 닉네임 중복체크 (존재하면 1, 없으면 0 반환)
	public int countNick(String nick) {
		return dao.selectCountNick(nick);
	}
}