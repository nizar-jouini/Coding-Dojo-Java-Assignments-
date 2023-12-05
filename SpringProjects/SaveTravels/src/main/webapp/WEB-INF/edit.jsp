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
<title>Edit Expenses</title>
</head>
<body>
	<div class="container w-50">
		<div class="my-3 d-flex justify-content-between align-items-center">
			<h1 class="text-center" style="color: #36659E;">Add an Expense</h1>
			<a href="/expenses">Go back</a>
		</div>
		<form:form action="/expenses/edit/${travel.id}" method="post"
			modelAttribute="travel">
			<input type="hidden" name="_method" value="put">
			<form:errors class="text-danger" path="expenseName" />
			<div class="input-group mb-3">
				<span class="input-group-text">Expense Name: </span>
				<form:input type="text" path="expenseName" class="form-control"
					placeholder="Expense Name..." value="${travel.expenseName}" />
			</div>
			<form:errors class="text-danger" path="vendor" />
			<div class="input-group mb-3">
				<span class="input-group-text">Vendor: </span>
				<form:input type="text" path="vendor" class="form-control"
					placeholder="Vendor..." value="${travel.vendor}" />
			</div>
			<form:errors class="text-danger" path="amount" />
			<div class="input-group mb-3">
				<span class="input-group-text">Amount: </span> <span
					class="input-group-text">$</span>
				<form:input type="text" path="amount" class="form-control"
					value="${travel.amount}" />
			</div>
			<form:errors class="text-danger" path="description" />
			<div class="input-group mb-3">
				<span class="input-group-text" style="height: 50px;">Description:
				</span>
				<form:input type="text" path="description" class="form-control"
					placeholder="Description..." value="${travel.description}"
					style="height: 120px;" />
			</div>
			<div class="mb-3 d-flex justify-content-end align-items-center">
				<button type="submit" class="btn btn-primary"
					style="box-shadow: 5px 5px 5px black">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>