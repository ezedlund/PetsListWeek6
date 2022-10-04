<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit item</title>
</head>
<body>
	<form action="editItemServlet" method="post">
		<!-- Owner -->
		Owner name: <input type="text" name="owner"
			value="${itemToEdit.owner}">
		<!-- Name -->
		Pet name: <input type="text" name="name" value="${itemToEdit.name}">
		<!-- Type -->
		Pet type: <input type="text" name="type" value="${itemToEdit.type}">
		<!-- ID -->
		<input type="hidden" name="id" value="${itemToEdit.id}">
		<!-- submit -->
		<input type="submit" value="Save Edited Pet Information">
	</form>
</body>
</html>