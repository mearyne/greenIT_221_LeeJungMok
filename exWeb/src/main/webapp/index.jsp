<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserDAO dao = UserDAO.getInstance();
	if (dao.getConnection() != null) {
		System.out.println("데이터베이스 연동 완료");

	} else {
		System.out.println("데이터베이스 연동 완료");
	}
%>

	<form method="get" action="indexPro.jsp"> 
		<input type="text" name="google" placeholder="id"> 
		<input type="submit">
	</form>

</body>
</html>