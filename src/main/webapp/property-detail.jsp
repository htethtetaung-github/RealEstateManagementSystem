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
								aria-current="page">5232 California AVE.
								21BC</li>
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
					<h2 class="heading text-primary">5232 California Ave. 21BC</h2>
					<p class="meta">California, United States</p>
					<p class="text-black-50">Lorem ipsum dolor sit amet
						consectetur, adipisicing elit. Ratione laborum quo quos omnis sed
						magnam id, ducimus saepe, debitis error earum, iste dicta odio est
						sint dolorem magni animi tenetur.</p>
					<p class="text-black-50">Perferendis eligendi reprehenderit,
						assumenda molestias nisi eius iste reiciendis porro tenetur in,
						repudiandae amet libero. Doloremque, reprehenderit cupiditate
						error laudantium qui, esse quam debitis, eum cumque perferendis,
						illum harum expedita.</p>

					<div class="d-block agent-box p-5">
						<div class="img mb-4">
							<img src="images/person_2-min.jpg" alt="Image" class="img-fluid" />
						</div>
						<div class="text">
							<h3 class="mb-0">Alicia Huston</h3>
							<div class="meta mb-3">Real Estate</div>
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Ratione laborum quo quos omnis sed magnam id ducimus saepe</p>
							<ul class="list-unstyled social dark-hover d-flex">
								<li class="me-1"><a href="#"><span
										class="icon-instagram"></span></a></li>
								<li class="me-1"><a href="#"><span class="icon-twitter"></span></a>
								</li>
								<li class="me-1"><a href="#"><span
										class="icon-facebook"></span></a></li>
								<li class="me-1"><a href="#"><span
										class="icon-linkedin"></span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>