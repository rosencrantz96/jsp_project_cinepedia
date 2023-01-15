package controller;

import java.io.IOException;
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
//		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;

		switch (command) {
		// 메노의 [home]을 누르면 index.jsp를 보여줌
		case "/home":
			site = "index.jsp";
			break;

		// registMovie.jsp를 보여주기
		case "/registMovie":
			site = getNumber(request);
			break;

		// 영화 등록 기능
		case "/insertMovie":
			site = insertMovie(request);
			break;

		// registReview.jsp 보여주기
		case "/registReview":
			site = getReviewNumber(request);
			break;

		// 리뷰 등록 기능
		case "/insertReview":
			site = insertReview(request);
			break;

		// movieList.jsp 보여주기
		case "/list":
			site = getList(request);
			break;

		// 등록된 영화 정보 가져오기
		case "/registerdMovie":
			site = getMovieInfo(request);
			break;

		// 등록된 리뷰 정보 가져오기
		case "/registerdReview":
			site = getReviewInfo(request);
			break;

		// 영화 정보 수정 화면 보여주기
		case "/editMovieInfo":
			site = getMovieInfoViewForEdit(request);
			break;

		// 영화 정보 수정하기
		case "/updateMovieInfo":
			site = updateMovieInfo(request);
			break;

		// 영화 리뷰 수정 화면 보여주기
		case "/editReviewInfo":
			site = getReviewInfoViewForEdit(request);
			break;

		// 영화 리뷰 수정하기
		case "/updateReviewInfo":
			site = updateReviewInfo(request);
			break;
			
		// 영화 정보 삭제하기 
		case "/deleteMovie":
			site = deleteMovie(request);
			break;

		// 리뷰 정보 삭제하기 
		case "/deleteReview":
			site = deleteReview(request);
			break;
		}

		if (site != null) {
			if (site.startsWith("redirect:/")) {
				String rview = site.substring("redirect:/".length());
				System.out.println(rview);
				response.sendRedirect(rview);
			} else {
				ctx.getRequestDispatcher("/" + site).forward(request, response);
			}
		}
	}


	// 번호 자동 생성 후 영화 등록 페이지 뷰
	public String getNumber(HttpServletRequest request) {
		Movie m;

		try {
			m = dao.getNumber();
			request.setAttribute("m", m);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("번호 생성 과정에서 문제 발생");
			request.setAttribute("error", "번호 생성이 정상적으로 처리되지 않았습니다!");
		}

		return "registMovie.jsp";
	}

	// 영화 등록! → 리뷰 쓰러 이동
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

		return "redirect:/registReview";
	}

	// 번호 자동 생성 후 리뷰 등록 페이지 뷰
	public String getReviewNumber(HttpServletRequest request) {
		Review r;

		try {
			r = dao.getReviewNumber();
			request.setAttribute("r", r);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("번호 생성 과정에서 문제 발생");
			request.setAttribute("error", "번호 생성이 정상적으로 처리되지 않았습니다!");
		}

		return "registReview.jsp";
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
		return "redirect:/home";
	}

	// 영화 + 리뷰 페이지 뷰
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

	// 영화 정보 페이지 불러오기
	public String getMovieInfo(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));

		try {
			Movie m = dao.getMovieView(m_no);
			request.setAttribute("m", m);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("영화 정보를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "영화 정보를 정상적으로 가져오지 못했습니다.");
		}
		return "registerdMovie.jsp";
	}

	// 영화 리뷰 페이지 불러오기
	public String getReviewInfo(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		try {
			Review r = dao.getReviewView(m_no);
			request.setAttribute("r", r);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("영화 리뷰를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "영화 리뷰를 정상적으로 가져오지 못했습니다.");
		}
		return "registeredReview.jsp";
	}

	// 영화 정보 수정 페이지 불러오기
	public String getMovieInfoViewForEdit(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));

		try {
			Movie m = dao.getMovieView(m_no);
			request.setAttribute("m", m);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("영화 정보를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "영화 정보를 정상적으로 가져오지 못했습니다!");
		}

		return "editMovieInfo.jsp";
	}

	// 영화 정보 수정하기
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
	
	// 리뷰 정보 수정 페이지 불러오기 
	public String getReviewInfoViewForEdit(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));

		try {
			Review r = dao.getReviewView(m_no);
			request.setAttribute("r", r);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("영화 리뷰를 가져오는 과정에서 문제 발생");
			request.setAttribute("error", "영화 리뷰를 정상적으로 가져오지 못했습니다!");
		}

		return "editReviewInfo.jsp";
	}

	// 리뷰 정보 수정하기
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
				return "redirect:/registeredReview?m_no=" + r.getM_no() + "&error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:/registeredReview?m_no=" + r.getM_no();
	}
	
	// 영화 정보 삭제하기 
	public String deleteMovie(HttpServletRequest request) {
		int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		try {
			dao.deleteMovie(m_no);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("영화를 삭제하는 과정에서 문제 발생");
			
			try {
				String encodeName = URLEncoder.encode("영화가 정상적으로 삭제되지 않았습니다!", "UTF-8");
				return "redirect:/list?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		return "redirect:/list";
	}
	

	public String deleteReview(HttpServletRequest request) {
int m_no = Integer.parseInt(request.getParameter("m_no"));
		
		try {
			dao.deleteReview(m_no);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("리뷰를 삭제하는 과정에서 문제 발생");
			
			try {
				String encodeName = URLEncoder.encode("리뷰가 정상적으로 삭제되지 않았습니다!", "UTF-8");
				return "redirect:/list?error=" + encodeName;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		return "redirect:/list";
	}


}
