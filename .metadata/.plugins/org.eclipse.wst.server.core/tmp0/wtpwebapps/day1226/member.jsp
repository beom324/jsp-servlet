<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#996600">
	<table width ="500" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align ="center" valign="middle" bgcolor="#ffffcc">
				<table border="1" cellpadding="0" cellspacing="0" align="center">
					<form name="regForm" method="post" action="memberProc.jsp">
						<tr align="center" bgcolor="#996600">
							<td colspan="3">
								<font color="#ffffff"><b>회원가입</b></font>
							</td>
						</tr>
						<tr>
							<td width="100">아이디</td>
							<td width="200">
								<input type="text" name="id" size="15" required="required">
							</td>
							<td width="200">아이디를 적어주세요.</td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td>
								<input type="password" name="pwd" size="15" required="required">
							</td>
							<td>패스워드를 입력해주세요</td>
						</tr>
						<tr>
							<td>패스워드 확인</td>
							<td>
								<input type="password" name="repwd" size="15"required="required">
							</td>
							<td>패스워드를 입력해주세요</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>
								<input type="text" name="name" size="15"required="required">
							</td>
							<td>이름을 입력해주세요</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td>
								<input type="text" name="birthday" size="27"required="required">
							</td>
							<td>생년월일을 입력해주세요</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>
								<input type="email" name="email" size="20"required="required">
							</td>
							<td>이메일을 입력해주세요</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="submit" value="회원가입" onclick="inputCheck()">
								<input type="reset" value="다시쓰기">
							</td>
						</tr>
					</form>
				</table>
			</td>
		</tr>
	
	
	</table>

</body>
</html>