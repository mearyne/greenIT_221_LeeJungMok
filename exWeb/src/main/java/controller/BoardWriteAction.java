package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;

/**
 * Servlet implementation class boardWriteAction
 */
//@WebServlet("/boardWriteAction")
public class BoardWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardWriteAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		BoardDAO dao = BoardDAO.getInstance();

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		System.out.println("titletitle : " + title);
		System.out.println("contentscontents : " + contents);

		dao.addBoard(title, contents);

//		response.sendRedirect("boardPro.jsp");
		// TODO 내용이 없을때는 넘어가지 못하게 한다
		request.getRequestDispatcher("board").forward(request, response);
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
