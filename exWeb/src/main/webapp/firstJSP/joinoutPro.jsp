<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Out Process</title>
</head>
<body>
	<%
	// 회원탈퇴 프로세스
	String log_id = (String) session.getAttribute("log");
	String input_pass = (String) request.getParameter("input_pw");

	System.out.println(input_pass);

	UserDAO dao = new UserDAO();
	if (dao.removeId(log_id, input_pass)) {
		out.println("<script>alert('회원 탈퇴 성공')</script>");
		out.println("<script>location.href='index.js'</script>");
	} else {
		out.println("<script>alert('회원 탈퇴 실패')</script>");
		out.println("<script>location.href='mainPage.jsp'</script>");
	}
	%>

</body>
</html>