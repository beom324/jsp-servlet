<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>


	$(function(){
		
		var jobList;
		var dnoList;
		
		$.ajax({
			url :"listJob.do",
			success:(function(arr){
				jobList=arr;
	
				})
			})
		
		$.ajax({
			url :"listDno.do",
			success :(function(arr){
				dnoList=arr;

			})
		})	
			
			
		function addDno(){
			$.each(dnoList, function(){
				var option = $("<option></option>").html(this);
				$(option).attr("select",this);
				$("#select").append(option)
			})
		}
		
		
		function addJob(){
			$.each(jobList, function(){
				var option = $("<option></option>").html(this);
				$(option).attr("select",this);
				$("#select").append(option)
			})
		}
		
		
		$("#option").change(function(){
			$("#select").html(null);
			if($(this).val()=="job"){
				addJob();
				$("#search").css("display","none")
				$("#select").css("display","inline-block")
				$("#select").attr("name","search");
				$("#search").attr("name",null);
			}
			else if($(this).val()=="dno"){
				addDno();
				$("#search").css("display","none")
				$("#select").css("display","inline-block")
				$("#select").attr("name","search");
				$("#search").attr("name",null);
			}
			else{
				$("#select").css("display","none")
				$("#search").css("display","inline-block")
				$("#search").attr("name","search");
				$("#select").attr("name",null);
			}
			})
		}
	)
	
	
</script>
<style>
	#select{
		display:none;
	}
	.tr:hover{
		background-color: yellow
	}
	.a_home{
		text-decoration: none;
		
	}
	.a_home:visited{
		color : black;
		text-decoration: none;
		
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><a href="listEmp.do" class="a_home">사원목록</a></h1>
<form method="post" action="listEmp.do">
<select name="option" id="option">
	<option value="jumin">주민번호</option>
	<option value="ename">이름</option>
	<option value="job">직책</option>
	<option value="dno">부서번호</option>
	<option value="email">이메일</option>
</select>
<input type="text" name="search" id="search">
<select id="select" name="search">

</select>
<input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>직책</th>
		<th>입사일</th>
		<th>급여</th>
		<th>부서번호</th>
		<th>주민번호</th>
		<th>이메일</th>
	</tr>
	<c:forEach var="list" items="${list}">
	<tr class="tr">
		<td>${list.eno}</td>
		<td>${list.ename }</td>
		<td>${list.job }</td>
		<td>${list.hiredate }</td>
		<td>${list.salary }</td>
		<td>${list.dno }</td>
		<td>${list.jumin }</td>
		<td>${list.email }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>