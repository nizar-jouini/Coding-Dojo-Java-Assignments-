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
<title>Game Details</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="mt-3 mb-5" style="color: #36659E;">${oneGame.name}</h1>
			<a href="/games" class="me-3 fs-4">Dashboard</a>
		</div>
		<div>
			<c:if test="${oneGame.user.id == logedUserId}">
				<h4>
					<span>Name: </span> <span><c:out value="${oneGame.name}" /></span>
				</h4>
				<h4>
					<span>Developer: </span> <span><c:out
							value="${oneGame.user.userName}" /></span>
				</h4>
				<h4>
					<span>Description: </span><br /> <span><c:out
							value="${oneGame.description}" /></span>
				</h4>
				<div
					class="mt-4 fs-4 d-flex flex-column justify-content-center align-items-start">
					<a href="/games/${oneGame.id}/edit" class="ms-3">edit</a>
					<form action="/games/${oneGame.id}/delete" method="post">
						<input type="hidden" name="_method" value="delete">
						<button type="submit" class="btn btn-link fs-4">delete</button>
					</form>
				</div>
			</c:if>
			<c:if test="${oneGame.user.id != logedUserId}">
				<h4>
					<span>Name: </span> <span><c:out value="${oneGame.name}" /></span>
				</h4>
				<h4>
					<span>Developer: </span> <span><c:out
							value="${oneGame.user.userName}" /></span>
				</h4>
				<h4>
					<span>Description: </span><br /> <span><c:out
							value="${oneGame.description}" /></span>
				</h4>
			</c:if>
		</div>
		<div class="container w-75 mt-5">
			<div class="border border-primary border-3 p-2">
				<form:form action="/gameMechanics/${oneGame.id}/new" method="post"
					modelAttribute="gameMechanic">
					<div class="mb-3">
						<form:label class="form-label fs-4" path="Mechanic">Add Game Mechanic: </form:label>
						<br>
						<form:errors class="text-danger" path="Mechanic" />
						<form:input type="text" path="Mechanic" class="form-control w-50" />
					</div>
					<div class="mt-4 d-flex justify-content-center align-items-center">
						<button type="submit" class="btn btn-primary w-75"
							style="box-shadow: 5px 5px 5px black">Submit</button>
					</div>
				</form:form>
			</div>
			<div class="mt-3">
				<h5>Suggested Game Mechanics:</h5>
				<c:forEach items="${gameMechanics}" var="gameMechanic">
					<h5 class="mb-3 ms-2">
						-
						<c:out value="${gameMechanic.mechanic}"></c:out>
					</h5>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>






































