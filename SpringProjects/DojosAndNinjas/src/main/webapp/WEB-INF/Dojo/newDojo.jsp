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
<title>New Dojo</title>
</head>
<body>

	<div class="container w-50">
		<div class="mb-3 justify-content-center align-items-center">
			<h1 style="color: #36659E;">New Dojo</h1>
		</div>
		<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			<form:errors class="text-danger" path="name" />
			<div class="mb-3">
				<form:label class="form-label" path="name">Name: </form:label>
				<form:input type="text" path="name" class="form-control" />
			</div>
			<div class="mb-3 d-flex justify-content-between align-items-center">
				<button type="submit" class="btn btn-primary"
					style="box-shadow: 5px 5px 5px black">
					Create
				</button>
				<a href="/">Go back</a>
			</div>
		</form:form>
	</div>

</body>
</html>