<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="../../favicon.ico">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<!-- <nav class="navbar navbar-inverse navbar-static-top">  -->
			<nav class="navbar navbar-light navbar-static-top"
				style="background-color:rgba(192,192,192,0.6); ">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- <a class="navbar-brand" href="#">Fig & Olive</a> -->
				</div>
				<div id="navbar" class="navbar-collapse collapse"
					style="color: white">
					<ul class="nav navbar-nav ">
						<li class="active"><a href="mainPage.jsp">Home</a></li>
						<li><a href="viewAllDepartments.html" target="iframe_a">Department</a></li>
						<!-- <li><a href="aboutUs.jsp" target="iframe_a">AboutUs</a></li> -->
					</ul>
<%-- 					<ul class="nav navbar-nav navbar-right">
						<li><a href="myAccount.jsp" target="iframe_a"> <span
								class="glyphicon glyphicon-user">${patientName}</span>
						</a></li>
						<li><a href="LogoutServlet">LogOut</a></li> 
					</ul> --%>
				</div>
			</div>
			</nav>
		</div>
	</div>
	<section class="section2">
	<div class="container-fluid ">
		<div class="col-sm-12 col-md-12 main">
			<iframe height="800px" width="100%" src="mainContain.jsp"
				name="iframe_a" style="border: none;">Welcome to Patienthome</iframe>
		</div>
	</div>
	</section>
</body>
</html>