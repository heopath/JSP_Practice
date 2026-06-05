package kr.co.jboard.util;

public class SQL {
	
	// =========================================================================
	// Article (게시글 관련 쿼리 - ArticleDAO와 1:1 매칭 완료)
	// =========================================================================
	
	// DAO insert()의 파라미터 순서: 1:title, 2:content, 3:writer, 4:regip
	public static final String INSERT_ARTICLE = "INSERT INTO `Article` SET "
													+ "`type`='free', "
													+ "`title`=?, "    // ? (1번)
													+ "`content`=?, "  // ? (2번)
													+ "`file`=?, "	   // ? (3번)
													+ "`writer`=?, "   // ? (4번)
													+ "`regip`=?, "    // ? (5번)
													+ "`wdate`=NOW()";
													
	// DAO select() 구조에 맞춤 (인덱스 1~10번 매칭을 위해 테이블 생성 순서대로 전체 조회)
	public static final String SELECT_ARTICLE = "SELECT * FROM `Article` WHERE `ano` = ?";
	
	// DAO selectAll() 구조에 맞춤 (최신글이 위로 오도록 정렬 추가)
	public static final String SELECT_ALL_ARTICLE = "SELECT\r\n"
			+ "a.*,\r\n"
			+ "u.nick \r\n"
			+ "FROM article a \r\n"
			+ "JOIN `user` u  ON A.writer = U.userid "
			+ "ORDER BY ano DESC "
			+ "LIMIT ?, 10;";

	public static final String SELECT_MAX_ANO = "SELECT MAX(ANO) FROM `Article`";
	
	
	// DAO update()의 파라미터 순서: 1:title, 2:content, 3:ano
	public static final String UPDATE_ARTICLE = "UPDATE `Article` SET "
													+ "`title`=?, "   // ? (1번)
													+ "`content`=? "  // ? (2번)
													+ "WHERE `ano`=?"; // ? (3번)
													
	// DAO delete()의 파라미터 순서: 1:ano
	public static final String DELETE_ARTICLE = "DELETE FROM `Article` WHERE `ano` = ?";

	
	// =========================================================================
	// User, Comment, File, Terms (추후 다른 DAO 작성 시 참고용 정비 버전)
	// =========================================================================
	
	// User
	public static final String INSERT_USER = "INSERT INTO `User` SET "
															+ "`userid`=?, "
															+ "`pass`=SHA2(?, 256), "
															+ "`name`=?, "
															+ "`nick`=?, "
															+ "`email`=?, "
															+ "`hp`=?, "
															+ "`zip`=?, "
															+ "`addr1`=?, "
															+ "`addr2`=?, "
															+ "`regip`=?, "
															+ "`regDate`= NOW()";
	public static final String SELECT_USER = "SELECT * FROM `User` WHERE `userid` = ? AND `pass` = SHA2(?, 256)";
	public static final String SELECT_COUNT_USER = "SELECT COUNT(*) FROM `User` ";
	public static final String WHERE_USERID = "WHERE userid=?";
	public static final String WHERE_NICK = "WHERE nick=?";
	public static final String WHERE_EMAIL = "WHERE email=?";
	public static final String WHERE_HP = "WHERE hp=?";
	
	// Comment
	public static final String INSERT_COMMENT = "INSERT INTO `Comment` SET `parent`=?, `content`=?, `writer`=?, `regip`=?, `wdate`=NOW()";
	public static final String SELECT_COMMENTS_BY_PARENT = "SELECT * FROM `Comment` WHERE `parent` = ? ORDER BY `cno` ASC";
	
	// File
	public static final String INSERT_FILE = "INSERT INTO `File` SET `ano`=?, `ofname`=?, `sfname`=?, `rdate`=NOW()";
	public static final String SELECT_FILE_BY_ANO = "SELECT * FROM `File` WHERE `ano` = ?";
	
	// Terms
	public static final String SELECT_TERMS = "SELECT * FROM `Terms` WHERE `no` = 1";
}