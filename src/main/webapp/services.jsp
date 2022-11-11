<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"></c:import>
<title>Service Page</title>
</head>
<body>
	<!-- Responsive navbar-->
	<c:import url="common/navbar.jsp"></c:import>

	<div class="hero page-inner overlay"
		style="background-image: url('images/hero_bg_1.jpg')">
		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up">Services</h1>

					<nav aria-label="breadcrumb" data-aos="fade-up"
						data-aos-delay="200">
						<ol class="breadcrumb text-center justify-content-center">
							<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
							<li class="breadcrumb-item active text-white-50"
								aria-current="page">Services</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<c:import url="common/service.html"></c:import>
	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>