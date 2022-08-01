<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="../CSS/board.css">
<title>BOARD UPDATE</title>
</head>

<body>
	<%
	BoardDAO dao = BoardDAO.getInstance();
	int boardCode = Integer.parseInt(request.getParameter("code"));
	BoardDTO boardData = dao.bringBoardData(boardCode);
	%>

	<h1>GREEN BOARD</h1>
	<div class="formContainer">
		<form method="post" action="boardUpdateFormPro.jsp">
			<input type="text" id="title" name="title" value="<%=boardData.getTitle() %>" placeholder="title" required><br>
			<textarea name="contents" placeholder="contents text" required><%=boardData.getContents() %></textarea><br> 
			<input type="button" value="뒤로가기" onclick="location.href=`boardPro.jsp`"> 
			<input type="submit" value="글쓰기">
			<input type="hidden" name="boardCode" value=<%=boardCode %>>
		</form>
	</div>
</body>

</html>