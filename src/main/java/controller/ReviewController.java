package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.ReviewDAO;
import DTO.Movie;


@WebServlet("/")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDAO dao;
	private ServletContext ctx;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		dao = new ReviewDAO();
		ctx = getServletContext();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;
		
		switch(command) {
		case "/home": 
			site = "index.jsp";
			break;
		case "/registMovie":
			site = "registMovie.jsp";
			break;
		case "/registReview":
			site = "registReview.jsp";
			break;
		case "/movieList":
			site = "movieList.jsp";
			break;
		case "/registerdMovie":
			site = "registerdMovie.jsp";
			break;
		// [movie]를 누르면 registMovie.jsp를 보여준다. 
//		case "/writeMovie":
//			site = "registMovie.jsp";
//			break;
//		 insert 기능 (영화 정보 등록) 
//		case "/registMovie":
//			site = insertMovie(request);
//			break;
		}
		
		if (site.startsWith("redirect:/")) {
			String rview = site.substring("redirect:/".length());
			System.out.println(rview);
			response.sendRedirect(rview);
		} else {
			ctx.getRequestDispatcher("/" + site).forward(request, response);
		}
	}


	public String insertMovie(HttpServletRequest request) {
		Movie m = new Movie();
		
		try {
			BeanUtils.populate(m, request.getParameterMap());
			dao.insertMovie(m);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("영화 등록 과정에서 문제 발생");
			try {
				String encodeName = URLEncoder.encode("영화가 정상적으로 등록되지 않았습니다!", "UTF-8");
				return "redirect:/home?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		} 
		
		return "redirect:/home";
	}




}
