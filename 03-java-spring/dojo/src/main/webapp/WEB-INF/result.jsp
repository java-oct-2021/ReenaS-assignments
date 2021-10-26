<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Project Details for you </h1>
<p>First Name: <c:out value="${firstName}"/></p>
<p>Last Name: <c:out value="${lastName}"/></p>
<p>Email: <c:out value="${email}"/></p>
<h2>Student Projects:</h2>
<hr>
	<c:forEach items="${projects}" var="project">
	<p> <c:out value="${project.projectName}"/></p>   
	</c:forEach>

<a href="/dash">Dashboard</a>


</body>
</html>