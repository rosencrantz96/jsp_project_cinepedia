package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ReviewDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "OT", "ot1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
