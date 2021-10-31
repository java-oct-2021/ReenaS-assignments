<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<h1>Welcome to Coding Dojo!</h1>
	<h5><a href="/dash">Student Dashboard</a></h2>	
	<h5><a href="/projects">Project Dashboard</a></h2>	
	<form:form action="/create" method="post" modelAttribute="newStudent">
	    <div class="form-group">
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors class="text-danger" path="firstName"/>
	        <form:input class="form-control" path="firstName"/>
	    </div>
	    <div class="form-group">
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors class="text-danger" path="lastName"/>
	         <form:input class="form-control" path="lastName"/>
	    
	    </div>
	    <div class="form-group">
	        <form:label path="email">Email:</form:label>
	        <form:errors class="text-danger" path="email"/>
	        <form:input class="form-control" path="email"/>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>    
	
	
	</div>




<%-- <form action="/result" method="POST">
<p> First Name: <input type="text" name="firstName"> </p>
<p> Last Name: <input type="text" name="lastName"> </p>
<p> Email: <input type="text" name="email"> </p>

<p><button>Submit</button></p>
</form>
 --%>

</body>
</html>