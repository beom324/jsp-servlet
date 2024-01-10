<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
td{
	text-align: center;
}
#d_select{
		display:none;
	}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var deptName ;
		var mname;
		var job;
		$.ajax({
			url : "listDeptName.do",
			success : function(arr){
				deptName= arr;
			}
		})
		$.ajax({
			url : "listMname.do",
			success : function(arr){
				mname = arr;
			}
		})
		$.ajax({
			url : "listJob.do",
			success : function(arr){
				job = arr;
			}
		})
		
		function addDeptName(){
			$.each(deptName, function(){
				var option = $("<option></option>").html(this);
				$(option).attr("select",this);
				$("#d_select").append(option)
			})
		}
		function addMname(){
			$.each(mname, function(){
				var option = $("<option></option>").html(this);
				$(option).attr("select",this);
				$("#d_select").append(option)
			})
		}
		function addJob(){
			$.each(job, function(){
				var option = $("<option></option>").html(this);
				$(option).attr("select",this);
				$("#d_select").append(option)
			})
		}
		$("#select").change(function(){
			$("#d_select").html(null);
			if($(this).val()=="dname"){
				addDeptName();
				$("#search").css("display","none")
				$("#d_select").css("display","inline-block")
				$("#d_select").attr("name","search");
				$("#search").attr("name",null);
			}
			else if($(this).val()=="m.ename"){
				addMname();
				$("#search").css("display","none")
				$("#d_select").css("display","inline-block")
				$("#d_select").attr("name","search");
				$("#search").attr("name",null);
			}
			else if($(this).val()=="e.job"){
				addJob();
				$("#search").css("display","none")
				$("#d_select").css("display","inline-block")
				$("#d_select").attr("name","search");
				$("#search").attr("name",null);
			}
			else{
				$("#d_select").css("display","none")
				$("#search").css("display","inline-block")
				$("#search").attr("name","search");
				$("#d_select").attr("name",null);
			}
		})
		
		
	})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="listJoinEmp.do">
	<select name="select" id="select">
		<option value="e.ename">사원명</option>
		<option value="dname">부서명</option>
		<option value="m.ename">관리자명</option>
		<option value="e.job">직책</option>
	</select>
	<select id="d_select" name="d_select">
	</select>
	<input type="search" name="search" id="search">
	<input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<th>사원번호</th>
		<th>이름</th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>급여</th>
		<th>상여금</th>
		<th>고용일</th>
		<th>근무개월수</th>
		<th>관리자명</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>총 급여</th>
	</tr>
	<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.eno}</td>
		<td>${list.ename}</td>
		<td>${list.dno}</td>
		<td>${list.dname}</td>
		<td>${list.salary}</td>
		<td>${list.comm}</td>
		<td>
		<fmt:formatDate value="${list.hiredate}" pattern="yy-MM-dd"/>			
		</td>
		<td>${list.workday}</td>
		<td>${list.mname}</td>
		<td>${list.jumin}</td>
		<td>${list.email}</td>
		<td>${list.total}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>