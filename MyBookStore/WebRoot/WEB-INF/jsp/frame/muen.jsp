<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<!--base标签只能在head标签内  -->
<html:base target="body"/>

<title>MyBookStore.jsp</title>

</head>

<body>
	<h3>相关分类</h3>
	<c:forEach items="${list}" var="key">
		<form action="<c:url value='/categoryQueryAllBook.do'/>" method="post">
			<h3>
				<input type="hidden" name="cid" value="${key.cid}"/><input type="submit" value="${key.cname}" />
			</h3>
		</form>
	</c:forEach>
</body>
</html:html>
