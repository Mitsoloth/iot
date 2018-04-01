<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Profile Information</title>
</head>
<body>
	<h1>Person Information</h1>
	<table>
		<tr>
			<td>ID :</td>
			<td>${person.getId()}</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td>${person.getPname()}</td>
		</tr>
		<tr>
			<td>Surname :</td>
			<td>${person.getSurname()}</td>
		</tr>
		<tr>
			<td>E-mail :</td>
			<td>${person.getEmail()}</td>
		</tr>
	</table>
</body>
</html>