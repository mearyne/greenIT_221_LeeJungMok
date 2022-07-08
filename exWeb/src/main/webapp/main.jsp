<%@page import="exWeb.UserDTO"%>
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
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	// post 메소드로 전달된 파라미터 값 확인
	/*
		id
		password[]
		name
		year
		month
		day
		gender
		email
		country
		mobile
	*/
	String id = request.getParameter("id");
	String[] password = request.getParameterValues("password");
	String name = request.getParameter("name");
	int year = Integer.parseInt(request.getParameter("year"));
	int month = Integer.parseInt(request.getParameter("month"));
	int day = Integer.parseInt(request.getParameter("day"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	String mobile = request.getParameter("mobile");

	out.println(id);
	out.println(password);
	out.println(name);
	out.println(year);
	out.println(month);
	out.println(day);
	out.println(gender);
	out.println(email);
	out.println(country);
	out.println(mobile);

	UserDAO dao = UserDAO.getInstance();
	UserDTO user = null;

	user = new UserDTO(id, password[0], name, year, month, day, gender, email, country, mobile);
	%>
</body>
</html>