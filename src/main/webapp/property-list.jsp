<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="common/header.html"></c:import>
<title>Order List</title>
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import><br>

	<div class="section">
		<!-- Page content-->
		<div class="container mt-5">
			<div><h2 class="text-center">Registered Property Lists</h2></div>
			<table id="property" class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Status</th>
						<th>Address</th>
						<th>Area</th>
						<th>NumberOfRooms</th>
						<th>NumberOfBedRooms</th>
						<th>PropertyType</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="property" items="${propertyList}">
						<c:url var="updateLink" value="property">
							<c:param name="mode" value="LOAD"></c:param>
							<c:param name="id" value="${property.propertyId}"></c:param>
						</c:url>

						<c:url var="deleteLink" value="property">
							<c:param name="mode" value="DELETE"></c:param>
							<c:param name="id" value="${property.propertyId}"></c:param>
						</c:url>

						<tr>
							<td><c:out value="${property.propertyId}"></c:out></td>
							<td><c:out value="${property.propertyName}"></c:out></td>
							<td><c:out value="${property.description}"></c:out></td>
							<td><c:out value="${property.price}"></c:out></td>
							<td><c:out value="${property.propertyStatus}"></c:out></td>
							<td><c:out value="${property.area}"></c:out></td>
							<td><c:out value="${property.roomNumber}"></c:out></td>
							<td><c:out value="${property.bedRoomNumber}"></c:out></td>
							<td><c:out value="${property.propertyType}"></c:out></td>
							<td><a href="${updateLink }" class="btn btn-primary">Edit</a>
								<a href="${deleteLink }" id="delete" class="btn btn-danger"
								onclick="return confirm('Are you sure to delete this property?');">Delete</a>
							</td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>
