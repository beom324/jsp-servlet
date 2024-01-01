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
	String season = request.getParameter("season");
	String fruit = request.getParameter("fruit");
	
	String id = (String)session.getAttribute("idKey");
	//세션에 저장된 값을 읽어와서 변수에 저장합니다.
	
	int intervalTime = session.getMaxInactiveInterval();
	//세션의 유효시간을 읽어와서 변수에 저장합니다.
	
	
	
	if(id != null){
		out.print(id+"님이 좋아하는 계절은" + season+ "이고");
		out.print(id+"님이 좋아하는 과일은" + fruit + "입니다");
	}else{
		out.print("세션의 시간이 경과를 하였거나 다른 이유로 연결을 할 수 없습니다");
	}
	
%>
</body>
</html>