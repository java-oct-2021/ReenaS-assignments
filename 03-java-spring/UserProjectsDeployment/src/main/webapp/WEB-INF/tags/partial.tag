<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags" %>

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
	<h1>
		Welcome to Coding Dojo
		<c:out value="${user.firstName}" />
	</h1>
	<a href="/projects">All Projects</a>
	<a href="/projects/new">Create New Project</a>
	<jsp:doBody/>
	
	
	<hr>
	<a href="/logout">Logout</a>
	
	<f:footer>
	</f:footer>
</body>
</html>
	