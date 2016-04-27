<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<!--base标签只能在head标签内  -->
<html:base target="body" />

<title>MyBookStore.jsp</title>
<script type="text/javascript">
</script>

</head>

<body align="center">
	<h2>相关书籍</h2>
	<div style="background-image: url('http:localhost:8080/enter/image/car/cart.png');">
		<c:forEach items="${list}" var="key">
			<div align="center" style="border:3px solid;">
				<form action="<c:url value='/pay.do'/>" method="post">
					<input type="hidden" name="username" value="${key.username}"/>
					<input type="hidden" name="carid" value="${key.uuid}"/>
					<input type="hidden" name="image" value="${key.image}"/>
					<input type="hidden" name="bookname" value="${key.bookname}"/>
					<input type="image" src="<c:url value='/image/${key.image}'/>" />
					<h4>单价：${key.price}</h4>
					<h4>${key.bookname}</h4>
					<h4>共：（${key.numbers}）本</h4>
					<h4>共计：${key.totals} 元</h4>
					<input type="submit" value="确认付款">
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html:html>
