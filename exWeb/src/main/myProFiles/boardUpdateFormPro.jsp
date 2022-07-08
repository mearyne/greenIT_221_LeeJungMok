<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>click update board</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	BoardDAO dao = BoardDAO.getInstance();
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	int boardCode = Integer.parseInt(request.getParameter("boardCode"));

	dao.updateBoard(title, contents, boardCode);
	response.sendRedirect("boardPro.jsp");
	%>


</body>
</html>