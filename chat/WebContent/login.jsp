<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: auto;width: 400px; margin-top: 100px;">
		<%if(request.getParameter("type")!=null){
			if(Integer.parseInt(request.getParameter("type"))==1){
				out.println("<font color='red'>用户已登陆,请先注销在登陆</font>");
			}
		} %>
		<form action="loginHanlder.jsp" method="post">
			<table style="width:100%" cellspacing="10">
				<tr>
					<td align="right">账号:</td>
					<td>
						<input type="text" name="userName"/>
					</td>
				</tr>
				<tr>
					<td align="right">密码:</td>
					<td>
						<input type="password" name="userPwd"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="确定"/>
						<input type="reset" value="取消"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>