<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<!--base标签只能在head标签内  -->
<html:base target="body"/>
<title>MyBookStore.jsp</title>
	<table align="left">
		<tr>
		<c:choose>
			<c:when test="${login_user==null}">
			<td><a target="body" href="<c:url value='/login' />">登录</a></td>
			<td><a target="body" href="<c:url value='/register' />">注册</a></td>
			</c:when>
			<c:otherwise>
			<td><a>${login_user.username}</a></td>
			<td><a href="<c:url value='/carQueryAll.do?username=${login_user.username}'/>" >我的购物车</a></td>
			<td><a href="<c:url value='/orderQueryAll.do'/>">我的订单</a></td>
			<td><a target="#" href="<c:url value='/exit.do' />">退出</a></td>
			</c:otherwise>
		</c:choose>
		</tr>
	</table>
</html:html>
