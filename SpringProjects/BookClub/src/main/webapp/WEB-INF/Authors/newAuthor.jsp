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
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<title>Create Author</title>
</head>
<body>
	<div class="container mt-5"
		style="background-color: lightblue; height: 30rem;">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="mt-3 mb-5" style="color: #36659E;">Add an Author</h1>
			<a href="/books">back to the shelves</a>
		</div>
		<form:form action="/authors/new" method="post" modelAttribute="author">
			<div class="mb-3">
				<form:label class="form-label" path="name">Name: </form:label>
				<br>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" path="name" class="form-control w-50" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="location">Location: </form:label>
				<br>
				<form:errors class="text-danger" path="location" />
				<form:input type="text" path="location" class="form-control w-50" />
			</div>
			<div class="mt-4 d-flex justify-content-between align-items-center">
				<button type="submit" class="btn btn-primary"
					style="box-shadow: 5px 5px 5px black">Create</button>
			</div>
		</form:form>
	</div>
</body>
</html>