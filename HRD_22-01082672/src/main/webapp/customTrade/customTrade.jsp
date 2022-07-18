<%@page import="java.sql.Date"%>
<%@page import="customTrade.CustomTradeDAO"%>
<%@page import="customTrade.CustomTradeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 매출 조회</title>
</head>
<body>
	<%
	// 회원정보 리스트를 볼 수 있는 곳입니다
	int input_userCode = Integer.parseInt((String) request.getParameter("custno"));
	ArrayList<CustomTradeDTO> customTradeDTOs = CustomTradeDAO.getInstance().getCustomTradeDTOs(input_userCode);
	System.out.println("customTradeDTOs배열 길이 : " + customTradeDTOs.size());
	
	%>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1> <%=input_userCode %>님의 매출정보 명세서</h1>
	<input type="button" value="회원정보" onclick="location.href='index'"> 
	<table>
		<tr>
			<td>custno</td>
			<td>salenol</td>
			<td>pcost</td>
			<td>amount</td>
			<td>price</td>
			<td>pcode</td>
			<td>sdate</td>
		</tr>
		
		<%for(int i = 0; i < customTradeDTOs.size(); i++) { 
			CustomTradeDTO customData = customTradeDTOs.get(i);
			
			int custno = customData.getCustno();
			int salenol = customData.getSalenol();
			int pcost = customData.getPcost();
			int amount = customData.getAmount();
			int price = customData.getPrice();
			String pcode = customData.getPcode();
			Date sdate = customData.getSdate();
			
			//test
			System.out.println("custno" + custno);
			
			%>
			<tr>
				<td><a href="customUpdate?salenol=<%=salenol%>"><%=custno %></a></td>
				<td><%=salenol %></td>
				<td><%=pcost %></td>
				<td><%=amount %></td>
				<td><%=price %></td>
				<td><%=pcode %></td>
				<td><%=sdate %></td>
			</tr>
		<% } %>	
	</table>
	<jsp:include page="/module/footer.jsp"></jsp:include>

</body>
</html>