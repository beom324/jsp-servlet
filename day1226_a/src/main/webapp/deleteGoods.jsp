<%@page import="java.io.File"%>
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
	int re = -1;
	GoodsDAO dao = new GoodsDAO();
	String path = request.getRealPath("upload");
	int no = Integer.parseInt(request.getParameter("no"));
	String fname = dao.findByNo(no).getFname();
	File file = new File(path+"/"+fname);
	re = dao.deleteGoods(no);
	
	if(re==1){
		out.print("상품이 삭제되었습니다");
		file.delete();
	}else{
		out.print("삭제에 실패하였습니다");
	}
	
	
	
%>
	<a href="listGoods.jsp">상품목록</a>
</body>
</html>