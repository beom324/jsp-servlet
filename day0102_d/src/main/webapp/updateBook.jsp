<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="updateBookOK.do" enctype="multipart/form-data">
<input type="hidden" name="bookid" value="${vo.bookid}">
제목 : <input type="text" name ="title" value="${vo.bookname }">
가격 : <input type="number" name = "price" value="${vo.price }">
출판사 : <input type = "text" name ="publisher" value="${vo.publisher }">
<img src="./bookImages/${vo.fname}" width="50" height="50"><br>
도서사진 : <input type="file" name="uploadFile"><br>
<input type="hidden" value="${vo.fname }">
<input type="submit" value="수정">
</form>
</body>
</html>