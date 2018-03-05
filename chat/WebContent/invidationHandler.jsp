<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.hellojava.web.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("currentUser")!=null){
		User user=(User)session.getAttribute("currentUser");
		if(application.getAttribute("userList")!=null){
			Set<User> userList=(Set<User>)application.getAttribute("userList");
			Iterator<User> userIter=userList.iterator();
			while(userIter.hasNext()){
				if(userIter.next().equals(user)){
					userIter.remove();
					break;
				}
			}
			application.setAttribute("userList", userList);
		}
		//当前当前session强制失效(session失效1:客户端的浏览器关闭(id丢失) session.invalidate()强制让服务器的session空间销毁 session默认的失效时间到了(30分钟))
		session.invalidate();
		out.println("<script type='text/javascript'>parent.location.href='login.jsp';</script>");
	}
%>