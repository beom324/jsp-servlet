<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
td{
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>사원번호</th>
		<th>이름</th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>급여</th>
		<th>상여금</th>
		<th>고용일</th>
		<th>근무개월수</th>
		<th>관리자명</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>총 급여</th>
	</tr>
	<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.eno}</td>
		<td>${list.ename}</td>
		<td>${list.dno}</td>
		<td>${list.dname}</td>
		<td>${list.salary}</td>
		<td>${list.comm}</td>
		<td>${list.hiredate}</td>
		<td>${list.workday}</td>
		<td>${list.mname}</td>
		<td>${list.jumin}</td>
		<td>${list.email}</td>
		<td>${list.total}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>