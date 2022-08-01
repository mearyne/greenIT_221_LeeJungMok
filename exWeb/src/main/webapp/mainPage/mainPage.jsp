<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String log = (String) session.getAttribute("log");
	if (log == null) {
		response.sendRedirect("index.jsp");
	} else {
	%>

	<h1><%=log%>님 환영합니다</h1>
	<button onclick="location.href='./joinout'">회원탈퇴</button>
	<button onclick="location.href='./logout'">로그아웃</button>

	<%
	}
	%>

</body>
</html>