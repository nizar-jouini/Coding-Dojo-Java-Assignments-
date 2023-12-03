<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Omikuji</title>
</head>
<body>
	<div class="mb-3 justify-content-center align-items-center">
		<h1 class="text-center">Send an Omikuji</h1>
	</div>
	<div class="container w-50">
		<form action="/omikuji/add" method="post">
			<div class="mb-3">
				<label class="form-label">Pick any number from 5 to 25:</label> <input
					type="number" name="number" class="form-control w-25">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any city:</label> <input
					type="text" name="city" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any real person:</label>
				<input type="text" name="person" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter professional endeavor or
					hobby:</label> <input type="text" name="hobby" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter any type of living thing:</label> <input
					type="text" name="living" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Say something nice to someone:</label>
				<input type="text" name="message" class="form-control" style="height: 100px">
				<div class="form-text">Send and show a friend</div>
			</div>
			<div class="mb-3 d-flex justify-content-end align-items-center">
				<button type="submit" class="btn btn-primary" style="box-shadow: 5px 5px 5px black">Send</button>
			</div>
		</form>
	</div>
</body>
</html>