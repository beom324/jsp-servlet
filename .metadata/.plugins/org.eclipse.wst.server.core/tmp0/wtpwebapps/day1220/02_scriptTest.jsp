<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String title = "쌍용강북교육센터";
	int age = 20;
	
	public int addData(int data){
		return data +1;
		
	}
	
	/* if(age==20){
		title = "ok";
	}*/
%>
	<%
		String result = "";
		int year = 2023;
		if(year == 2023){
			result ="hello 2023";
		}
	%>
	
	result : <%=result %>
	year : <%=addData(year) %>
	title <%=title %>
	<hr>
	age : <%=addData(age) %>
	year :<%=addData(year)%>
</body>
</html>