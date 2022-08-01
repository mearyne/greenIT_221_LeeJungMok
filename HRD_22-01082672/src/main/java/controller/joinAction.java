package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.CustomDAO;
import custom.CustomDTO;

/**
 * Servlet implementation class joinAction
 */
//@WebServlet("/joinAction")
public class joinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomDAO customDAO = CustomDAO.getInstance();
		
//		<input type="text" name="custname" placeholder="custname"><br>
//		<input type="text" name="phone" placeholder="phone"><br>
//		<input type="text" name="address" placeholder="address"><br>
//		<input type="text" name="joindate" placeholder="joindate"><br>
//		<input type="text" name="grade" placeholder="grade"><br>
//		<input type="text" name="city" placeholder="city"><br>
//		<input type="submit" value="가입하기">
		
		int custNo = customDAO.getCustno();
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
	
		CustomDTO customDTO = new CustomDTO(custNo, custname, phone, address, null, grade, city);
		customDAO.addCustom(customDTO);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
