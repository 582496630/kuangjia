<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProductMap</title>
</head>
<body>
	<div>
		<p>...................</p>
		
		
		<table border="1">
		<tr>
		<td>序号</td>
		<td>id</td>
		<td>name</td>
		<td>price</td>
		<td>many</td>
		<td>make</td>
		<td>description</td>
		<td>删除</td>
		<td>修改</td>
		
		</tr>
	
		<c:forEach var="productall" items="${allProductList}" varStatus="vs">
		<tr>
		<!-- vs.count  计数 -->
		<td>${vs.count}</td>
		<td>${productall.value.id}</td>
		<td>${productall.value.name}</td>
		<td>${productall.value.price}</td>
		<td>${productall.value.many}</td>
		<td>${productall.value.make}</td>
		<td>${productall.value.description}</td>
		<td>
		<a href="delete_product.action?id=${productall.value.id}">delete</a>
		</td>
		<td><a href="update_product1.action?id=${productall.value.id}">update</a></td>
		</tr>

		</c:forEach> 
		</table>
		<p><a href="product_input.action">返回添加页面</a></p>
	</div>

</body>
</html>