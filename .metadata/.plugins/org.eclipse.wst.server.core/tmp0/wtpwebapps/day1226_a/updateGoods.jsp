<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.sist.dao.GoodsDAO"%>
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
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDAO dao = new GoodsDAO();
	GoodsVO g = dao.findByNo(no);
%>
	<h2>상품수정</h2>
	<hr>
	<form action="updateGoodsOK.jsp" method="post" enctype="multipart/form-data">
		<table width="80%">

			<tr>
				<td width="30%">상품가격</td>
				<td width="70%"><input type="number" name="price" value="<%=g.getPrice() %>" required="required"></td>
			</tr>
			<tr>
				<td width="30%">상품이름</td>
				<td width="70%">
				<input type="hidden" name="no" value="<%=g.getNo()%>">
				<input type="text" name="name" value="<%=g.getName() %>" required="required"></td>
			</tr>
			<tr>
				<td width="30%">상품수량</td>
				<td width="70%"><input type="text" name="qty"  value="<%=g.getQty() %>" required="required"></td>
			</tr>
			<tr>
				<td width="30%">상품파일</td>
				<td width="70%">
				<input type="hidden" name="fname" value="<%=g.getFname()%>">
				<img src="./upload/<%=g.getFname()%>" width="50" height="50">
				<input type="file" name="uploadFile"  value="<%=g.getFname() %>">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="취소">
				</td>
			</tr>
		
		</table>
	
	</form>
</body>
</html>