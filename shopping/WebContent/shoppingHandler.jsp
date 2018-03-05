<%@page import="java.util.Collections"%>
<%@page import="com.gellojava.web.entity.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.hellojava.business.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result="error.jsp";
	String[] ids=request.getParameterValues("ids");
	if(ids!=null && ids.length>0){
		BookService bookService=new BookService();
		List<Book> newShopping=bookService.loadShopping(ids);
		if(session.getAttribute("shopping")!=null){
			List<Book> oldShopping=(List<Book>)session.getAttribute("shopping");
			for(Book newB : newShopping){
				boolean bool=false;
				for(Book oldB : oldShopping){
					if(newB.getBookId()==oldB.getBookId()){
						bool=true;
						oldB.setShoppingCount(oldB.getShoppingCount()+1);
					}
				}
				if(!bool){
					oldShopping.add(newB);
				}
			}
			Collections.sort(oldShopping);
			session.setAttribute("shopping", oldShopping);
		}else{
			Collections.sort(newShopping);
			session.setAttribute("shopping", newShopping);
		}
		result="shopping.jsp";
	}
	response.sendRedirect(result);
%>