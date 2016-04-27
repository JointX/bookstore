<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>主页</title>
<style>
</style>
<script type="text/javascript">


</script>
</head>

<frameset rows="10%,8%,*" frameborder="yes" bordercolor="black">
	<frame class="frame" src="<c:url value='/title'/>" name="frame"/>
	<frame src="<c:url value='/muenbar.do'/>" name="muenbar" />
	<frameset cols="10%,*">
		<frame src="<c:url value='/categoryQueryAll.do'/>" name="muen"/>
		<frame src="<c:url value='/image/background.png'/>"" name="body" />
	</frameset>
</frameset>
</html>
