<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProductForm</title>
</head>
<body>
	<div>
		<form:form modelAttribute="contentModel"> 
			<fieldset>
				<legend>Add a Product</legend>
		<form:errors path="*"></form:errors><br/><br/>
				
				<label for="name">Product Name:</label>
		<form:input path="name" type="text" id="name" name="name" value="" tabindex="1" /><br/>
				<form:errors path="name"></form:errors><br/>
				
				 <label for="description">Description</label>
				<form:input path="description" type="text" id="description" name="description" value="" tabindex="2" /> 
		<br/>
		<form:errors path="description"></form:errors><br/>
					
					<label for="price">Price</label> 
					<form:input path="price" type="text" id="price" name="price" value="" tabindex="3" />
		<br/>
		<%-- <form:errors path="price"></form:errors> --%>
				<br/>
					<label for="many">Many</label> 
					<form:input path="many" type="text" id="many" name="many" value="" tabindex="4" />
		<br/>
		<%-- <form:errors path="many"></form:errors> --%>
		<br/>
					
					<label for="make">Make</label> 
					<form:input path="make" type="text" id="make" name="make" value="" tabindex="5" />
	<br/>
		<form:errors path="make"></form:errors><br/> 
	

				<div id="buttons">
					<label for="dummy"></label> <input type="reset" id="reset"
						tabindex="6"> <input type="submit" id="submit"
						tabindex="7" value="Add Product">
						<a href="product_map.action">select</a>
				</div>
			</fieldset>
			</form:form> 
	</div>

</body>
</html>