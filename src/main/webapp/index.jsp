<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"></c:import>
<title>Home Page</title>
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
						<input type="hidden" name="mode" value="SEARCH"> <input
							type="text" name="propertySearch" class="form-control px-4"
							placeholder="Your Property Status such as Rent , Sell or Buy..." />
						<button type="submit" class="btn btn-primary">Search</button>
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

								<div class="property-item">
									<a href="property-single.html" class="img"> <img
										src="data:image/jpg;base64,${property.base64Image}"
										alt="Image" class="img-fluid" />
									</a>

									<div class="property-content">
										<div class="mb-2">
											<span>aa</span>
										</div>
										<div>
											<span class="d-block mb-2 text-black-50"><c:out
													value="${property.propertyId }"></c:out></span> <span
												class="city d-block mb-3"><c:out
													value="${property.propertyName }"></c:out></span>

											<div class="specs d-flex mb-4">
												<span class="d-block d-flex align-items-center me-3">
													<span class="icon-bed me-2"></span> <span class="caption"><c:out
															value="${property.description }"></c:out></span>
												</span> <span class="d-block d-flex align-items-center"> <span
													class="icon-bath me-2"></span> <span class="caption"><c:out
															value="${property.price }"></c:out></span>
												</span> <span class="d-block d-flex align-items-center"> <span
													class="icon-bath me-2"></span> <span class="caption"><c:out
															value="${property.roomNumber }"></c:out></span>
												</span>
											</div>

											<a href="property-single.html"
												class="btn btn-primary py-2 px-3">See details</a>
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

	<c:import url="common/service.html"></c:import>

	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>