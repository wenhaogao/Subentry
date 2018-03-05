<%@page import="java.util.Iterator"%>
<%@page import="com.gellojava.web.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result="error.jsp";
	String[] ids=request.getParameterValues("ids");
	if(ids!=null && ids.length>0){
		for(String id : ids){
			int bid=Integer.parseInt(id);
			if(session.getAttribute("shopping")!=null){
				List<Book> shopping=(List<Book>)session.getAttribute("shopping");
				Iterator<Book> shoppingIterator=shopping.iterator();
				while(shoppingIterator.hasNext()){
					if(shoppingIterator.next().getBookId()==bid){
						shoppingIterator.remove();
					}
				}
				session.setAttribute("shopping", shopping);
				result="shopping.jsp";
			}
		}	
	}
	response.sendRedirect(result);
%>