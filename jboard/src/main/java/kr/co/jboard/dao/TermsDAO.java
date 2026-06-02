package kr.co.jboard.dao;

import kr.co.jboard.dto.TermsDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class TermsDAO extends DBHelper {

	private static TermsDAO instance = new TermsDAO();
	public static TermsDAO getInstance() {
		return instance;
	}
	private TermsDAO() {}

	// 약관 조회 (no = 1 고정 조회)
	public TermsDTO selectTerms() {
		TermsDTO dto = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_TERMS);
			
			if(rs.next()) {
				dto = new TermsDTO();
				dto.setNo(rs.getInt(1));
				dto.setBasic(rs.getString(2));
				dto.setPrivacy(rs.getString(3));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}