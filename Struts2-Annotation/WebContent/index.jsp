<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>

<!-- action不需要遵循struts.xml 文件中的常量约定，因为这是引用的是struts  jar包的内容 -->
<s:form action="users" method="post">
<s:textfield name="username" label="用户名" />
<s:textfield name="password" label="密码" />
<s:submit value="提交" />
</s:form>
</body>
</html>