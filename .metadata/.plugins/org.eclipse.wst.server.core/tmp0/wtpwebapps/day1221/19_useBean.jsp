<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="b" class="com.sist.vo.BookVO"/>
<jsp:useBean id="dao" class="com.sist.dao.BookDAO"/>
<jsp:setProperty property="bookId" name="b" value="100"/>
<jsp:setProperty property="bookName" name="b" value="재미있는 자바"/>
<jsp:setProperty property="price" name="b" value="30000"/>
<jsp:setProperty property="publisher" name="b" value="쌍용미디어"/>

<jsp:getProperty name="b" property="bookId"/>
<jsp:getProperty name="b" property="bookName"/>
<jsp:getProperty name="b" property="price"/>
<jsp:getProperty name="b" property="publisher"/>

<%
	dao.insertBook(b);
%>
</body>
</html>