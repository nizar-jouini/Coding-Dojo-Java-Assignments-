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
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="mt-3 mb-5" style="color: #36659E;">Welcome
				${user.userName}!</h1>
			<a href="/logout" class="me-3 fs-4">Logout</a>
		</div>
		<div>
			<h1 class="text-center">Current Games</h1>
			<h1>Games</h1>
			<hr />
			<div>
				<c:forEach items="${games}" var="game">
					<h5 class="mb-3">
						<a href="/games/${game.id}"><c:out value="${game.name}"></c:out></a><br />
						Genre:
						<c:out value="${game.genre}"></c:out>
					</h5>
				</c:forEach>
			</div>
			<div class="mt-4 d-flex justify-content-between align-items-center">
				<a href="/games/new" class="btn btn-primary w-100"
					style="box-shadow: 5px 5px 5px black">Create New Game</a>
			</div>

		</div>
	</div>
</body>
</html>


















