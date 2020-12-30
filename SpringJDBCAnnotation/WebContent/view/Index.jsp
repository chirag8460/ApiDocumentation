<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<p>
<a href="${pageContext.request.contextPath}/inputDetails" >Add User</a>
</p>
<table border=2>
<tr>

<th>First_name</th>
<th>Last name </th>

<th>Gender </th>
<th>Country </th>
<th>Address</th>
<th>Hobby</th>
</tr>

<c:forEach items="${users}" var="user">
<tr>
<td>${user.fName }</td>
<td>${user.lName }</td>
<td>${user.gender }</td>
<td>${user.country }</td>
<td>${user.address }</td>
<td>${user.hobbies }</td>
</tr>
</c:forEach>
</table>



</body>
</html>