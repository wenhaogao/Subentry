<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hellojava.web.entity.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String messageContent=request.getParameter("messageContent");
	String userName=request.getParameter("userName");
	if(messageContent!=null && userName!=null){
		Message m=new Message();
		m.setMessageContent(messageContent);
		m.setUserName(userName);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		m.setSendDate(sdf.format(new Date()));
		
		List<Message> ms=null;
		
		if(application.getAttribute("messages")!=null){
			ms=(List<Message>)application.getAttribute("messages");
		}else{
			ms=new ArrayList<>();
		}
		
		ms.add(m);
		
		application.setAttribute("messages", ms);
		response.sendRedirect("inner/sendMessage.jsp");
	}
%>