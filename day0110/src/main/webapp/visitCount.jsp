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
	int count =0;

	Cookie []cookies = request.getCookies();//getCookie는 배열을반환함
	if(cookies !=null) {
		for(Cookie c:cookies){
			String name = c.getName();
			String value = c.getValue();
			if(name.equals("visitCount")){
				count = Integer.parseInt(c.getValue());
			}
			
		}
	}
	count++;

	out.print(count+"번째 방문입니다");
	
	Cookie cookie = new Cookie("visitCount",count+""); // string 매개변수 2개를 받기때문에 int형변수에 +""을
														//을 붙혀서 string형으로 형변환해줌
	cookie.setMaxAge(5);															
														
	response.addCookie(cookie);
%>

</body>
</html>