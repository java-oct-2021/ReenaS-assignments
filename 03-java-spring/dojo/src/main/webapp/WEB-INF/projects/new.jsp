<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Welcome to Coding Dojo- Stacks!</h1>
	<h2><a href="projects">Project Dashboard</a></h2>	
	<form:form action="/projects/create" method="post" modelAttribute="newProject">
	    <div class="form-group">
	        <form:label path="projectName">Project Name:</form:label>
	        <form:errors class="text-danger" path="projectName"/>
	        <form:input class="form-control" path="projectName"/>
	    </div>
	     <div class="form-group">
	       <form:label path="student">Student Name</form:label>
		        <form:errors path="student"/>
		        <form:select class="form-control" path="student">
		        <c:forEach items="${ allStudents }" var="student">
		        	<option value="${ student.id }">${ student.firstName }</option>
		        </c:forEach>
		        </form:select>
		  </div>
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>    
</div>


</body>
</html>