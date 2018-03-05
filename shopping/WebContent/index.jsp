<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div style="margin: 10px; border: solid 1px;">
		<form action="shoppingHandler.jsp" method="post" id="deleteBookForm">
			<table style="width: 100%" cellspacing="10">
					<tr align="center">
						<c:forEach items="${sessionScope.bookList}" var="b" varStatus="statu">
							<td>
								<table width="100%" cellspacing="10" style="border:solid 1px;">
									<tr>
										<td rowspan="4" style="padding: 0px;">
											<img src="img/book.jpg" width="100" height="120"/>
										</td>
										<td>${b.bookName}
											
										</td>
									</tr>
									<tr>
										<td>${b.bookAuthor }</td>
									</tr>
									<tr>
										<td>${b.bookPrice }</td>
									</tr>
									<tr>
										<td>${b.bookInfo }<br/>
											<input type="checkbox" name="ids" value="${b.bookId}">
										</td>
									</tr>
								</table>
							</td>
							<c:if test="${statu.count%3==0}">
								</tr>
								<tr align="center">			
							</c:if>
						</c:forEach>
					</tr>
				<tr>
					<td colspan="5" align="right" style="padding-right: 50px;">
						<button id="select" type="button">查看购物车</button>
						<button type="submit">购买</button>
					</td>
				</tr>
				
				<tr>
					<td colspan="5" align="right" style="padding-right: 50px;">
						<a href="loadAll.jsp?page=0">首页</a>
						<a href="loadAll.jsp?page=${sessionScope.currentPage-1}">上一页</a>
						<a href="loadAll.jsp?page=${sessionScope.currentPage+1}">下一页</a>
						<a href="loadAll.jsp?page=${sessionScope.maxPage}">末页</a>
					</td>
				</tr>
				
				
			</table>
		</form>
	</div>
</body>
</html>