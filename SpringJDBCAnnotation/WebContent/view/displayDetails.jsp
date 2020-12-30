<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
	<b>Details Page</b> Hello ,<%=request.getAttribute("firstName") + " " + request.getAttribute("lastName")%>
	<br> Name :${user.fName}
	<br>Surname : ${user.lName}
	<br> Gender :${user.gender}
	<br>Add :${user.address}
	<br>Country :${user.country }
	<br>Hobbies :
	<c:forEach items="${user.hobbies}" var="item">
		<li>${item}</li>
	</c:forEach>
</body>
</html>