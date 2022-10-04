<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list of Pets</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br /> Owner
		Name: <input type="text" name="ownerName"><br /> <input
			type="submit" value="Create a list of pets">
	</form>
	<a href="index.html"> Add a single pet instead.</a>
</body>
</html>