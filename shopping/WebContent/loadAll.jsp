<%@page import="com.gellojava.web.entity.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.hellojava.business.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookService bookService=new BookService();
	int pageCount=0;
    int displayCount=Integer.parseInt(this.getServletContext().getInitParameter("displayCount"));
    int maxPage=bookService.calctorMaxPage(displayCount);
    if(request.getParameter("page")!=null){
    	int p=Integer.parseInt(request.getParameter("page"));
    	if(p<0){
    		p=maxPage;
    	}
    	
    	if(p>maxPage){
    		p=0;
    	}
    	
    	pageCount=p;
    }
    List<Book> bookList=bookService.loadAll(pageCount, displayCount);
    
    session.setAttribute("bookList", bookList);
    session.setAttribute("currentPage", pageCount);
    session.setAttribute("maxPage", maxPage);
    
    response.sendRedirect("index.jsp");
%>