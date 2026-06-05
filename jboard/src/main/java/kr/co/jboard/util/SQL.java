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
													
	public static final String SELECT_ARTICLE = "SELECT * FROM Article WHERE ano=?";
	
	public static final String SELECT_MAX_ANO = "SELECT MAX(ano) FROM Article";
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM Article";
	
	
	
	public static final String SELECT_ALL_ARTICLE = "SELECT a.*, u.nick FROM Article AS a "
													+ "JOIN User AS u "
													+ "ON a.writer = u.userid "
													+ "ORDER BY ano DESC "
													+ "LIMIT ?, 10";
	
	public static final String SELECT_COUNT_ARTICLE_JOIN = "SELECT COUNT(*) FROM Article AS a "
																+ "JOIN User AS u ON a.writer = u.userid ";
	public static final String SELECT_ALL_ARTICLE_JOIN = "SELECT a.*, u.nick FROM Article AS a "
																+ "JOIN User AS u ON a.writer = u.userid ";
	
	public static final String WHERE_TITLE_KEYWORD = "WHERE title LIKE ? ";
	public static final String WHERE_CONTENT_KEYWORD = "WHERE content LIKE ? ";
	public static final String WHERE_NICK_KEYWORD = "WHERE nick LIKE ? ";
	public static final String ORDER_LIMIT = "ORDER BY ano DESC LIMIT ?, 10";
	
	
	
	
	public static final String UPDATE_ARTICLE = "UPDATE Article SET "
															+ "title=?,"
															+ "content=? "															
															+ "WHERE ano=?";
	public static final String DELETE_ARTICLE = "DELETE FROM Article WHERE ano=?";

	
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