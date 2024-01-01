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
	//문자열 변수 name을 선언합니다
	String name ="korea";
	int year = 2024;
	String title = "hello";
	
	
%>
<!--이것은 html 주석입니다 소스보기에 노출됩니다 -->
<%--
	이것은 jsp 주석입니다 소스보기에 노출되지 않아요
 --%>
 <%--<%=name /*이름이름이름이르밍르밍르미으리므*/ --%>
 <%=year/*year변수의 내용을 출력합니다*/%>
 <!-- <h2><%=title %><h2> -->
 	
</body>
</html>