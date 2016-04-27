<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
</head>

<body>
	<form action="<c:url value="/register.do"/>" method="post">
		<table align="center" border=3px>
			<tr align="center">
				<th colspan="3" align="center"><h2 align="center">用户注册</h2></th>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" id="input_01" value="" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="" /></td>
			</tr>
			<tr>
				<td>重复密码</td>
				<td><input type="password" name="passwords" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<th colspan="3"><input type="submit" value="提交" /></th>
			</tr>
		</table>
	</form>
</body>
</html>