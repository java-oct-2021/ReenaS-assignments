<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:partial>
	<h5>Project Name: <c:out value="${project.projectName}" /></h5>
	<p>Creator:<c:out value="${project.user.firstName}" /></p>
	<p>Description:<c:out value="${project.description}" /></p>
	
	<h3 class="text-success">Users who liked your project</h3>
	<c:forEach items="${ project.likers}" var="liker">
	<p> <c:out value="${liker.firstName}" /> </p>
	</c:forEach>
	
	<!-- Check if project belongs to user -->
	<c:if test="${project.user.id==userLoggedIn}">
		<a href="/projects/delete/${project.id}" class="text-danger"> Delete </a>
		<a href="/projects/edit/${project.id}">Edit</a>
	</c:if>
	
</t:partial>