<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>정답</td>
			<td>사용자값</td>
			<td>정오표</td>
		</tr>
		<%
		int score = 100;
		for (int i = 1; i <= 5; i++) {
			String str1 = String.format("answer%s", i);
			String str2 = String.format("inputAnswer%s", i);

			int answer = Integer.parseInt((String) request.getParameter(str1));
			int inputAnswer = Integer.parseInt((String) request.getParameter(str2));

			String chk = "O";
			if (answer != inputAnswer) {
				chk = "X";
				score -= 20;
			}
		%>

		<tr>
			<td><%=i%></td>
			<td><%=answer%></td>
			<td><%=inputAnswer%></td>
			<td><%=chk%></td>
		</tr>

		<%
		}
		%>
		<tr>
		</tr>

	</table>
	<h1>
		당신의 점수는
		<%=score%>점 입니다
	</h1>

</body>
</html>