<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>

<h1>Welcome back to Mike's Pizzas Amore!!</h1>

<h2>Dont have an account? <a href="/">Click Here!!</a></h2>

<body>

	<form:form action="/login" method="post" modelAttribute="newLogin">
		<div class="form-group">
			<label>Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<input type="submit" value="Login" class="btn btn-success" />
	</form:form>



</body>
</html>