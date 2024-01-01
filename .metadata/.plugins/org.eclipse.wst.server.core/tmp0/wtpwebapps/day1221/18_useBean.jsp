<%@page import="com.sist.vo.BookVO"%>
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
	BookVO b = new BookVO();
	b.setBookId(10);
	b.setBookName("재미있는자바");
	b.setPrice(30000);
	b.setPublisher("쌍용미디어");
	
%>	
도서번호 :<%=b.getBookId() %><br>
도서명 :<%=b.getBookName() %><br>
도서가격 :<%=b.getBookName() %><br>
출판사 :<%=b.getPublisher() %>
</body>
</html>