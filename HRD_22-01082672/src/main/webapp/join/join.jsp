<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<%
	// 회원정보를 등록하는 곳입니다
	// custno	custname	phone	address	joindate	grade	city

	%>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1>가입하기</h1>
	<form method="post" action="joinAction">
		<input type="text" name="custname" placeholder="custname"><br>
		<input type="text" name="phone" placeholder="phone"><br>
		<input type="text" name="address" placeholder="address"><br>
		<input type="text" name="grade" placeholder="grade"><br>
		<input type="text" name="city" placeholder="city"><br>
		<input type="submit" value="가입하기">
	</form>
	
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>