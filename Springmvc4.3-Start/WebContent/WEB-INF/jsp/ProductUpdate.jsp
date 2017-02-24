<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProductForm</title>
</head>
<body>
	<div>
		<form:form modelAttribute="contentUpdate">
			<fieldset>
				<legend>Update a Product</legend>
				<p>ID:${productUpdateId}</p>
				<form:errors path="*"></form:errors>
				<br />
				<br /> <label for="name">Product Name:</label>
				<form:input path="name" type="text" id="name" name="name" value=""
					tabindex="1" />
				<form:errors path="name"></form:errors>
				<br />
				<br /> <label for="description">Description</label>
				<form:input path="description" type="text" id="description"
					name="description" value="" tabindex="2" />
				<form:errors path="description"></form:errors>
				<br />
				<br /> <label for="price">Product Price:</label>
				<form:input path="price" type="text" id="price" name="price"
					value="" tabindex="3" />
				<form:errors path="price"></form:errors>
				<br />
				<br /> <label for="many">Product Many:</label>
				<form:input path="many" type="text" id="many" name="many" value=""
					tabindex="4" />
				<form:errors path="many"></form:errors>
				<br />
				<br /> <label for="make">Product Make:</label>
				<form:input path="make" type="text" id="make" name="make" value=""
					tabindex="5" />
				<form:errors path="make"></form:errors>
				<br /> <br />


				<div id="buttons">
					<label for="dummy"></label> <input type="reset" id="reset"
						tabindex="6"> <input type="submit" id="submit"
						tabindex="7" value="Add Product"> <a href="index.html">返回首页</a>
					<a href="Javascript:window.history.go(-1)">返回上一步</a>
				</div>
			</fieldset>
		</form:form>
	</div>

</body>
</html>