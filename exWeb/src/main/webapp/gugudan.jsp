<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- 2~9�ܱ��� ��� --%>
	<%-- Ÿ��Ʋ h1 --%>
	<%-- ���� p --%>
	<%-- 
	<h1> 2~9��</h1>
	<% 
	// ��Ŭ��Ʋ��
	for(int i = 2; i < 9; i++){
		for(int j = 1; j < 9; j++){ 
		%>
			<p><%=i %> x <%=j %>  = <%=i * j%></p>
		 <%}
	}
	%>
	--%>

	<%-- ���� ������ ���� --%>
	<%-- ���� 10�� form --%>
	<%-- gugudanPro.jsp ������ ���� --%>
	<%-- �������� �Բ�, ����ǥ ��� --%>
	<%-- input type="hidden" name="quiz1" value="��������"--%>
	<form action="gugudanPro.jsp">
		<%@ page import="java.util.*"%>
		<table border="1" bordercolor="blue" width="500" height="300"
			align="center">
			<tr>
				<td>��ȣ</td>
				<td>����</td>
				<td>����</td>
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
					placeholder="������ �Է����ּ���"></td>
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