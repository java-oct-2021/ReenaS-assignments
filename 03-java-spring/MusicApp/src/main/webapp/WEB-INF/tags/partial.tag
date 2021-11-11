<%@ tag language="java" pageEncoding="ISO-8859-1"%>

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
	<h3>
		Welcome to My Music App!!
		<c:out value="${user.firstName}" />
	</h3>
	
	
	<a href="/albums">All albums</a>
	
	<a href="/albums/new">Create New album</a>
	<hr>
	<jsp:doBody/>
	
	
	<hr>
	<a href="/logout">Logout</a>
	
</div>
</body>
</html>
	