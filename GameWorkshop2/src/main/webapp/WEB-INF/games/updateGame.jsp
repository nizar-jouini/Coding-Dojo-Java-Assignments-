<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
	<script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<title>Edit Game</title>
</head>
<body>
	<div class="container mt-5 w-75" style="background-color: lightblue; height: 30rem;">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="mt-3 mb-5" style="color: #36659E;">Edit Game</h1>
			<div>
				<a href="/games" class="me-3 fs-4">Dashboard</a>
			</div>
		</div>
		<form:form action="/games/${oneGame.id}/edit" method="post" modelAttribute="game">
			<input type="hidden" name="_method" value="put">
			<div class="mb-3">
				<form:label class="form-label" path="name">Name: </form:label>
				<br>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" path="name" value="${oneGame.name}" class="form-control w-50" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="genre">Genre: </form:label>
				<br>
				<form:errors class="text-danger" path="genre" />
				<form:input type="text" path="genre" value="${oneGame.genre}" class="form-control w-50" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="description">Description: </form:label>
				<br>
				<form:errors class="text-danger" path="description" />
				<form:input type="text" path="description" value="${oneGame.description}" class="form-control w-50" />
			</div>
			<div class="mt-4 d-flex justify-content-center align-items-center">
				<button type="submit" class="btn btn-primary w-75"
					style="box-shadow: 5px 5px 5px black">
					Submit
				</button>
			</div>
		</form:form>
	</div>
</body>
</html>