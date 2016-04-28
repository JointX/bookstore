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
	var	flag=0;
	var submit=function()
	{
		flag=1;	
	}
	var imgCheck=function()
	{
	 if(1==flag)
	 {
	 return true;
	 }
	 return false;
	}
</script>

</head>

<body>
	<h2>相关书籍</h2>
	<div style="background-color: orange;">
		<c:forEach items="${list}" var="key">
			<div align="center" style="border:3px solid;">
				<form action="<c:url value='/bookSingleQuery.do'/>" method="post"
					onsubmit="return imgCheck()">
					<input type="hidden" name="bid" value="${key.bid}" /> <input
						type="image" src="<c:url value='/image/${key.image}'/>"
						onclick="submit()" />
					<h4>${key.price}</h4>
					<h4>${key.bname}</h4>
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html:html>
