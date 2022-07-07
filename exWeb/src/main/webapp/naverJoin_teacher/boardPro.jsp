<%@page import="com.sun.jdi.Location"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 여기서 데이터를 받아서 String으로 잘 정리한다.
	// 그 String을 hidden 타입의 객체에 담아서 board.jsp로 넘긴다
	// board.jsp에서 String string = request.getParameter("hiddenString");으로 값을 받는다
	// out.println(string);으로 출력한다

	BoardDAO dao = BoardDAO.getInstance();
	ArrayList<Integer> codeList = dao.bringAllCode();

	String string = "";
	if (codeList.size() != 0) {
		for (Integer sqlCode : codeList) {
			BoardDTO boardData = dao.bringBoardData(sqlCode);

			int no = boardData.getNo();
			int code = boardData.getCode();
			String title = boardData.getTitle();
			int viewCnt = boardData.getViewCnt();
			int likeCnt = boardData.getLikeCnt();
			Timestamp createAt = boardData.getCreateAt();
			Timestamp modified = boardData.getModified();

			// 테스트용
			System.out.println(code);

			string += String.format("<tr><td>%d</td><td>%d</td><td><div onclick='location.href=`boardView.jsp?code=%d`'>%s</div></td><td>%d</td><td>%d</td><td>%d</td><td>%d</td></tr>", no, code, code ,title, viewCnt, likeCnt, 0, 0);
			
		}
	}
	System.out.println(string);
	session.setAttribute("hiddenString", string);
	%>
	<!-- 	<input type="hidden" name="hiddenString" value=<%=string%>>
 -->
	<script>
		location.href = 'board.jsp'
	</script>

</body>
</html>