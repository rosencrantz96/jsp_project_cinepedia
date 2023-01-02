package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReviewDAO;


@WebServlet("/")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewController() {
        super();
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
		
		ReviewDAO review = new ReviewDAO();
		
		switch(command) {
		case "/home": 
			site = "index.jsp";
			break;
		case "/voteM":
			int result = review.insertMovie(request, response);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(result==1) {
				out.println("<script>");
				out.println("alert('영화 정보가 정상적으로 등록 되었습니다!'); location.href='" + context + "';");
				out.println("</script>");
				out.flush();
			} else {
				out.println("<script>");
				out.println("alert('등록실패!'); location.href='" + context + "';'");
				out.println("</script>");
				out.flush();
			}
			break;
		case "/registMember":
			site = "registMember.jsp";
			break;
			
		}
		
		getServletContext().getRequestDispatcher("/" + site).forward(request, response);
	}

}
