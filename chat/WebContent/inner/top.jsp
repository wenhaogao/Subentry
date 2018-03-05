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
	<span style="display: block; margin:auto; margin-right: 0px; width:200px;">
		你好:<%=((User)session.getAttribute("currentUser")).getUserName() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="../invidationHandler.jsp" style="text-decoration: none;color:#000000;">注销</a>
	</span>
</body>
</html>