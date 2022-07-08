<%@page import="exWeb.UserDTO"%>
<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/form.css">
<title>로그인 창</title>
</head>
<body>
	<form method="post" action="login">
		<input type="text" name="id" placeholder="아이디 입력" required>
		<input type="text" name="password" placeholder="비밀번호 입력" required>
		<div class="button">
			<input type="submit" value="로그인">
		</div>
		<input type="submit" value="회원가입" onclick="location.href=`agree`">
	</form>

</body>
</html>