
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv=X-UA-Compatible content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="CSS/board.css">
<title>BOARD LIST</title>

</head>

<body>
	<h1>GREEN BOARD</h1>
	<div class="boardListContainer">
		<table border="1">
			<thead>
				<tr>
					<th>no</th>
					<th>code</th>
					<th>title</th>
					<th>viewCnt</th>
					<th>likeCnt</th>
					<th>createdAt</th>
					<th>modifiedAt</th>
				</tr>
			</thead>
			<tbody>
				<%
				String string = (String) session.getAttribute("hiddenString");
				out.println(string); // 게시글들이 일괄 추가된다
				%>
		</table>
		</tbody>
	</div>
		<form>
			<input type="button" value="글 쓰기" onclick="location.href='boardWrite'">
			<input type="button" value="새로고침" onclick="location.href=`board`">
		</form>
	<script src="JS/board.js"></script>
</body>

</html>