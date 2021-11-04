<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		Welcome
		<c:out value="${user.firstName}" />
	</h1>
	<a href="/logout">Logout</a>
	<a href="/projects/new">Create New Project</a>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Project name</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td><a href="/projects/project/${project.id}"> <c:out
								value="${project.projectName}" />
					</a></td>
					<td><c:out value="${project.user.firstName}" /></td>
					<td><c:out value="${project.likers.size()}" /></td>
					
					<td>
				 <c:choose>
					 <c:when test="${project.likers.contains(user)}">
							<a href="/projects/unLike/${project.id}">unLike</a>
					</c:when>
					<c:otherwise>
							<a href="/projects/like/${project.id}">Like</a>
					</c:otherwise>
					</c:choose>		
            		
            		</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>