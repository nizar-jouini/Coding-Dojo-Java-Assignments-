<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Omikuji</title>
</head>
<body>
	<div class="my-3 d-flex justify-content-center align-items-center">
		<h1 class="text-center">Her's Your Omikuji!</h1>
	</div>
	<div class="container w-25">
		<div class="card" style="background-color: #9FC5F8;">
			<div class="card-body">
				<h3 class="text-center">
					<c:out value="${result}"></c:out>
				</h3>
			</div>
		</div>
		<div class="my-3 d-flex justify-content-center align-items-center">
			<a href="/omikuji" class="card-link">Go Back</a>
		</div>
	</div>
</body>
</html>