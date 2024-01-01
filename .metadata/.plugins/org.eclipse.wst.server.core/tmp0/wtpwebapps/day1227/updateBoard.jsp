<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 수정</h2>
	<form method="post" action="updateBoard"  enctype="multipart/form-data" >
		제목 : <input type="text" name="title" value="${b.title }"><br>
		<input type="hidden" name = "no" value="${b.no}">
		작성자 : ${vo.writer}<br>
		비밀번호 : <input type="password" name ="pwd"><br>
		<hr>
		<textarea rows="30" cols="30" name="content">${b.content}</textarea><br>
		첨부파일 : <input type="file"name="uploadFile">${b.fname}
				<input type="hidden" value="${b.fname }">
		<br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>