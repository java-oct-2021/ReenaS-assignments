<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1>Edit Project - ${editProject.projectName}</h1>
		<p>
			<a href="/projects">Project Dashboard</a> <a href="/logout">Logout</a>
		</p>
		<form:form action="/projects/update/${editProject.id}" method="post"
			modelAttribute="editedProject">

			<div class="form-group">
				<form:label path="projectName">Project Name:</form:label>
				<form:errors class="text-danger" path="projectName" />
				<form:input class="form-control" path="projectName"
					value="${editProject.projectName}" />
			</div>
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:errors class="text-danger" path="description" />
				<form:input class="form-control" path="description"
					value="${editProject.description}" />

			</div>
			<input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>

	</div>


</body>
</html>