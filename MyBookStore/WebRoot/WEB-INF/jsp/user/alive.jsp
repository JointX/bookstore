<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
</head>

<body>
	<form action="<c:url value="/alive.do"/>" method="post">
		<table align="center" border=1px style="width: 546px; ">
			<tr align="center">
				<th colspan="1" align="center"><h2 align="center">用户激活</h2></th>
			</tr>
			<tr align="center">
				<td>尊敬的新名：</td>
				<td ><h3>${form4User.username}</h3></td>
			</tr>
			
			<tr>
				<th colspan="2">
				<input type="hidden" name="uid" value="${form4User.uid}"/>
				<input type="hidden" name="code" value="${form4User.code}"/>
				<input type="submit" value="激活"/>
 				</th>
			</tr>
		</table>
	</form>
</body>
</html>