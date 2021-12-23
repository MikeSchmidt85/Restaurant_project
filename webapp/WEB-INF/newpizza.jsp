<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Pizza</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>Create a Pizza</h1>

	<form:form action="/pizzas/new" method="post" modelAttribute="pizza">
		<form:input type="hidden" value="${user_Id}" path="user" />




		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="crust">Crust:</form:label>
			<form:errors path="crust" />
			<select name="crust">
				<option>Regular</option>
				<option>Stuff Crust</option>
				<option>Deep Dish</option>
			</select>

		</p>
		<p>
			<form:label path="sauce">Sauce:</form:label>
			<form:errors path="sauce" />
			<select name="sauce">
				<option>Marinara</option>
				<option>Alfredo</option>
				<option>Pesto</option>
			</select>
		</p>
		<p>
			<form:label path="cheese">Cheese:</form:label>
			<form:errors path="cheese" />
			<select name="crust">
				<option>Mozzarella</option>
				<option>Parmesan</option>
				<option>Extra</option>
			</select>
		</p>
		<p>
			<form:label path="meats">Meats:</form:label>
			<form:errors path="meats" />
			<form:input path="meats" />
		</p>
		<p>
			<form:label path="veggies">Veggies:</form:label>
			<form:errors path="veggies" />
			<form:input path="veggies" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>

	<h2>
		<a href="/homepage">Homepage</a>
	</h2>




</body>
</html>