package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTrade.CustomTradeDAO;
import customTrade.CustomTradeDTO;

/**
 * Servlet implementation class updateTradeAction
 */
public class updateTradeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTradeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		<input type="text" name="pcost" placeholder="pcost"><br>
//		<input type="text" name="amount" placeholder="amount"><br>
//		<input type="text" name="price" placeholder="price"><br>
//		<input type="text" name="pcode" placeholder="pcode"><br>
//		<input type="text" name="sdate" placeholder="sdate"><br>
	
		int custno = Integer.parseInt((String) request.getParameter("custno"));
		int salenol = Integer.parseInt((String) request.getParameter("salenol"));
		int pcost = Integer.parseInt((String) request.getParameter("pcost"));
		int amount = Integer.parseInt((String) request.getParameter("amount"));
		int price = Integer.parseInt((String) request.getParameter("price"));
		String pcode = (String) request.getParameter("pcode");
		Date sdate = Date.valueOf((String) request.getParameter("sdate"));
		
		CustomTradeDTO customTradeDTO = new CustomTradeDTO(custno, salenol, pcost, amount, price, pcode , sdate);
		CustomTradeDAO.getInstance().updateCustomTrade(customTradeDTO);
		
		request.getRequestDispatcher("customTrade?custno=" + custno).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
