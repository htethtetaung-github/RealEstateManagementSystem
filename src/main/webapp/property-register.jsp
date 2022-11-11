<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="common/header.html"></c:import>
<title>Property Register Page</title>
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>

	<div class="section">
		<div class="container">
			<form action="property" method="post" enctype="multipart/form-data">
				<h2 class="text-center">Property Registration</h2>

				<input type="hidden" name="mode" value="CREATE">

				<div class="mb-3">
					<label for="name" class="form-label">*Property Name</label> <input
						type="text" id="name" name="name"
						placeholder="Enter Property Name" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="description" class="form-label">*Description</label> <input
						type="text" id="description" name="description"
						placeholder="Enter Description" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="price" class="form-label">*Price</label> <input
						type="number" id="price" name="price" placeholder="Enter Price"
						class="form-control" required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="status" class="form-label">*Property Status</label> <input
						type="text" id="status" name="status"
						placeholder="Enter Property Status" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="address" class="form-label">*Address</label> <input
						type="text" id="address" name="address"
						placeholder="Enter Address" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="photo" class="form-label">*Property Image</label> <input
						type="file" id="photo" name="photo"
						placeholder="Enter Property Image" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="area" class="form-label">*Area</label> <input
						type="number" id="area" name="area" placeholder="Enter Area"
						class="form-control" required="required" autofocus>
				</div>

				<div class="mb-3">
					<label for="room" class="form-label">*Number of Rooms</label> <input
						type="number" id="room" name="room"
						placeholder="Enter Number of Rooms" class="form-control"
						required="required" autofocus>
				</div>

				<div class="mb-3">
					<div class="col-sm-9 col-sm-offset-3">
						<span class="help-block">*Required fields</span>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-danger">Reset</button>
			</form>
			<!-- /form -->
		</div>
		<!-- ./container -->
	</div>

	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>