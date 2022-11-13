<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"></c:import>
<title>Home Page</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
	#p {
        display: none;
     }
</style>
</head>

<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>

	<div class="hero">
		<div class="hero-slide">
			<div class="img overlay"
				style="background-image: url('images/hero_bg_3.jpg')"></div>
			<div class="img overlay"
				style="background-image: url('images/hero_bg_2.jpg')"></div>
			<div class="img overlay"
				style="background-image: url('images/hero_bg_1.jpg')"></div>
		</div>

		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center">
					<h1 class="heading" data-aos="fade-up">Easiest way to find
						your dream home</h1>
					<form action="property" method="post"
						class="narrow-w form-search d-flex align-items-stretch mb-3"
						data-aos="fade-up" data-aos-delay="200">
						<input type="hidden" name="mode" value="SEARCH">
						
						<div>
							<select id="status" name="status" class="selectpicker  py-2 px-3 show-tick" onchange="priceChange()">
								<!-- <option value="0" disabled selected>Choose Status</option> -->
								<option value="1">Rent</option>
								<option value="2">Buy</option>
							</select>
						</div>
						&nbsp;&nbsp;
						<div>
							<select name="type" class="selectpicker  py-2 px-3 show-tick">
								<!-- <option value="0" disabled selected>Choose Type</option> -->
								<option value="1">Appartment</option>
								<option value="2">Condo</option>
								<option value="3">Office</option>
							</select>
						</div>
						&nbsp;&nbsp;
						<div>
							<select name="price" class="selectpicker  py-2 px-3 show-tick">
								<!-- <option value="0" disabled selected>Choose Price</option> -->
								<option value="200000">2 Laks</option>
								<option value="600000">6 Laks</option>
								<option value="1000000">10 Laks</option>
								<option value="10000000" id ="p">100 Laks</option>
								<option value="60000000" id ="p">600 Laks</option>
								<option value="100000000" id ="p">1000 Laks</option>
							</select>
						</div>
						&nbsp;&nbsp;
						<button type="submit" class="btn btn-primary py-2 px-3">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<div class="row mb-5 align-items-center">
				<div class="col-lg-6">
					<h2 class="font-weight-bold text-primary heading">Popular
						Properties</h2>
				</div>
				<div class="col-lg-6 text-lg-end">
					<p>
						<a href="#" target="_blank"
							class="btn btn-primary text-white py-3 px-4">View all
							properties</a>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="property-slider-wrap">
						<div class="property-slider">

							<c:forEach var="property" items="${propertyList}">

								<c:url var="detailLink" value="property">
									<c:param name="mode" value="DETAIL"></c:param>
									<c:param name="id" value="${property.propertyId}"></c:param>
								</c:url>


								<div class="property-item">
									<a href="property-detail.jsp" class="img"> <img
										src="data:image/jpg;base64,${property.base64Image}"
										alt="Image" class="img-fluid" />
									</a>

									<div class="property-content">
										<div>
											<span class="d-block mb-2 text-black-50"> <c:out
													value="${property.propertyId }"></c:out></span> <span
												class="city d-block mb-3"> <c:out
													value="${property.propertyName }"></c:out></span> <span
												class="city d-block mb-2"> <c:out
													value="${property.description }"></c:out></span>

											<div class="specs d-flex mb-4">
												<span class="d-block d-flex align-items-center"> <span
													class="icon-dollar me-2"></span> <span class="caption">
														<c:out value="${property.price }"></c:out>
												</span>
												</span> &nbsp;&nbsp; <span
													class="d-block d-flex align-items-center"> <span
													class="icon-bed me-2"> </span> <span class="caption">
														<c:out value="${property.roomNumber }"></c:out>
												</span>
												</span> &nbsp;&nbsp; <span
													class="d-block d-flex align-items-center"> <span
													class="icon-bath me-2"> </span> <span class="caption">
														<c:out value="${property.bedRoomNumber }"></c:out>
												</span>
												</span>
											</div>

											<a href="${detailLink }" class="btn btn-primary py-2 px-3">See
												details</a>
										</div>
									</div>
								</div>
								<!-- .item -->

							</c:forEach>

							<div id="property-nav" class="controls" tabindex="0"
								aria-label="Carousel Navigation">
								<span class="prev" data-controls="prev" aria-controls="property"
									tabindex="-1">Prev</span> <span class="next"
									data-controls="next" aria-controls="property" tabindex="-1">Next</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>	 
		 function priceChange() {
		        const box = document.getElementById("status").value;
		        document.getElementById("p").style.display = box == 2 ? 'block' : 'none';
		         
		   }
	</script>
	<c:import url="common/service.html"></c:import>

	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>