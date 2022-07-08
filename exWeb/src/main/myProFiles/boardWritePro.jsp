<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	BoardDAO dao = BoardDAO.getInstance();

	String title = request.getParameter("title");
	String contents = request.getParameter("contents");

	System.out.println("titletitle : " + title);
	System.out.println("contentscontents : " + contents);

	dao.addBoard(title, contents);

	response.sendRedirect("boardPro.jsp");
	%>

</body>
</html>