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
	<c:if test="${userID ne null }">${userID }님 로그인 하셨습니다</c:if>
	<a href="/day0105/member/listBoard.do">전체 글 보기</a>
	<c:choose>
	<c:when test="${userID eq null}"><a href="login.do">로그인</a></c:when>
	<c:when test="${userID ne null}"><a href="/day0105/logout.do">로그아웃</a></c:when>
	</c:choose>
	<c:if test="${userID ne null }"><a href="/day0105/member/listBoard.do?writer=${userID}">내글보기</a></c:if>
	&nbsp;
	<a href="/day0105/member/insertBoard.do">게시물 등록</a>
</body>
</html>