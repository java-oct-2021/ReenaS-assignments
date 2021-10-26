<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>
<h1>All students</h1>

<table class="table table-dark">
    <thead>
        <tr>
            <th>first name</th>
            <th>last name</th>
            <th>email</th>
            <th>Action</th>
          </tr>
    </thead>
    <tbody>
     <c:forEach items="${allStudents}" var="student">
        <tr>
            <td>
            <a href="/show/${student.id}">
            <c:out value="${student.firstName}"/>
            </a>
            
            </td>
            <td><c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.email}"/></td>
            <td>
            <form action="/delete/${student.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <button class="btn btn-danger">Delete</button>	
			</form>
			<form action="/edit/${student.id}">
			   <button class="btn btn-info">Edit</button>	
			</form>
            </td>
          
        </tr>
        </c:forEach>
    </tbody>
</table>

<a href="/">New Student</a>
</body>
</html>