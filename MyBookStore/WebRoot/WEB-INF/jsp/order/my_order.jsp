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
	<div>
		<c:forEach var="key" items="${list}">

			<form action="#" method="post">
				<table>
					<tr>
						<td><input type="image"
							src="<c:url value='/image/${key.image}'/>" /></td>
						<td>-${key.bookname}-</td>
						<c:choose>
							<c:when test="${key.state}">
								<td>已经付款</td>
							</c:when>
							<c:otherwise>
								<td>尚未付款</td>
							</c:otherwise>
						</c:choose>
					</tr>

				</table>
			</form>

		</c:forEach>
	</div>
</body>
</html:html>
