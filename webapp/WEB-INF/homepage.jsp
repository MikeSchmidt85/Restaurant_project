<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<h1>Welcome ${ theUser.firstName}</h1>
<p><a href="/pizzas/new">Create a pizza!!</a></p>

	<table>
		<thead>
			<tr>
				<th>Name:</th>
				<th>Created By:</th>

			</tr>
		</thead>
		<tbody>

		</tbody>


		<c:forEach items="${allPizzas}" var="p">
			<tbody>
				<tr>
					<td> <a href="/pizzas/${p.id }"><c:out value = "${p.name }"/></a></td>
					<td><c:out value="${theUser.firstName }" /></td>

					

				</tr>


			</tbody>


		</c:forEach>
	</table>

<h2> <a href="/">Logout</a></h2>
</body>
</html>