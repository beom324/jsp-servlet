<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnReadSession").click(function(){
		var v=sessionStorage.getItem("sessionStorage")
		$("#output_session").append(v)
	})
	
	$("#btnSaveSession").click(function(){
		var session = $("#input_session").val();
		sessionStorage.setItem("sessionStorage",session)
		alert(session+"을 저장하였습니다")
	})
	
	$("#btnReadlocal").click(function(){
		var v=localStorage.getItem("localStorage")
		$("#output_local").append(v)
	})
	
	$("#btnSavelocal").click(function(){
		var local = $("#input_local").val()
		localStorage.setItem("localStorage",local)
	})
});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

sessionStorage 출력 : <span id="output_session"></span>
<button id ="btnReadSession">sessionStorage 읽어오기</button>
<br>
sessionStorage 입력 : <input type="text" id="input_session">
<button id="btnSaveSession">sessionStorage 저장</button>
<hr>

localStorage 출력 : <span id="output_local"></span>
<button id ="btnReadlocal">localStorage 읽어오기</button>
<br>
localStorage 입력 : <input type="text" id="input_local">
<button id="btnSavelocal">localStorage 저장</button>
<hr>

</body>
</html>