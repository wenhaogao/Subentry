<%@page import="com.hellojava.web.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: auto; width: 400px; margin-top: 50px;">
		<form action="../messageHandler.jsp" method="post">
			<input type="text" name="messageContent" style="width: 200px;">
			<input type="hidden" name="userName" value="<%=((User)(session.getAttribute("currentUser"))).getUserName()%>">
			<input type="submit" value="发送"/>
		</form>
	</div>
</body>
</html>