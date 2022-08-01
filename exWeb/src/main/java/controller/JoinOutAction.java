package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exWeb.UserDAO;

/**
 * Servlet implementation class JoinOutAction
 */
//@WebServlet("/JoinOutAction")
public class JoinOutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinOutAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원탈퇴 프로세스
		String log_id = (String) request.getSession().getAttribute("log");
		String input_pass = (String) request.getParameter("input_pw");

		System.out.println(input_pass);

		UserDAO dao = new UserDAO();
		if (dao.removeId(log_id, input_pass)) { // 성공하면
			request.getRequestDispatcher("./index.jsp").forward(request, response);
			;
		} else { // 실패하면
			request.getRequestDispatcher("./mainPage/mainPage.jsp").forward(request, response);
			;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
