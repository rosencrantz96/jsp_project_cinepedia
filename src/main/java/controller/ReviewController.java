package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

//import org.apache.commons.beanutils.BeanUtils;

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
		// 메노의 [home]을 누르면 index.jsp를 보여줌
		case "/home":
			site = "index.jsp";
			break;
		// 영화+리뷰 목록 조회 페이지
		case "/list":
			site = getList(request);
			break;
		// 메뉴의 [movie]를 누르면 registMovie.jsp를 보여줌. (영화 등록 창)
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
			site = "alert.jsp";
			break;
		// [리뷰쓰기]를 누르면 registReivew.jsp를 보여줌.
		case "/movieReview":
			site = "registReview.jsp";
			break;
		// 리뷰 등록 기능 (제목, 내용 등 내가 작성한 것들이 request 객체에 저장)
		case "/insertReview":
			site = insertReview(request);
			break;
		// 영화 정보 수정 화면을 보여줌 (1. 수정할 데이터를 먼저 끌어오기)
		case "/editMovieInfo":
			site = getMovieForEdit(request);
			break;
		// update 기능
		case "/updateMovieInfo":
			site = updateMovieInfo(request);
			break;
		// 리뷰 정보 수정 화면을 보여줌 (1. 수정할 데이터를 먼저 끌어오기)
		case "/editReviewInfo":
			site = getReviewForEdit(request);
			break;
		// update 기능
		case "/updateReviewInfo":
			site = updateReviewInfo(request);
			break;
		// 리뷰 삭제 기능
		case "/delete":
			site = deleteReview(request);
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

		// 리뷰 등록 후 리뷰 정보 페이지로 이동
		return "redirect:/registerdReview";
	}

	public String getMovieForEdit(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));

		try {
			Movie m = dao.getMovieView(m_no);
			request.setAttribute("movie", m);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("게시글을 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "게시글을 정상적으로 가져오지 못했습니다!");
		}

		return "editMovieInfo.jsp";
	}

	public String updateMovieInfo(HttpServletRequest request) {
		Movie m = new Movie();
		try {
			BeanUtils.populate(m, request.getParameterMap());
			dao.updateMovieInfo(m);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("수정 과정에서 문제 발생");
			try {
				// get방식으로 넘겨줄 때 한글 깨짐을 방지한다.
				String encodeName = URLEncoder.encode("게시물이 정상적으로 수정되지 않았습니다!", "UTF-8");
				return "redirect:/registerdMovie?m_no=" + m.getM_no() + "&error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		return "redirect:/registerdMovie?m_no=" + m.getM_no();
	}

	public String getReviewForEdit(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));

		try {
			Review r = dao.getReviewView(m_no);
			request.setAttribute("review", r);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("리뷰를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "리뷰를 정상적으로 가져오지 못했습니다!");
		}

		return "editReviewInfo.jsp";
	}

	public String updateReviewInfo(HttpServletRequest request) {
		Review r = new Review();
		try {
			BeanUtils.populate(r, request.getParameterMap());
			dao.updateReviewInfo(r);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("수정 과정에서 문제 발생");
			try {
				// get방식으로 넘겨줄 때 한글 깨짐을 방지한다.
				String encodeName = URLEncoder.encode("게시물이 정상적으로 수정되지 않았습니다!", "UTF-8");
				return "redirect:/registerdMovie?m_no=" + r.getM_no() + "&error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		return "redirect:/registerdReview?m_no=" + r.getM_no();
	}

	public String deleteReview(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));

		try {
			dao.deleteReview(m_no);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("게시글을 삭제하는 과정에서 문제 발생");
			try {
				String encodeName = URLEncoder.encode("게시물이 정상적으로 삭제되지 않았습니다!", "UTF-8");
				return "redirect:/registerdReview?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:/registerdReview";
	}

	public String getList(HttpServletRequest request) {
		List<Movie> list;

		try {
			list = dao.getList();
			request.setAttribute("movieList", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("게시판 생성 과정에서 문제 발생");
			request.setAttribute("error", "게시판 목록이 정상적으로 처리되지 않았습니다!");
		}

		return "movieList.jsp";
	}
}
