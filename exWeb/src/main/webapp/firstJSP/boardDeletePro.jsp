<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete board process</title>
</head>
<body>
	<%
	BoardDAO dao = BoardDAO.getInstance();
	int boardCode = Integer.parseInt(request.getParameter("code"));

	dao.deleteBoard(boardCode); // mysql에서 해당 게시글을 지운다
	response.sendRedirect("boardPro.jsp");
	
	%>
</body>
</html>