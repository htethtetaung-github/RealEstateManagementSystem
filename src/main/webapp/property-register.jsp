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
<br><br>
	<div class="section">
		<div class="container">
			<form action="property" method="post" enctype="multipart/form-data">
				
				<div><h2 class="text-center">Property Registration</h2></div>

				<input type="hidden" name="mode" value="CREATE">

				<div class="mb-3 row">
					<label for="name" class="col-sm-2 col-form-label">Property
						Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Enter Property Name" class="form-control"
							required="required" autofocus>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="address" class="col-sm-2 col-form-label">Address</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="address"
							name="address" placeholder="Enter Property Address"
							class="form-control" required="required" autofocus>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="description" class="col-sm-2 col-form-label">Description</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="description"
							name="description" placeholder="Enter Property Description"
							class="form-control" required="required" autofocus>
					</div>
				</div>

				<div class="mb-3 row g-3">
					<div class="col-md-2">
						<label for="status" class="col-sm-6 col-form-label">Status</label>
					</div>
					<div class="col-md-3">
						<select class="form-select" id="status" name="status" aria-label="Select Status">
							<option value="1" selected>Rent</option>
							<option value="2">Buy</option>
						</select>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-2">
						<label for="type" class="col-sm-6 col-form-label">Type</label>
					</div>
					<div class="col-md-4">
						<select class="form-select" id="type" name="type" aria-label="Select Type">
							<option value="1" selected>Appartment</option>
							<option value="2">Condo</option>
							<option value="3">Office</option>
						</select>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="price" class="col-sm-2 col-form-label">Price</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="price" name="price"
							placeholder="Enter Property Name" class="form-control"
							required="required" autofocus>
					</div>
				</div>

				<div class="mb-3 row g-3">
					<div class="col-md-2">
						<label for="room" class="col-sm-6 col-form-label">No of
							Rooms</label>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" id="room" name="room"
							placeholder="Enter number of room" required="required" autofocus>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-2">
						<label for="bedRoom" class="col-sm-6 col-form-label">Bed
							Rooms</label>
					</div>
					<div class="col-md-4">
						<input type="text" class="form-control" id="bedRoom"
							name="bedRoom" placeholder="Enter number of bed room" required="required" autofocus>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="area" class="col-sm-2 col-form-label">Area</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="area" name="area"
							placeholder="Enter Property Name" class="form-control"
							required="required" autofocus>
					</div>
				</div>

				<div class="mb-3 row">
					<label for="photo" class="col-sm-2 col-form-label">Property
						Image</label>
					<div class="col-sm-10">
						<input type="file" class="form-control" id="photo" name="photo"
							placeholder="Enter Property Name" class="form-control"
							required="required" autofocus>
					</div>
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