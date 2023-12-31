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
<title>Reading Books</title>
</head>
<body>
	<div class="my-3 d-flex justify-content-center align-items-center">
		<h1 class="text-center"><c:out value="${book.title}" /></h1>
	</div>

	<div class="container w-50">
		<div class="card" style="background-color: #9FC5F8;">
			<div class="card-body">
				<h4>
					Description:
					<c:out value="${book.description}" />
				</h4>
				<h4>
					Language:
					<c:out value="${book.language}" />
				</h4>
				<h4>
					Number of Pages:
					<c:out value="${book.numberOfPages}" />
				</h4>
			</div>
		</div>
		<div class="my-3 d-flex justify-content-center align-items-center">
			<a href="/books" class="card-link">Go Back</a>
		</div>
	</div>
</body>
</html>