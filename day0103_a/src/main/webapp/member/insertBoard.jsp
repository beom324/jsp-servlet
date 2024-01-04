<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="insertBoard.do"  enctype="multipart/form-data" >
		제목 : <input type="text" name="title"><br>
		작성자 : <input type = "text" name="writer" value="${userID }"><br>
		비밀번호 : <input type="password" name ="pwd"><br>
		<hr>
		<textarea rows="30" cols="30" name="content"></textarea><br>
		첨부파일 : <input type="file"name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>