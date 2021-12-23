<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<h1>Welcome to Mike's Pizzas Amore!!</h1>

<h2>Register with us before you order.</h2>
<h2>Already have an account? <a href="/login">Click Here!!</a></h2>
<body>

	<form:form action="/" method="post" modelAttribute="newUser">
		<div class="form-group">
			<label>First Name:</label>
			<form:input path="firstName" class="form-control" />
			<form:errors path="firstName" class="text-danger" />
		</div>
				<div class="form-group">
			<label>Last Name:</label>
			<form:input path="lastName" class="form-control" />
			<form:errors path="lastName" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
				<div class="form-group">
			<label>Address:</label>
			<form:input path="address" class="form-control" />
			<form:errors path="address" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Confirm Password:</label>
			<form:password path="confirm" class="form-control" />
			<form:errors path="confirm" class="text-danger" />
		</div>
		<input type="submit" value="Register" class="btn btn-primary" />
	</form:form>
	

</body>
</html>