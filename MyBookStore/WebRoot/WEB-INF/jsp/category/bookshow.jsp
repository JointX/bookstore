<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<!--base标签只能在head标签内  -->
<html:base target="body" />

<title>MyBookStore.jsp</title>

</head>

<body>

	<div align="center" style="border:0px solid;">
		<h2>书籍详细</h2>
		<form action="<c:url value='/addCar.do'/>" method="post">
			<table align="center">
				<tr>
					<input type="hidden" name="goods" value="${book.bid}" />
				</tr>
				<tr>
					<input type="hidden" name="image" value="${book.image}"/>
				</tr>
				<tr>
					<input type="image" src="<c:url value='/image/${book.image}' />"    onclick="false"/>
				</tr>
				<tr>
					<input type="hidden" name="username" value="${login_user.username}" />
				</tr>
				<tr>
					<input type="hidden" name="price" value="${book.price}" />
				</tr>
				<tr>
					<input type="hidden" name="bookname" value="${book.bname}" />
				</tr>
				<tr>
					<input type="hidden" name="author" value="${book.author}" />
				</tr>
				<h4>${book.price}</h4>
				<h4>${book.bname}</h4>
				<h4>${book.author}/著</h4>
				<h4>
					<input type="text" name="numbers" style="width: 46px; " />本
				</h4>
				<input type="submit" value="购买">
				
			</table>
		</form>
	</div>
</body>
</html:html>
