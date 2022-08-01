<%@page import="custom.CustomDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="custom.CustomDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
</head>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1> 회원 정보 리스트 </h1>
	<input type="button" value="회원매출 조회" onclick='location.href=`customTrade`'>
	<%
	// 회원정보 리스트를 볼 수 있는 곳입니다
	
	ArrayList<CustomDTO> customDTOs = CustomDAO.getInstance().getCustomDTOs();
	System.out.println("배열 길이 : " + customDTOs.size());
	
	%>
	<input type="button" value="등록하기" onclick="location.href='join'">
	<table>
		<tr>
			<td>custno</td>
			<td>custname</td>
			<td>phone</td>
			<td>address</td>
			<td>joindate</td>
			<td>grade</td>
			<td>city</td>
		</tr>
		<%for(int i = 0; i < customDTOs.size(); i++) { 
			CustomDTO customData = customDTOs.get(i);
			
			int custno = customData.getCustno();
			String custname = customData.getCustname();
			String phone = customData.getPhone();
			String address = customData.getAddress();
			Date joindate = customData.getJoindate();
			String grade = customData.getGrade();
			String city = customData.getCity();
			
			//test
			System.out.println("custno" + custno);
			
			%>
			<tr>
				<td><a href="customTrade?custno=<%=custno%>"><%=custno %></a></td>
				<td><%=custname %></td>
				<td><%=phone %></td>
				<td><%=address %></td>
				<td><%=joindate %></td>
				<td><%=grade %></td>
				<td><%=city %></td>
			</tr>
		<% } %>
	</table>
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>