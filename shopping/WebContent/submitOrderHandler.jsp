<%@page import="com.gellojava.web.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("shopping")!=null){
		double totalPrice=0;
		List<Book> shopping=(List<Book>)session.getAttribute("shopping");
		for(Book b : shopping){
			totalPrice+=b.getBookPrice()*b.getShoppingCount();
		}
		
		out.println(totalPrice);
	}
%>