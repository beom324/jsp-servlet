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
	request.setCharacterEncoding("UTF-8");
	
	int count = 0;

	String msg = request.getParameter("msg");
	int num = Integer.parseInt(request.getParameter("number"));
	
	while(count <num){
		
		out.print(msg+"<br>");
		count++;
	}
	
%>
</body>
</html>