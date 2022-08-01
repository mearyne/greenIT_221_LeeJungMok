package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exWeb.UserDAO;

/**
 * Servlet implementation class LoginAction
 */
//@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// doGet() 메소드 : http request method(리퀘스트 방식이 get이면 작동함) - Get
		UserDAO dao = UserDAO.getInstance();
		String userId = request.getParameter("id");
		String userPw = request.getParameter("password");

		// 페이지 이동 처리
		if (dao.checkIdPw(userId, userPw)) {
			request.getSession().setAttribute("log", userId);
			request.getRequestDispatcher("board").forward(request, response);
		}  else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		// 세션 활용
		// request.getSession().setAttribute(password, url);
		
		// 세션 객체를 request를 통해서 얻어올 수 있다.
		// HttpSession session = request.getSession();
		// session.setAttribute("log", id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// doPost() 메소드 : http request method : post
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
