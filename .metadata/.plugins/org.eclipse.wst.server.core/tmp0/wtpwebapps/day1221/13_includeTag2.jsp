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
	request.setCharacterEncoding("utf-8");
	String siteName = request.getParameter("siteName");

%>
<jsp:include page="14_includeTagTop2.jsp">
	<jsp:param value="JSPStudy.co.kr" name="siteName"/>
</jsp:include>
include Action태그의 body입니다
<b><%=siteName %></b>

</body>
</html>