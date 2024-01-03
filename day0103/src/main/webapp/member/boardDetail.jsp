
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 상세</h2>
	<hr>
	글번호 : ${vo.no }<br>
	글제목 : ${vo.title }<br>
	작성자 : ${vo.writer }<br>
	글내용 : <br>
	<textarea rows="10" cols="80" readonly="readonly">${vo.content }</textarea>	
	<br>
	조회수 : ${vo.hit }<br>
	등록일 : ${vo.regdate }<br>
	첨부파일 : ${vo.fname }<br>
	<hr>
	<a href="insertBoard.do">글 등록</a>
	&nbsp;
	<a href="listBoard.do">글 목록</a>
	<a href="updateBoard.do?no=${vo.no}">수정</a>
	<a href="deleteBoard.do?no=${vo.no}">삭제</a>
</body>
</html>
