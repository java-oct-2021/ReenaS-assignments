<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:partial>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Album name</th>
				<th>Created By</th>
				<th>Ratings</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${albums}" var="album">
				<tr>
					<td><a href="/albums/album/${album.id}"> <c:out
								value="${album.albumName}" />
					</a></td>
					<td><c:out value="${album.user.firstName}" /></td>
					<td>
					
					${album.GetAvgRating()}
					
					</td>
					
					<td>
				
            		</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:partial>
	