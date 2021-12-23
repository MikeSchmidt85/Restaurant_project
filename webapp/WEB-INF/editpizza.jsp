<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

	<form:form action="/pizzas/${id}" method="post" modelAttribute="pizza">
		<form:input type="hidden" value="${user_Id}" path="user" />




		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="crust">Crust:</form:label>
			<form:errors path="crust" />
			<form:input path="crust" />
		</p>
		<p>
			<form:label path="sauce">Sauce:</form:label>
			<form:errors path="sauce" />
			<form:input path="sauce" />
		</p>
		<p>
			<form:label path="cheese">Cheese:</form:label>
			<form:errors path="cheese" />
			<form:input path="cheese" />
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