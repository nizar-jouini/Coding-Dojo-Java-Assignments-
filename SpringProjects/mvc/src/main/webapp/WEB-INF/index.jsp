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
	<div class="container">
		<h1 class="mt-3 mb-5">All Books</h1>
		<table class="table border border-5 table-hover"
			style="border-color: #F2B5C1;">
			<thead>
				<tr>
					<th class="text-center">Id</th>
					<th>Title</th>
					<th class="text-center">Language</th>
					<th class="text-center"># Pages</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${books}" var="book">
					<tr>
						<td class="text-center"><c:out value="${book.id}"></c:out></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
						<td class="text-center"><c:out value="${book.language}"></c:out></td>
						<td class="text-center"><c:out value="${book.numberOfPages}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>