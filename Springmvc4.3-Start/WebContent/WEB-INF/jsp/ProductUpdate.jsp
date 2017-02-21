<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProductForm</title>
</head>
<body>
	<div>
		<form action="update_product2.action?id=${productUpdateId}" method="post">
			<p>ID:${productUpdateId}</p>
			<fieldset>
				<legend>Add a Product</legend>
				<label for="name">Product Name:</label>
				 <input type="text" id="name" name="name" value="" tabindex="1" /> 
				 <label for="description">Description</label>
				<input type="text" id="description" name="description" value="" tabindex="2" /> 
					<label for="price">Price</label> 
					<input type="text" id="price" name="price" value="" tabindex="3" />
					<label for="many">Many</label> 
					<input type="text" id="many" name="many" value="" tabindex="4" />
					<label for="make">Make</label> 
					<input type="text" id="make" name="make" value="" tabindex="5" />

				<div id="buttons">
					<label for="dummy"></label> <input type="reset" id="reset"
						tabindex="6"> <input type="submit" id="submit"
						tabindex="7" value="修改 ">
				</div>
			</fieldset>
		</form>
	</div>

</body>
</html>