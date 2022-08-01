<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>click like button</title>
</head>
<body>
	<%
	BoardDAO dao = BoardDAO.getInstance();

	int boardCode = Integer.parseInt(request.getParameter("code"));
	System.out.println("boardCode : " + boardCode);

	dao.clickLike(boardCode); // 좋아요 횟수를 하나 증가시킨다
	request.getRequestDispatcher("boardView.jsp").forward(request, response); // 페이지를 이동한다
	%>

</body>
</html>