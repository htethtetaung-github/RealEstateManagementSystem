<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="common/header.html"></c:import>
<title>order List</title>
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>
	<br>

	<div class="section">
		<!-- Page content-->
		<div class="container mt-5">
			<div><h2 class="text-center">Order Details List</h2></div>
			<table id="order" class="table table-striped">
				<thead>
					<tr>
						<th>UserName</th>
						<th>Email</th>
						<th>PropertyName</th>
						<th>Description</th>
						<th>Area</th>
						<th>Price</th>
						<th>NumberOfRooms</th>
						<th>NumberOfBedRooms</th>
						<th>Message</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orderList}">
						
						<c:url var="deleteLink" value="property">
							<c:param name="mode" value="DELETEORDER"></c:param>
							<c:param name="id" value="${order.orderId}"></c:param>
						</c:url>
						<tr>
							<td><c:out value="${order.userName}"></c:out></td>
							<td><c:out value="${order.email}"></c:out></td>
							<td><c:out value="${order.propertyName}"></c:out></td>
							<td><c:out value="${order.description}"></c:out></td>
							<td><c:out value="${order.area}"></c:out></td>
							<td><c:out value="${order.price}"></c:out></td>
							<td><c:out value="${order.roomNumber}"></c:out></td>
							<td><c:out value="${order.bedRoomNumber}"></c:out></td>
							<td><c:out value="${order.message}"></c:out></td>
							<td>
								<a href="${deleteLink }" id="delete" class="btn btn-danger btn-sm"
								onclick="return confirm('Are you sure to delete this order?');">Delete</a>
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
