<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Pizza</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>${pizza.name }</h1>
	<table>
		<thead>
			<tr>
				<th>Crust:</th>
				<th>Sauce:</th>
				<th>Cheese:</th>
				<th>Meats:</th>
				<th>Veggies:</th>

			</tr>
		</thead>
		<tbody>

		</tbody>


		<c:forEach items="${allPizzas}" var="p">
			<tbody>
				<tr>

					<td><c:out value="${p.crust }" /></td>
					<td><c:out value="${p.sauce }" /></td>
					<td><c:out value="${p.cheese }" /></td>
					<td><c:out value="${p.meats }" /></td>
					<td><c:out value="${p.veggies }" /></td>
					<td><a href="/pizzas/${p.id}/edit">Edit</a></td>

					<td><form action="/delete/${id }" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<button class="">Delete</button>
						</form></td>


				</tr>


			</tbody>


		</c:forEach>
	</table>

<h2> <a href="/homepage">Homepage</a></h2>

</body>
</html>