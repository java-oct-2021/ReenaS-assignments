<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="/projects">Project Dashboard</a> <a href="/logout">Logout</a>
	</p>
	<h1>
		Project Name:
		<c:out value="${project.projectName}" />
	</h1>
	<p>
		Creator:
		<c:out value="${project.user.firstName}" />
	</p>
	<p>
		Description:
		<c:out value="${project.description}" />
	</p>

	<hr>
	<h2>Users who liked your project</h2>
	<c:forEach items="${ project.likers}" var="liker">
	<p> <c:out value="${liker.firstName}" /> </p>
	</c:forEach>
	<!-- Check if project belongs to user -->
	<c:if test="${project.user.id==userLoggedIn}">
		<a href="/projects/delete/${project.id}"> Delete </a>
		<a href="/projects/edit/${project.id}">Edit</a>
	</c:if>
	
</body>
</html>