<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>


<body>
	<h4>
		<b>Welcome</b>
	</h4>
	<hr>
	<br>

	<form:form action="${pageContext.request.contextPath}/displayDetails" modelAttribute="user">
First Name<form:input path="fName" />
		<br>
Last Name<form:input path="lName" />
		<br>
Address :<form:textarea path="address" />
		<br>
gender :<form:radiobuttons path="gender" items="${genderMap }" />
		<br>
country :<form:select path="country" items="${countryMap}" />
		<br>
Hobbies :<form:checkboxes path="hobbies" items="${hobbiesMap}" />
		<br>
		<input type=submit value=Submit>

	</form:form>
</body>
</html>