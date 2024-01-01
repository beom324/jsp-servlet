<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LifeCycle" method="get">
	<input type = submit value="get">
</form>
<form action="LifeCycle" method="post">
	<input type = submit value="post">
</form>
<form action="hello" method="get">
   title : <input type="text" name="title">
   year  : <input type="text" name="year">
   <input type="submit" value="get방식의 요청">
</form>
<form action="hello" method="post">
   title : <input type="text" name="title">
   year  : <input type="text" name="year">
   <input type="submit" value="post방식의 요청">
</form>

<!-- 아래같은 방법을 쿼리스트림 -->
<a href="hello?title=hello&year=2023">get방식의 요청</a>
</body>
</html>