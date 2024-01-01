<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="regBean" class="com.sist.vo.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="regBean"/>
<table width="80%" align="center" cellpadding="5" cellspacing="0">
	<tr>
		<td align="center" valign="middle" bgcolor="#ffffcc">
			<table border="1" width="90%" cellspacing="0" cellpadding="2" align="center">
				<form name="regForm" method="post" action="memberInsert.jsp">
					<tr align="center" bgcolor="#996600">
						<td colspan="2">
							<font color="#ffffff">
								<b>
									<jsp:getProperty property="name" name="regBean"/>회원님이 작성하신 내용입니다. 확인해주세요
								</b>
							</font>
						</td>
					</tr>
					<tr>
						<td width="24%">아이디</td>
						<td width="41%">
							<jsp:getProperty property="id" name="regBean"/>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<jsp:getProperty property="pwd" name="regBean"/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<jsp:getProperty property="name" name="regBean"/>
						</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td>
							<jsp:getProperty property="birthday" name="regBean"/>
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<jsp:getProperty property="email" name="regBean"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="확인완료">&nbsp
							<input type="reset" value="다시쓰기" onclick="history.back()">
						</td>
					</tr>
				</form>
			</table>
		</td>
	</tr>
	
</table>
</body>
</html>