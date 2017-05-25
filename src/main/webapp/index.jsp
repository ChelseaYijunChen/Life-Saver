<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
<link href="css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/carousel.css" rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>  -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>

</head>
<!-- NAVBAR
================================================== -->
<body>
	<%
		response.addHeader("Cache-Control",
				"no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0");
		response.addHeader("Pragma", "no-cache");
		response.addDateHeader("Expires", 0);
	%>

	<div class="navbar-wrapper">
		<div class="container">
			<!-- <nav class="navbar navbar-inverse navbar-static-top"> -->
			<nav class="navbar navbar-light navbar-static-top col-sm-6"
				style="background-color:rgba(192,192,192,0.6);">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse"
					style="color: white">
					<ul class="nav navbar-nav ">
						<li><a href="patientLogin.html"><h3>User Login</h3></a></li>
						<li><a href="doctorLogin.html">
								<h3>Doctor LogIn</h3>
						</a></li>
						<li><a href="doctorLogin.html"><h3>Admin Login</h3></a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>

	<div class="jumbotron hero-nature">
		<div class="container">
			<h1>Welcome</h1>
			<p>Need a doctor?</p>
			<p>Make an Appointment</p>
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
	<script src="js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
