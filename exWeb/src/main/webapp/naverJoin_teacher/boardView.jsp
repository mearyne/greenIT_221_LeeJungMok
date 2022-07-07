<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="CSS/board.css">
<title>BOARD VIEW</title>
</head>

<body>
	<%
	// 주소창에 게시글 code값이 제대로 입력이 될것이다
	BoardDAO dao = BoardDAO.getInstance();

	int boardCode = Integer.parseInt(request.getParameter("code"));
	BoardDTO data = dao.bringBoardData(boardCode);
	%>

	<h1>GREEN BOARD</h1>
	<div class="formContainer">
		<form>
			<input type="text" id="title" name="title" value="<%=data.getTitle()%>" required readonly><br>
			<textarea name="contents" required readonly><%=data.getContents()%></textarea><br> 

			<input type="button" value="뒤로가기" onclick='location.href=`boardPro.jsp`'> 
			
			<input type="button" value="좋아요" onclick="alert(`좋아요!`); location.href=`boardLikePro.jsp?code=<%=boardCode%>`">

			<!-- 수정하기를 누르면 해당 BoardDTO data를 가지고 수정하는 페이지로 넘어가야한다 -->
			<input type="button" value="수정하기" onclick='alert(`수정했습니다`); location.href=`boardUpdateForm.jsp?code=<%=boardCode%>`'>

			<!-- 수정하기를 누르면 해당 BoardDTO data를 가지고 삭제하는 페이지로 넘어가야한다 -->
			<input type="button" value="삭제하기" onclick='alert(`삭제했습니다`); location.href=`boardDeletePro.jsp?code=<%=boardCode%>`'>
		</form>
	</div>

</body>

</html>