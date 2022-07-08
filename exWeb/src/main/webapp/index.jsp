<%@page import="exWeb.UserDTO"%>
<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<%
	UserDAO dao = UserDAO.getInstance();
	if (dao.getConnection() != null) {
		System.out.println("데이터베이스 연동 완료");
	} else {
		System.out.println("데이터베이스 연동 실패");
	}
	%>
	
	<form method="post" action="./login">
		<input type="text" name="id" placeholder="아이디 입력" required>
		<input type="text" name="password" placeholder="비밀번호 입력" required>
		<div class="button">
			<input type="submit" value="로그인">
		</div>
	</form>


</body>
</html>