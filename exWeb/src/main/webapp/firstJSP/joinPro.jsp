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
	// 요청받은 데이터에 대한 컨트롤 -> 자바를 통합

	// 자바빈 : 요청된 데이터에 대한 자료 처리 방식
	// ㄴ VO (브이Value 오Object) : read-only
	// ㄴ DTO : 껍데기(?). 요청 데이터를 -> 트랜잭션 처리하기 위한 -> 임시 객체

	// ㄴ DAO : 연동된 데이터(중앙)에 대한 요청 내용을 실제 처리 해주는 객체
	// ㄴ Singletone 패턴 적용 <- 통로가 여러개면 안되기 때문에
	
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

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

	String url = "";
	user = new UserDTO(id, password[0], name, year, month, day, gender, email, country, mobile);
	if (!dao.addUser(user)) {
		// 중복으로 인한 회원가입 실패
		// join.jsp 로 이동
		url = "form_join.jsp";
	} else {
		// 회원가입 성공
		// login.jsp 로 페이지 이동
		url = "index.jsp";
	}
	response.sendRedirect(url);
	%>
</body>
</html>