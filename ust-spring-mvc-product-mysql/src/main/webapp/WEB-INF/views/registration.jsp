<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
 
</head>
<body bgcolor="pink">



<form:form method="POST" action="/register" class="form-signin"
		modelAttribute="user">
		<h3>Registration Page 1</h3>
		<div class="form-group">
			<span>Username : </span>
			<form:input path="username" class="form-control"></form:input>
			<span>Password : </span>
			<form:input path="password" class="form-control"></form:input>

			<button class="btn btn-primary" type="submit">Register</button>
		</div>
	</form:form>
	<font color="red">${errorMsg}</font>
	<font color="green">${msg}</font>
	<font color="green">${message}</font>
</head>

</body>
</html>