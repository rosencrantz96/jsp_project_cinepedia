package DTO;


public class Movie {
	private int rownum;
	private int m_no; // 등록 번호 
	private String m_title; // 영화 제목 
	private String m_actor; // 출연 배우 
	private String m_director; // 감독 
	private String m_nation; // 국가 
	private String m_grade; // 영화 등급 
	private String m_genre; // 장르 
	private String m_date; // 개봉일자 
	private String r_title; // 리뷰 제목 
	private double r_grade; // 내 평점 
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_actor() {
		return m_actor;
	}
	public void setM_actor(String m_actor) {
		this.m_actor = m_actor;
	}
	public String getM_director() {
		return m_director;
	}
	public void setM_director(String m_director) {
		this.m_director = m_director;
	}
	public String getM_nation() {
		return m_nation;
	}
	public void setM_nation(String m_nation) {
		this.m_nation = m_nation;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_genre() {
		return m_genre;
	}
	public void setM_genre(String m_genre) {
		this.m_genre = m_genre;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public double getR_grade() {
		return r_grade;
	}
	public void setR_grade(double r_grade) {
		this.r_grade = r_grade;
	}
	
	
}
