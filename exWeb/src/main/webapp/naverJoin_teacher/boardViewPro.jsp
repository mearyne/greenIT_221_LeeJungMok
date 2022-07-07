<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bring board data to view contents</title>
</head>
<body>
	<%
		// 여기에 내가 클릭한 게시글 정보를 가져올 수 있으면 된다.
		// 어떻게 여기에 가져오는가? 
				
		// 데이터를 읽어오기 위해서는 자바가 필요하다(.JSP)
		// 자바스크립트에서 JSP쪽으로 데이터를 넘겨줄 수 있는가? 노!
	%>
	
	<form name="myHiddenForm" action="boardViewPro.jsp">
	     <input type="hidden" name="boardCode" value=`session.getAttribute('boardRunning')`>
	</form>
	
     <script>
     	document.myHiddenForm.submit();
     </script>


</body>
</html>