package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	// 영화+리뷰 조회
	public List<Movie> getList() throws Exception {
		Connection conn = open();
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		String sql = "select m.m_no, m.m_title, r.r_title, r.r_grade from movie m, review r where m.m_no = r.m_no";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Movie m = new Movie();
				m.setM_no(rs.getInt(1));
				m.setM_title(rs.getString(2));
				m.setR_title(rs.getString(3));
				m.setR_grade(rs.getDouble(4));

				movieList.add(m);
			}
		}

		return movieList;
	}

	// m_no 자동 생성
	public Movie getNumber() throws SQLException {
		Connection conn = open();
		Movie m = new Movie();

		String sql = "select max(m_no) + 1 from movie ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			if (rs.next()) {
				m.setM_no(rs.getInt(1));
			}
		}

		return m;
	}

	// 영화 정보 등록
	public void insertMovie(Movie m) throws Exception {
		Connection conn = open();
		String sql = "insert into movie values (?, ?, ?, ?, ?, ?, ?, to_date(?, 'YYYY-MM-DD')) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setInt(1, m.getM_no());
			pstmt.setString(2, m.getM_title());
			pstmt.setString(3, m.getM_actor());
			pstmt.setString(4, m.getM_director());
			pstmt.setString(5, m.getM_nation());
			pstmt.setString(6, m.getM_grade());
			pstmt.setString(7, m.getM_genre());
			pstmt.setString(8, m.getM_date());

			pstmt.executeUpdate();

		}
	}

	// m_no 자동 생성 (리뷰 페이지)
	public Review getReviewNumber() throws SQLException {
		Connection conn = open();
		Review r = new Review();

		String sql = "select max(m_no) + 1 from review ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			if (rs.next()) {
				r.setM_no(rs.getInt(1));
			}
		}

		return r;
	}
	
	// 영화 리뷰 등록
	public void insertReview(Review r) throws Exception {
		Connection conn = open();
		String sql = "insert into review values (?, ?, ?, ?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setInt(1, r.getM_no());
			pstmt.setString(2, r.getR_title());
			pstmt.setDouble(3, r.getR_grade());
			pstmt.setString(4, r.getR_content());
			pstmt.executeUpdate();
		}
	}


	// 영화 정보 내용 가져오기
	public Movie getRegisterdMovie(int m_no) throws SQLException {
		Connection conn = open();
		Movie m = new Movie();

		String sql = "select max(m_no) keep(dense_rank first order by m_no desc) from movie ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				m.setM_no(rs.getInt(1));
				m.setM_title(rs.getString(2));
				m.setM_actor(rs.getString(3));
				m.setM_director(rs.getString(4));
				m.setM_nation(rs.getString(5));
				m.setM_grade(rs.getString(6));
				m.setM_genre(rs.getString(7));
				m.setM_date(rs.getString(8));
			}

			return m;
		}

	}

	// 영화 정보 내용 가져오기
	public Movie getMovieView(int m_no) throws Exception {
		Connection conn = open();
		Movie m = new Movie();

		String sql = "select m_no, m_title, m_actor, m_director, m_nation, m_grade, m_genre, to_char(m_date, 'YYYY-MM-DD') from movie where m_no = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				m.setM_no(rs.getInt(1));
				m.setM_title(rs.getString(2));
				m.setM_actor(rs.getString(3));
				m.setM_director(rs.getString(4));
				m.setM_nation(rs.getString(5));
				m.setM_grade(rs.getString(6));
				m.setM_genre(rs.getString(7));
				m.setM_date(rs.getString(8));
			}
			return m;
		}

	}

	

	public void updateMovieInfo(Movie m) throws Exception {
		Connection conn = open();

		String sql = "update movie set m_title = ?, m_actor = ? , m_director = ?, m_nation = ?, m_grade = ?, m_genre = ?, m_date = ? where m_no = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try (conn; pstmt) {
			pstmt.setString(1, m.getM_title());
			pstmt.setString(2, m.getM_actor());
			pstmt.setString(3, m.getM_director());
			pstmt.setString(4, m.getM_nation());
			pstmt.setString(5, m.getM_grade());
			pstmt.setString(6, m.getM_genre());
			pstmt.setString(7, m.getM_date());
			pstmt.setDouble(8, m.getM_no());

			if (pstmt.executeUpdate() != 1) {
				throw new Exception("수정 에러");
			}
		}
	}

	// 리뷰 정보 내용 가져오기
	public Review getReviewView(int m_no) throws Exception {
		Connection conn = open();
		Review r = new Review();

		String sql = "select r_title, r_grade, r_content from review where m_no = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				r.setR_title(rs.getString(1));
				r.setR_grade(rs.getDouble(2));
				r.setR_content(rs.getString(3));
			}
			return r;

		}
	}

	public void updateReviewInfo(Review r) throws Exception {
		Connection conn = open();

		String sql = "update review set r_title = ?, r_grade = ? , r_content = ? where m_no = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setString(1, r.getR_title());
			pstmt.setDouble(2, r.getR_grade());
			pstmt.setString(3, r.getR_content());
			pstmt.setInt(4, r.getM_no());

			if (pstmt.executeUpdate() != 1) {
				throw new Exception("수정 에러");
			}
		}

	}

	public void deleteReview(int m_no) throws Exception {
		Connection conn = open();

		String sql = "delete from review where m_no = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setInt(1, m_no);

			if (pstmt.executeUpdate() != 1) {
				throw new Exception("삭제된 글이 없습니다.");
			}
		}
	}

}
