<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Failed</title>
	</head>
	<body>
		<h3>Hii!! Login Failed :(</h3>
		<P>Error Message :- ${errorMessage}</p><br><br>
		<form action="${pageContext.request.contextPath}/web/home" method="get">
			<input type="submit" value="Back to Home">
		</form>
	</body>
</html>
