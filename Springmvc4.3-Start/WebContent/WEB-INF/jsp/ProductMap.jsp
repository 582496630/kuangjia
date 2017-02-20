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
		<td>id</td>
		
		</tr>
		
		<%-- <c:forEach var="productMap" items="${stringList}" varStatus="vs">
		<tr>
		<td>${productMap}</td>
		
		</tr>
		</c:forEach> --%>
		<c:forEach var="product" items="${productMap}" varStatus="vs">
		<tr>
		<td>${product}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		
		</tr>
		</c:forEach> 
		<c:forEach var="product" items="${list}" varStatus="vs">
		<tr>
		<td>${product}</td>
		
		
		</tr>
		</c:forEach> 
		</table>
	</div>

</body>
</html>