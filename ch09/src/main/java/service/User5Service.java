package service;

import java.util.List;

import dao.User5DAO;
import dto.User5DTO;

/*
	Service 컴포넌트
	 - Controller와 DAO 사이에 상호작용을 대리하는 MVC 모델 컴포넌트
	 - Business 로직 처리에 사용하는 컴포넌트
 */
public class User5Service {

	// 싱글톤
	private static User5Service instance = new User5Service();
	public static User5Service getInstance() {
		return instance;
	}
	private User5Service() {}
	
	// DAO 객체 가져오기
	private User5DAO dao = User5DAO.getInstance();
	
	
	// DAO 호출 서비스 메서드
	public void register(User5DTO dto) {
		dao.insert(dto);
	}
	
	public User5DTO findbyId(String seq) {
		return dao.select(seq);
	}
	
	public List<User5DTO> findAll() {
		return dao.selectAll();
	}
	
	public void modify(User5DTO dto) {
		dao.update(dto);
	}
	
	public void remove(String seq) {
		dao.delete(seq);
	}
}








