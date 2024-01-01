<%@page import="com.sist.vo.BoardVO"%>
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
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="com.sist.vo.BoardVO"/>
<jsp:useBean id="dao" class="com.sist.dao.BoardDAO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	vo.setIp(request.getRemoteAddr());
	int re = dao.insertBoard(vo);
	String msg ="게시물 등록에 성공하였습니다";
	if (re!=1){
		msg="게시물 등록에 실패하였습니다";
		
	}
	out.print(msg);
%>
<a href="insertBoard.html">게시물 등록</a>
</body>
</html>