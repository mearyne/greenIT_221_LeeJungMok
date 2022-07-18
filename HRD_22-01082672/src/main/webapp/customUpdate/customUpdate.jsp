<%@page import="java.sql.Date"%>
<%@page import="customTrade.CustomTradeDAO"%>
<%@page import="customTrade.CustomTradeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int input_salenol = Integer.parseInt((String) request.getParameter("salenol"));
	CustomTradeDTO customData = CustomTradeDAO.getInstance().getCustomTrade(input_salenol);
	
	int custno = customData.getCustno();
	int salenol = customData.getSalenol();
	int pcost = customData.getPcost();
	int amount = customData.getAmount();
	int price = customData.getPrice();
	String pcode = customData.getPcode();
	Date sdate = customData.getSdate();
	
	%>
	
	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1> 수정하기 </h1>
	<form method="post" action="updateTradeAction">
		<input type="hidden" name="custno" value=<%=custno %>>
		<input type="hidden" name="salenol" value=<%=salenol %>>
		<input type="text" name="pcost" placeholder="pcost"><br>
		<input type="text" name="amount" placeholder="amount"><br>
		<input type="text" name="price" placeholder="price"><br>
		<input type="text" name="pcode" placeholder="pcode"><br>
		<input type="text" name="sdate" placeholder="oooo-oo-oo"><br>
		<input type="submit" value="수정하기">
	</form>
	
	<jsp:include page="/module/footer.jsp"></jsp:include>

</body>
</html>