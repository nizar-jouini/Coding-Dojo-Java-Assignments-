<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Home</title>
</head>
<body>

	<div class="container mt-3">
		<a href="/dojos/new" class="me-5">New Dojo</a>
		<a href="/ninjas/new">New Ninja</a>
	</div>
	<div class="container">
		<h1 class="mt-3 mb-5" style="color: #36659E;">List of Dojos</h1>
		<table class="table border border-5 table-hover"
			style="border-color: #F2B5C1;">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allDojos}" var="dojo">
					<tr>
						<td class="text-center"><c:out value="${dojo.id}"></c:out></td>
						<td class="text-center"><a href="/dojos/show/${dojo.id}">${dojo.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	

</body>
</html>