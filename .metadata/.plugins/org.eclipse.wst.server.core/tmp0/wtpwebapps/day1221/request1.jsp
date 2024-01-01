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
	//한글데이터도 받아 올 수 있도록 인코딩을 설정합니다.
	request.setCharacterEncoding("utf-8");

	//사용자가 입력한 이름을 받아와서 변수에 저장합니다.
	//html태그에서 사용자가 입력한 값을 받아 오기 위하여
	//request라는 jsp내장 객체의 getParameter메소드를 이용합니다.
	//이때 매개변수로 html태그의 이름을 써 줍니다
	//getParameter메소드는 읽어온 데이터를 문자열(String) 으로 반환합니다
	String name = request.getParameter("name");
	
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
	
	if(gender.equals("man")){
		gender ="남자";
	}else{
		gender = "여자";
	}	
%>
<h1>Request Example1</h1>
성명 :<%=name %><br>
학번 : <%=studentNum %><br>
성별 : <%=gender %><br>
학과 : <%=major %>



</body>
</html>