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
<body align="center">
			<div align="center" style="border:3px solid;">
			<h3>${form4Car.username}</h3>
			您要购买的书籍_${form4Car.bookname}_已经成功添加进您的购物车，您可以进入购物车栏，进行查阅，确认付款，我们为您发货！
			</div>
</body>
</html:html>
