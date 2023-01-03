package DTO;

import java.sql.Date;

public class Review {
	private String r_title; // 리뷰 제목 
	private int m_no; // 등록 번호 
	private String r_date; // 관람 일자 
	private double r_grade; // 내 평점 
	private String r_content; // 내용 
	private String m_title;
	
	
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public double getR_grade() {
		return r_grade;
	}
	public void setR_grade(double r_grade) {
		this.r_grade = r_grade;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	
}
