<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Life Save</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/carousel.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>

	<div class="container ">
		<div class="col-md-5">
			<form:form action="patientLoginForm.html" method="post"
				id="loginform1" modelAttribute="patient">
				<h2 class="" style="text-align: center;">Login</h2>
				<div class="form-group row">
					<form:label path="email" class="col-sm-3 col-form-label">Email Address</form:label>
					<div class="col-sm-9">
						<form:input path="email" type="email" class="form-control"
							name="userEmail" placeholder="Joey@gamil.com" />
					</div>
				</div>
				<div class="form-group row">
					<form:label path="password" class="col-sm-3 col-form-label">Password</form:label>
					<div class="col-sm-9">
						<form:input path="password" type="password" class="form-control"
							name="password" placeholder="Password" />
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-sm-3 col-sm-9 text-center">
						<button type="submit" class="btn btn-default">Login</button>
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-sm-3 col-sm-9">
						<span id="message1"></span>
					</div>
				</div>
			</form:form>
		</div>

		<div class="col-md-5">
			<form action="RegisterServlet" method="post" id="registerform"
				role="form" data-toggle="validator">
				<h2 class="" style="text-align: center;">New User</h2>
				<div class="form-group row">
					<label for="" class="col-sm-3 col-form-label">Full Name</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="fullName"
							placeholder="Joey" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="" class="col-sm-3 col-form-label">Email</label>
					<div class="col-sm-9">
						<input type="email" class="form-control" name="email1"
							placeholder="Joey@gmail.com"
							data-error="That email address is invalid" required>
						<div class="help-block with-errors"></div>
					</div>
				</div>
				<div class="form-group row">
					<label for="" class="col-sm-3 col-form-label">Phone Number</label>
					<div class="col-sm-9">
						<input type="number" class="form-control" name="phoneNum1"
							max="9999999999" placeholder="8641231234"
							data-error="Please provide 10 digit phonenum" required>
						<div class="help-block with-errors"></div>
					</div>
				</div>
				<div class="form-group row">
					<label for="" class="col-sm-3 col-form-label">Address</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="address"
							maxlength="100" placeholder="3809 Midssion Ave" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="" class="col-sm-3 col-form-label">Password</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="password1"
							name="password1" minlength="3" maxlength="50"
							placeholder="Password" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="" class="col-sm-3 col-form-label">Confirm
						Password</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="password2"
							name="password2" data-match="#password1"
							data-match-error="Whoops, these don't match"
							placeholder="Confirm Password" required>
						<div class="help-block with-errors"></div>
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-sm-3 col-sm-9 text-center">
						<button type="submit" class="btn btn-default">Register</button>
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-sm-3 col-sm-9">
						<span id="message2"></span>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document.write('<script src="js/jquery.min.js"><\/script>')
	</script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>