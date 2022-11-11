<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
  
<div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close">
          <span class="icofont-close js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
    <nav class="site-nav">
      <div class="container">
        <div class="menu-bg-wrap">
          <div class="site-navigation">
            <a href="index.jsp" class="logo m-0 float-start">Property</a>

            <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
              <li class="active"><a href="index.jsp">Home</a></li>
              <li class="has-children">
                <a href="properties.html">Properties</a>
                <ul class="dropdown">
                  <li><a href="#">Buy Property</a></li>
                  <li><a href="#">Sell Property</a></li>
                </ul>
              </li>
              <li><a href="services.jsp">Services</a></li>
              <li><a href="contact.jsp">Contact Us</a></li>
              <li><a href="property-register.jsp">Register Property</a></li>
              <li><a href="property-list.jsp">PropertyList</a></li>
              <li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false"><c:out value="${admin.username }"></c:out></a>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="property?mode=LOGOUT">Logout</a></li>
						</ul></li>
            </ul>
            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none"
						data-toggle="collapse" data-target="#main-navbar">
              <span></span>
            </a>
          </div>
        </div>
      </div>
    </nav>
