<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	*{
		align : center;
	}
	th,td{
		text-align : center;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 목록</h2>
<hr>
<table border="1" width="80%">
	<tr>
		<th width="10%">글번호</th>
		<th width="40%">글제목</th>
		<th width="20%">작성자</th>
		<th width="10%">작성일자</th>
	</tr>
	<c:forEach var="b" items="${list}"> <!-- 서블릿에서 상태유지한 list의 값을 하나씩 꺼내서 b에 담아라-->
		<tr>
			<td>
				${b.no}
			</td>
			<td><c:if test="${b.b_level > 0 }">
					<c:forEach var="i" begin="1" end="${b.b_level }">
						&nbsp;&nbsp;&nbsp;
					</c:forEach>	
					<img src="re.png">			
				</c:if>
				<a href="boardDetail.do?no=${b.no}">${b.title }</a></td>
			<td>${b.writer }</td>
			<td>${b.regdate }
		</tr>
		</c:forEach>
</table>
		<a href="insertBoard.do" value="글등록">글등록</a>
		
</body>
</html>