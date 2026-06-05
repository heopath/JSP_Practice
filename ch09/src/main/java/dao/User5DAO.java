package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User5DTO;
import util.DBHelper;
import util.SQL;

// DAO(Data Access Object) : 데이터베이스와 상호작용(SQL 처리)하는 MVC 컴포넌트 
public class User5DAO extends DBHelper {
	
	// 싱글톤
	private static User5DAO instance = new User5DAO();
	public static User5DAO getInstance() {
		return instance;
	}
	private User5DAO() {}
	
	
	// 기본 CRUD 메서드
	public void insert(User5DTO dto) {
		
		try {
			conn = getConnection();			
			psmt = conn.prepareStatement(SQL.INSERT_USER5);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public User5DTO select(String seq) {
		
		// 반환용 DTO 선언
		User5DTO dto = null;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.SELECT_USER5);
			psmt.setInt(1, Integer.parseInt(seq));
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User5DTO(); // DTO 생성
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
			}
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;		
	}
	
	public List<User5DTO> selectAll() {
		
		// 반환용 리스트 선언
		List<User5DTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();		
			rs = stmt.executeQuery(SQL.SELECTALL_USER5);
			
			while(rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
				dtoList.add(dto);
			}
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void update(User5DTO dto) {
		
		try {
			conn = getConnection();						
			psmt = conn.prepareStatement(SQL.UPDATE_USER5);			
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());			
			psmt.setString(5, dto.getSeq());			
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String seq) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_USER5);
			psmt.setString(1, seq);
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}