<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		Date today = new Date();
		/*
		int year = today.getYear()+1900;
		int month = today.getMonth();
		int day = today.getDate();
		String strDate = year +"-"+ month +"-" + day;
		*/		
		SimpleDateFormat format = new SimpleDateFormat("YY-MM-dd");
		String strDate = format.format(today);		
	%>	
오늘날짜는 <%=strDate %>
</body>
</html>