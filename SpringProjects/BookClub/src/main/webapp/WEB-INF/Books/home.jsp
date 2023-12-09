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
<title>Read Share</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="mt-3 mb-5" style="color: #36659E;">Welcome
				${user.userName}</h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="d-flex justify-content-between align-items-center">
			<h4 class="mt-3 mb-5" style="color: #36659E;">Books from
				everyone's shelves:</h4>
				<div>
					<a href="/books/new" class="me-3">+ Add a book to my shelf</a>
					<a href="/authors/new">+ Add an author</a>
				</div>
		</div>
		<table class="table border border-5 table-hover"
			style="border-color: #F2B5C1;">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Title</th>
					<th class="text-center">Author Name</th>
					<th COLSPAN="2" class="text-center">Posted By</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${books}" var="book">
					<tr>
						<td class="text-center"><c:out value="${book.id}"></c:out></td>
						<td class="text-center"><a href="/books/${book.id}"><c:out
									value="${book.title}"></c:out></a></td>
						<td class="text-center"><c:out value="${book.author.name}"></c:out></td>
						<td class="text-center"><c:out value="${book.user.userName}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>