package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;

/**
 * Servlet implementation class BoardAction
 */
//@WebServlet("/BoardAction")
public class BoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<Integer> codeList = dao.bringAllCode();

		String string = "";
		if (codeList.size() != 0) {
			for (Integer sqlCode : codeList) {
				BoardDTO boardData = dao.bringBoardData(sqlCode);
				
				System.out.println(boardData + " : boardDataboardDataboardData");
				
				int no = boardData.getNo();
				int code = boardData.getCode();
				String title = boardData.getTitle();
				int viewCnt = boardData.getViewCnt();
				int likeCnt = boardData.getLikeCnt();
				Timestamp createAt = boardData.getCreateAt();
				Timestamp modified = boardData.getModified();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
				String createAtString = sdf.format(createAt);
				String modifiedString = sdf.format(modified);

				// 테스트용
				System.out.println(code);

				string += String.format("<tr><td>%d</td><td>%d</td><td><div onclick='location.href=`boardView?code=%d`'>%s</div></td><td>%d</td><td>%d</td><td>%s</td><td>%s</td></tr>", no, code, code ,title, viewCnt, likeCnt, createAtString, modifiedString);
				
			}
		}
		System.out.println(string);
		request.getSession().setAttribute("hiddenString", string);
		request.getRequestDispatcher("/boardlist").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
