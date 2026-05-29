package util;

public class SQL {
	
	// user1
	public static final String INSERT_USER1 = "INSERT INTO USER1 VALUES (?,?,?,?)";
	public static final String SELECT_USER1 = "SELECT * FROM USER1 WHERE userid = ?";
	public static final String SELECTALL_USER1 = "SELECT * FROM USER1";
	public static final String UPDATE_USER1 = "UPDATE User1 SET "
												+ "name = ?, "
												+ "hp = ?, "
												+ "age = ? "
												+ "WHERE userid = ?";
	public static final String DELETE_USER1 = "DELETE FROM User1 WHERE userid = ?";
	
}
