<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
	<head>
		<title>Hello Maven Spring Template!</title>
	</head>
	<body>
		<h1>Show Time</h1>
		<P>The time on the server is ${serverTime}.</p>
		<form action="${pageContext.request.contextPath}/web/time/showTime" method="get">
			<input type="submit" value="Refresh Time">
		</form>
		<form action="${pageContext.request.contextPath}/web/auth/login" method="get">
			<input type="submit" value="Log In">
		</form>
	</body>
</html>
