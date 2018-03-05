<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div style="margin: auto; margin-top: 100px; width: 300px;">
		<form action="loginHandler.jsp" method="post" id="loginForm">
			<table style="width:100%;" cellspacing="10">
				<tr>
					<td align="right">账号:</td>
					<td>
						<input type="text" name="userName"/>
					</td>
					<td id="userNameInfo"></td>
				</tr>
				<tr>
					<td align="right">密码:</td>
					<td>
						<input type="password" name="userPwd"/>
					</td>
					<td id="userPwdInfo"></td>
				</tr>
				<tr>
					<td colspan="3" align="right" style="padding-right: 50px;">
						<input type="submit" value="确定"/>
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>