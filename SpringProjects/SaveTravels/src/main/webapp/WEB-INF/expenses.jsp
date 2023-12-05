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
<title>Save Travels</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-3 mb-5" style="color: #36659E;">Save Travels</h1>
		<table class="table border border-5 table-hover"
			style="border-color: #F2B5C1;">
			<thead>
				<tr>
					<th class="text-center">Expense</th>
					<th class="text-center">Vendor</th>
					<th class="text-center">Amount</th>
					<th COLSPAN="2" class="text-center">Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${travels}" var="travel">
					<tr>
						<td class="text-center"><a href="/expenses/show/${travel.id}"><c:out value="${travel.expenseName}"></c:out></a></td>
						<td class="text-center"><c:out value="${travel.vendor}"></c:out></td>
						<td class="text-center"><c:out value="${travel.amount}"></c:out></td>
						<td class="text-center"><a href="/expenses/edit/${travel.id}">edit</a></td>
						<td class="text-center">
							<form action="/expenses/delete/${travel.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" class="btn btn-danger"
									style="box-shadow: 5px 5px 5px black">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="container w-50">
			<div class="mb-3 justify-content-center align-items-center">
				<h1 style="color: #36659E;">Add an expense:</h1>
			</div>
			<form:form action="/expenses" method="post" modelAttribute="travel">
				<form:errors class="text-danger" path="expenseName" />
				<div class="input-group mb-3">
					<span class="input-group-text">Expense Name: </span>
					<form:input type="text" path="expenseName" class="form-control"
						placeholder="Expense Name..." />
				</div>
				<form:errors class="text-danger" path="vendor" />
				<div class="input-group mb-3">
					<span class="input-group-text">Vendor: </span>
					<form:input type="text" path="vendor" class="form-control"
						placeholder="Vendor..." />
				</div>
				<form:errors class="text-danger" path="amount" />
				<div class="input-group mb-3">
					<span class="input-group-text">Amount: </span> <span
						class="input-group-text">$</span>
					<form:input type="text" path="amount" class="form-control" />
				</div>
				<form:errors class="text-danger" path="description" />
				<div class="input-group mb-3">
					<span class="input-group-text" style="height: 50px;">Description:
					</span>
					<form:input type="text" path="description" class="form-control"
						placeholder="Description..." style="height: 120px;" />
				</div>
				<div class="mb-3 d-flex justify-content-end align-items-center">
					<button type="submit" class="btn btn-primary"
						style="box-shadow: 5px 5px 5px black">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>










