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
	//	String id = (String) request.getParameter("id"); // ���� �������κ��� ���� ��û Ȯ��
	//	response.getWriter().println(id); // ����

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
			<script>alert('�ȵ�!'); location.href="form_agree.jsp"; </script>
			<%
			// 1. �ܼ� �����̷�Ʈ
			//response.sendRedirect("form_agree.jsp");
			// �̰͵��� �Ķ���͸� �̿��ϱ� �����
			
			// 2. ���� ���������� ������ �� request & response ��ü�� ���� �������� ���� (�ѹ��� �۵��ȴ�)
			// requset.setAttribute("log", user.getId());
			// request.getRequestDispatcher("�̵���������").forword(request, response);
			// request�� response�� "�̵���������"�� �̵���Ų��
			// request.getAttribute("log"); �� ���� �޴´�
			
			// 3. ���� ������ Ȱ���� session �� �α� ���� �ֱ�
			// �α׾ƿ�(remove) ������ getAttribute�� ����ؼ� ���� ���� �� �ִ�.
			// sesstion.setAttribute("log", user.getId());
		}	
		%>
	
	<!-- 
 	<div name="id" value=<%=userId%>><%=userId %></div>
	<div name="pass" value=<%=userPw %>></div>
 	-->
 	
</body>
</html>