<%@page import="com.hellojava.business.UserService"%>
<%@page import="com.gellojava.web.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result="login.jsp";
	String userName=request.getParameter("userName");
    String userPwd=request.getParameter("userPwd");
    if(userName!=null && userPwd!=null){
    	User user=new User();
    	user.setUserName(userName);
    	user.setUserPwd(userPwd);
    	
    	UserService userService=new UserService();
    	boolean bool=userService.checkUser(user);
    	result=bool?"loadAll.jsp":"error.jsp";
    }
    response.sendRedirect(result);
%>