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

	//프로토콜을 읽어옵니다
	String protocol = request.getProtocol();
	//서버의 이름을 읽어옵니다
	String serverName = request.getServerName();
	//서버포트번호를 읽어옵니다
	int serverPort = request.getServerPort();
	//요청한 클라이언트의 ip주소를 갖고옵니다
	String remoteAddr = request.getRemoteAddr();
	//서비스 요청방식을 읽어옵니다
	String method = request.getMethod();
	//클라이언트가 웹브라우저에 입력한 주소표시줄의 내용을 http부터 모두 읽어옵니다
	StringBuffer requestURL = request.getRequestURL();
	//클라이언트가 웹브라우저의 입력한 주소표시의 내용중에 컨텍스트명부터 읽어옵니다.
	String requestURI = request.getRequestURI();
	//클라이언트의 접속한 웹브라우저의 정보를 읽어옵니다
	String userBrowser = request.getHeader("User-Agent");
	//클라이언트가 접속한 웹브라우저가 지원가능한 파일타입을 모두 읽어 옵니다.
	String fileType = request.getHeader("Accept");
	
	
%>
<h1>Request Example2</h1>
프로토콜 : <%=protocol %><br>
서버이름 : <%=serverName %><br>
서버포트번호 :<%=serverPort %><br>
사용자 컴퓨터의 ip주소 : <%=remoteAddr %><br>
서비스 요청방식 : <%=method %><br>
url : <%=requestURL %><br>
uri : <%=requestURI %><br>
브라우저 정보 :<%=userBrowser %><br>
지원가능한 파일타입 : <%=fileType %><br>
</body>
</html>