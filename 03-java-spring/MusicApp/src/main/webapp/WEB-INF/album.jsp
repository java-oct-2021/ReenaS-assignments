<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<t:partial>
	<h5>
		Album Name:
		<c:out value="${album.albumName}" />
	</h5>
	<p>
		Creator:
		<c:out value="${album.user.firstName}" />
	</p>
	<p>
		Description:
		<c:out value="${album.description}" />
	</p>
	<!-- Check if album belongs to user -->
	<c:if test="${album.user.id==userLoggedIn}">
		<a href="/albums/delete/${album.id}"> Delete </a>
		<a href="/albums/edit/${album.id}">Edit</a>
	</c:if>

	<hr>
	
	<h5 class="text-success">Leave a rating:</h5>
			<form:form action="/albums/rateAlbum" method="post"
				modelAttribute="newRating">
				<div class="form-group">
					<form:label path="rating">Rating:</form:label>
					<form:input class="form-control" path="rating" />
					<!-- Hidden Input for userId -->
					<form:input type="hidden" value="${userId}" path="ratedBy" />
					<!-- Hidden Input for albumId -->
					<form:input type="hidden" value="${album.id}" path="albumRated" />
					<input type="submit" class="btn btn-primary" value="Submit"/>
				</div>
			</form:form>
	
</t:partial>