<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="80%">

	<tr>
		<th width="10%">책번호</th>
		<th width="30%">책이름</th>
		<th width="10%">가격</th>
		<th width="20%">출판사</th>
		<th width="10%">삭제</th>
		
	</tr>
	<c:forEach var="list" items="${list}" >
	<tr>
		<td><a href="detailBook.do?bookid=${list.bookid}">${list.bookid}</a></td>
		<td>${list.bookname}</td>
		<td>${list.price}</td>
		<td>${list.publisher}</td>
		<td><a href="deleteBook.do?bookid=${list.bookid}">삭제</a></td>
		
	</tr>
	</c:forEach>
</table>
<a href="insertBook.do">등록</a>
</body>
</html>