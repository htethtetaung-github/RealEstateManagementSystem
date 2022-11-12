<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RealEstate</title>
<link href="css/signin.css" rel="stylesheet" />
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'></script>
<script
	src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
<script
	src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
</head>

<body>
	<div class="row">
		<div class="col-md-6 mx-auto p-0">
			<div class="card">
				<div class="login-box">
					<div class="login-snip">
						<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
							for="tab-1" class="tab">Login</label> <input id="tab-2"
							type="radio" name="tab" class="sign-up"><label
							for="tab-2" class="tab">Sign Up</label>
						<div class="login-space">

							<form action="login" method="post">

								<input type="hidden" name="mode" value="SIGNIN">

								<div class="login">
									<div class="group">
										<label for="email" class="label">Email</label> <input
											id="email" name="email" type="text" class="input"
											placeholder="Enter your email">
									</div>
									<div class="group">
										<label for="pass" class="label">Password</label> <input
											id="pass" name="password" type="password" class="input"
											data-type="password" placeholder="Enter your password">
									</div>
									<div class="group">
										<input id="check" type="checkbox" class="check" checked>
										<label for="check"><span class="icon"></span> Keep me
											Signed in</label>
									</div>
									<div class="group">
										<input type="submit" class="button" value="Sign In"> <input
											type="reset" class="button" value="Reset">
									</div>
									<c:if test="${loginFail}">
										<div class="mb-3">
											<span class="alert alert-danger"> Username or password
												is incorrect</span>
										</div>
									</c:if>
									<div class="hr"></div>
									<div class="foot">
										<a href="#">Forgot Password?</a>
									</div>
								</div>
							</form>

							<form action="admin" method="post">
								<input type="hidden" name="mode" value="SIGNUP">
								<div class="sign-up-form">
									<div class="group">
										<label for="user" class="label">Username</label> <input
											id="user" name="username" type="text" class="input"
											placeholder="Create your Username">
									</div>
									<div class="group">
										<label for="email" class="label">Email Address</label> <input
											id="email" name="email" type="text" class="input"
											placeholder="Enter your email address">
									</div>
									<div class="group">
										<label for="pass" class="label">Password</label> <input
											id="pass" name="password" type="password" class="input"
											data-type="password" placeholder="Create your password">
									</div>
									<div class="group">
										<label for="phone" class="label">Phone</label> <input
											id="phone" name="phone" type="text" class="input"
											placeholder="Enter your contact number">
									</div>
									<div class="group">
										<label for="address" class="label">Address</label> <input
											id="address" name="address" type="text" class="input"
											placeholder="Enter your address">
									</div>

									<div class="group">
										<input type="checkbox" class="form-check-input" id="role"
											name="role" value="true"> <label
											class="form-check-label" for="role">Admin</label>
									</div>

									<div class="group">
										<input type="submit" class="button" value="Sign Up"> <input
											type="reset" class="button" value="Reset">
									</div>
									<div class="foot">
										<label for="tab-1">Already Member?</label>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>