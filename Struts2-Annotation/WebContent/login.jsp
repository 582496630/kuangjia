<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>

<!-- action需要遵循struts.xml 文件中的常量约定      action="users.action"  -->
<form action="users.action" method="post">
<table>
<tr>
<td>用户:</td>
<td><input type="text" id="username" name="username" maxlength="40" size="18" /></td>
</tr>
<tr>
<td>密码:</td>
<td><input type="text" id="password" name="password" maxlength="40" size="18" /></td>
</tr>
<tr>
<td align="center" colspan="2">
<input type="submit" value="确定"  /></td>
</tr>
</table>

</form>
</body>
</html>