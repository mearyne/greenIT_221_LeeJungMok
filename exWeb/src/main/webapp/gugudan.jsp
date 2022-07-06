<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 2~9단까지 출력 --%>
	<%-- 타이틀 h1 --%>
	<%-- 내용 p --%>
	<%-- 
	<h1> 2~9단</h1>
	<% 
	// 스클립틀릿
	for(int i = 2; i < 9; i++){
		for(int j = 1; j < 9; j++){ 
		%>
			<p><%=i %> x <%=j %>  = <%=i * j%></p>
		 <%}
	}
	%>
	--%>

	<%-- 랜덤 구구단 퀴즈 --%>
	<%-- 문제 10개 form --%>
	<%-- gugudanPro.jsp 페이지 예시 --%>
	<%-- 정답지와 함께, 성적표 출력 --%>
	<%-- input type="hidden" name="quiz1" value="숨겨진값"--%>
	<form action="gugudanPro.jsp">
		<%@ page import="java.util.*"%>
		<table border="1" bordercolor="blue" width="500" height="300"
			align="center">
			<tr>
				<td>번호</td>
				<td>문제</td>
				<td>정답</td>
			</tr>
			<%
			for (int i = 1; i <= 5; i++) {
				Random rand = new Random();
				int rNum1 = rand.nextInt(8) + 1;
				int rNum2 = rand.nextInt(8) + 1;
				int answer = rNum1 * rNum2;
			%>
			<tr>
				<td><%=i%></td>
				<td><%=rNum1%> x <%=rNum2%></td>
				<td><input type="text" name="inputAnswer<%=i%>"
					placeholder="정답을 입력해주세요"></td>
				<input type="hidden" name="answer<%=i%>" value=<%=answer%>>
			</tr>
			<%
			}
			%>
		</table>
		<input type="submit">
	</form>

</body>
</html>