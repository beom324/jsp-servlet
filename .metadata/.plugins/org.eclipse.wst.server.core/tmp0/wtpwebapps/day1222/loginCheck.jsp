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
	if(session.getAttribute("idKey")==null){
		
		response.sendRedirect("login.html");

	}
	String id = (String)session.getAttribute("idKey");
	
%>
<h1><%=id %>님 로그인하셨씁니다</h1>
<a href="logout.jsp">로그아웃</a>
<hr>
</body>
</html>