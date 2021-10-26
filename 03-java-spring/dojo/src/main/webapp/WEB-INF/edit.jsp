<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

<div class="container">
	<h1>Edit Student - ${editStudent.firstName}</h1>
	<h2><a href="/dash">Dashboard</a></h2>	
	<form:form action="/update/${editStudent.id}" method="post" modelAttribute="editedStudent">
	   <input type="hidden" name="_method" value=put>
	    <div class="form-group">
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors class="text-danger" path="firstName"/>
	        <form:input class="form-control" path="firstName" value="${editStudent.firstName}"/>
	    </div>
	    <div class="form-group">
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors class="text-danger" path="lastName"/>
	         <form:input class="form-control" path="lastName" value="${editStudent.lastName}"/>
	    
	    </div>
	    <div class="form-group">
	        <form:label path="email">Email:</form:label>
	        <form:errors class="text-danger" path="email"/>
	        <form:input class="form-control" path="email" value="${editStudent.email}"/>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>    
	
</div>


</body>
</html>