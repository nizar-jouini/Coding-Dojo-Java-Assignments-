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
		<div class="d-flex justify-content-between align-items-center mb-3">
			<h1 class="mt-3 mb-5" style="color: #36659E;">${oneBook.title}</h1>
			<a href="/books" class="me-3">back to the shelves</a>
		</div>	
		<div>
			<c:if test="${oneBook.user.id == logedUserId}">
				<h4>
					You read 
					<span style="color: #9919FF;"><c:out value="${oneBook.title}" /></span>
					 by 
					<span style="color: #4A9E14;"><c:out value="${oneBook.author.name}" /></span> 
				</h4>
				<h4>
					Here are your thoughts: 
					<div class="w-50 mt-4">
						<hr class="ms-5" style="width: 89%"/>
						<blockquote class="ms-5">
							<c:out value="${oneBook.thoughts}" />
						</blockquote>
						<hr class="ms-5" style="width: 89%"/>
						<div class="mt-4 d-flex justify-content-end align-items-center">
							<a href="/books/edit/${oneBook.id}" class="btn btn-primary me-3"
								style="box-shadow: 5px 5px 5px black">Edit</a>
								<form action="/books/delete/${oneBook.id}" method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete"
									class="btn btn-primary"	style="box-shadow: 5px 5px 5px black">
								</form>
						</div>
					</div>
				</h4>
			</c:if>
			<c:if test="${oneBook.user.id != logedUserId}">
				<h4>
					<span style="color: #CF2A28;"><c:out value="${oneBook.user.userName}" /></span>
					 read 
					<span style="color: #9919FF;"><c:out value="${oneBook.title}" /></span>
					 by 
					<span style="color: #4A9E14;"><c:out value="${oneBook.author.name}" /></span> 
				</h4>
				<h4>
					Here are <c:out value="${oneBook.user.userName}" />'s thoughts: 
					<div class="w-50 ms-5 mt-4">
						<hr style="width: 89%"/>
						<blockquote class="">
							<c:out value="${oneBook.thoughts}" />
						</blockquote>
						<hr style="width: 89%"/>
					</div>
				</h4>
			</c:if>
		</div>
	</div>

</body>
</html>

















