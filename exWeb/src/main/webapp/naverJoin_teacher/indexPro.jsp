<%@page import="exWeb.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	// .../indexPro.jsp?id=***
	//	String id = (String) request.getParameter("id"); // 이전 페이지로부터 받은 요청 확인
	//	response.getWriter().println(id); // 응답

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		UserDAO dao = UserDAO.getInstance();
		String userId = request.getParameter("id");
		String userPw = request.getParameter("password");
		
		System.out.println(userId);
		System.out.println(userPw);
	
		if(dao.checkIdPw(userId, userPw)) {
			 session.setAttribute("log", userId);
			 response.sendRedirect("mainPage.jsp");
			// request.setAttribute("log",userId);
			// request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		} else { %>
			<script>alert('안되!'); location.href="form_agree.jsp"; </script>
			<%
			// 1. 단순 리다이렉트
			//response.sendRedirect("form_agree.jsp");
			// 이것들은 파라미터를 이용하기 힘들다
			
			// 2. 이전 페이지에서 가지고 온 request & response 객체를 다음 페이지로 전달 (한번만 작동된다)
			// requset.setAttribute("log", user.getId());
			// request.getRequestDispatcher("이동할페이지").forword(request, response);
			// request와 response를 "이동할페이지"로 이동시킨다
			// request.getAttribute("log"); 로 값을 받는다
			
			// 3. 톰켓 세션을 활용한 session 에 로그 정보 넣기
			// 로그아웃(remove) 전까지 getAttribute를 사용해서 값을 얻을 수 있다.
			// sesstion.setAttribute("log", user.getId());
		}	
		%>
	
	<!-- 
 	<div name="id" value=<%=userId%>><%=userId %></div>
	<div name="pass" value=<%=userPw %>></div>
 	-->
 	
</body>
</html>