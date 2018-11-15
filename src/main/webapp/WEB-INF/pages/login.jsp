<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
	<head>
		<title>Hello Maven Spring Template!</title>
	</head>
	<body>
		<form action="doLogin" method="post">
			<input type="text" name="userName"><br>
			<br>
			<input type="password" name="password"><br>
			<br>
			<input type="submit" value="Login">
		</form>
	</body>
</html>
