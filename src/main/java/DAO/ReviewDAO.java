package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Movie;
import DTO.Review;

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
	
	
	public void insertMovie(Movie m) throws Exception {
		Connection conn = open();
		String sql = "";
	}
	
}
