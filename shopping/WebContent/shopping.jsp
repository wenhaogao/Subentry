<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
	 border-bottom: solid 1px;
	 line-height: 20px;
	 text-align: center;
	 padding: 10px;
	}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div style="margin: 10px; border: solid 1px;">
		<form action="deleteShoppingHandler.jsp" method="post" id="shoppingForm">
			<table width="100%" cellspacing="0" style="border-bottom: none;">
				<tr>
					<td>
					<input type="checkbox" name="allshopping">
					编号</td>
					<td>名称</td>
					<td>作者</td>
					<td>价格</td>
					<td>信息</td>
					<td>购买数量</td>
				</tr>
				<c:forEach items="${sessionScope.shopping }" var="b">
					<tr>
						<td>
							<input type="checkbox" name="ids" value="${b.bookId }">
							<img src="img/book.jpg" width="50" height="60"/>
						</td>
						<td>${b.bookName}</td>
						<td>${b.bookAuthor}</td>
						<td>${b.bookPrice}</td>
						<td>${b.bookInfo}</td>
						<td>${b.shoppingCount}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						<button type="button" id="next">继续购买</button>
						<button type="submit">删除</button>
						<button type="button" id="submitOrder">提交订单</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>