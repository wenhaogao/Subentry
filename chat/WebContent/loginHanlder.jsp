<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.hellojava.business.UserService"%>
<%@page import="com.hellojava.web.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//修改reqeust的默认字符串
	request.setCharacterEncoding("utf-8");
    String name=request.getParameter("userName");
    String pwd=request.getParameter("userPwd");
    String result="login.jsp";
    if(name!=null && pwd!=null){
    	User user=new User();
    	user.setUserName(name);
    	user.setUserPwd(pwd);
    	
    	UserService userService=new UserService();
    	boolean bool=userService.checkUser(user);
    	if(bool){
    		Set<User> userList=null;
    		if(application.getAttribute("userList")!=null){
    			userList=(HashSet<User>)application.getAttribute("userList");
    		}else{
    			userList=new HashSet<>();
    		}
    		if(!userList.contains(user)){
    			session.setAttribute("currentUser", user);
    			userList.add(user);
    			result="index.jsp";
    			application.setAttribute("userList",userList);
    		}else{
    			result="login.jsp?type=1";
    		}
    	}else{
    		result="error.jsp";
	   	}
    }
    response.sendRedirect(result);
    
%>