<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"></c:import>
<title>Property Detail Page</title>
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>

	<div class="hero page-inner overlay"
		style="background-image: url('images/hero_bg_3.jpg')">
		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up">5232 California AVE.
						21BC</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item"><a href="property?mode=LIST">Home</a></li>
							<li class="breadcrumb-item"><a href="property-detail.jsp">Properties</a>
							</li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">5232 California AVE. 21BC</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-lg-7">
					<div class="img-property-slide-wrap">
						<div class="img-property-slide">
							<img src="images/img_1.jpg" alt="Image" class="img-fluid" /> <img
								src="images/img_2.jpg" alt="Image" class="img-fluid" /> <img
								src="images/img_3.jpg" alt="Image" class="img-fluid" />
						</div>
					</div>
				</div>
				<div class="col-lg-4">

					<%-- <c:forEach var="property" items="${propertyDetail}"> --%>
						<h2 class="heading text-primary">
							<c:out value="${propertyDetail.propertyName }"></c:out>
						</h2>
						<p class="meta">
							<c:out value="${propertyDetail.address }"></c:out>
						</p>

						<div class="property-content">
							<div>
								<div class="specs d-flex mb-4">
									<span class="d-block d-flex align-items-center"> <span
										class="icon-dollar me-2"></span> <span class="caption">
											<c:out value="${propertyDetail.price }"></c:out>
									</span>
									</span> &nbsp;&nbsp; <span class="d-block d-flex align-items-center">
										<span class="icon-bed me-2"> </span> <span class="caption">
											<c:out value="${propertyDetail.roomNumber }"></c:out>
									</span>
									</span> &nbsp;&nbsp; <span class="d-block d-flex align-items-center">
										<span class="icon-bath me-2"> </span> <span class="caption">
											<c:out value="${propertyDetail.bedRoomNumber }"></c:out>
									</span>
									</span>
								</div>

							</div>
						</div>

						<p class="text-black-50">
							<c:out value="${propertyDetail.description }"></c:out>
						</p>
						<div class="d-block agent-box p-2">
							<ul>
								<li>100% Bank Transfer</li>
								<li>Area : <c:out value="${propertyDetail.area }"></c:out> SqFt
								</li>
								<li>Master BedRoom :<c:out value="${propertyDetail.roomNumber }"></c:out>
									rooms
								</li>
								<li>Living Room</li>
								<li>Dinning Room</li>
								<li>Bath Room :<c:out value="${propertyDetail.bedRoomNumber }"></c:out>
									rooms
								</li>
							</ul>
						</div>
					
					<%-- </c:forEach> --%>
						<br>
						<form action="property" method="post">
							<input type="hidden" name="mode" value="ADDORDER"> 
							<input type="hidden" name="userId" value="${admin.id}">
							<input type="hidden" name="id" value="${propertyDetail.propertyId}">							<div class="row">
								<div class="col-6 mb-3">
									<label for="name" class="col-sm-2 col-form-label">UserName</label>
									<input type="text" class="form-control" id="name"
										value="<c:out value="${admin.username }"></c:out>"
										placeholder="Your Name" />
								</div>
								<div class="col-6 mb-3">
									<label for="phone" class="col-sm-2 col-form-label">Phone</label>
									<input type="text" class="form-control" id="phone"
										value="<c:out value="${admin.phone }"></c:out>"
										placeholder="Your Phone" />
								</div>
								<div class="col-12 mb-3">
									<label for="email" class="col-sm-2 col-form-label">Email</label>
									<input type="text" class="form-control" id="email"
										value="<c:out value="${admin.email }"></c:out>"
										placeholder="Your Email" />
								</div>
								<div class="col-12 mb-3">
									<textarea name="message" cols="30" rows="7" class="form-control"
									 id="message" placeholder="Message"></textarea>
								</div>

								<div class="col-12">
									<button type="submit" class="btn btn-primary">Send Now</button>
								</div>
							</div>
						</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>