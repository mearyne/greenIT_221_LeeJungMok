<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<% // session에서 현재 열리는 게시글을 확인해준다
		BoardDAO dao = BoardDAO.getInstance();
		
		int boardCode = Integer.parseInt( request.getParameter("code"));	
		BoardDTO data = dao.bringBoardData(boardCode);
		
		
	
	%>

    <h1>GREEN BOARD</h1>
    <div class="formContainer">
        <form>
            <input type="text" id="title" name="title" value="<%=data.getTitle()%>" required readonly><br>
            <textarea name="contents" required readonly><%=data.getContents() %></textarea><br>
            <input type="button" value="뒤로가기">
            <input type="button" value="좋아요">
            <input type="button" value="수정하기">
        </form>
    </div>
</body>

</html>