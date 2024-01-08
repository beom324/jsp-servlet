<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		$.ajax({
			type : "GET",
			url : "listPublisher.do",
			data : ${json},
			success : function(data){
				alert(data);
			}
		
		})
		
		$("#option").change(function (){
			var v = $(this).val();
			if(v == "price"){
				$("#oper").css("display","inline-block");
			}else{
				$("#oper").css("display","none");
			}
			if(v=="publisher"){
				$("#publisher").css("display","inline-block");
			}else{
				$("#publisher").css("display","none");
			}									
		});
		
		
			
	})
	
</script>
<style>
	#publisher{
		display:none;
	}
	#oper{
		display: none;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서목록</h2>
<form method="post" action="listBook.do">
	<select name="option" class="option" id="option"><option value="bookName">도서명</option><option value="publisher">출판사</option><option value="price">가격</option></select>
	<select name="publisher" class="publisher" id="publisher">
		<option id="combo"></option>
	</select>
	<select name="oper" class="oper" id="oper">
		<option value=">">></option><option value="<"><</option><option value=">=">>=</option><option value="<="><=</option><option value="=">=</option>
		
	</select>
	<input type="text" name="search">
<input type="submit" value="검색">



</form> 
<table border="1">
	<tr>
		<th><a href="listBook.do?sort=bookid">도서번호</a></th>
		<th><a href="listBook.do?sort=bookname">도서명</a></th>
		<th><a href="listBook.do?sort=price">가격</a></th>
		<th><a href="listBook.do?sort=publisher">출판사</a></th>
	</tr>
	<c:forEach var="list" items="${list}">
	<tr>
		<td>${list.bookid}</td>
		<td>${list.bookname }</td>
		<td>${list.price }</td>
		<td>${list.publisher }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>