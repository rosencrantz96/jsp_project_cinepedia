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
import DTO.Review;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;

		switch (command) {
		case "/home":
			site = "index.jsp";
			break;
		// 메뉴의 [movie]를 누르면 registMovie.jsp를 보여줌.
		case "/registMovie":
			site = "registMovie.jsp";
			break;
		// 영화 등록 기능 (제목, 내용 등 내가 작성한 것들이 request 객체에 저장)
		case "/insertMovie":
			site = insertMovie(request);
			break;
		// 영화 정보 페이지
		case "/registerdMovie":
			site = "registerdMovie.jsp";
			break;
		// 메뉴의 [review] 누르면 영화 등록 먼저 하라는 알림창 뜨게 수정하기
		case "/registReview":
			site = "registReview.jsp";
			break;
		case "/insertReview":
			site = insertReview(request);
			break;
		case "/movieList":
			site = "movieList.jsp";
			break;
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

		// 영화 등록 후 영화 정보 페이지로 이동
		return "redirect:/registerdMovie";
	}

	public String insertReview(HttpServletRequest request) {
		Review r = new Review();

		try {
			BeanUtils.populate(r, request.getParameterMap());
			dao.insertReview(r);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("리뷰 등록 과정에서 문제 발생");
			try {
				String encodeName = URLEncoder.encode("리뷰가 정상적으로 등록되지 않았습니다!", "UTF-8");
				return "redirect:/home?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		// 리뷰 등록 후 영화 리스트 페이지로 이동
		return "redirect:/movieList";
	}
}
