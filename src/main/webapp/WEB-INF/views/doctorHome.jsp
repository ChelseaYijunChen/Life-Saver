<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pojo.Doctor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<link rel="icon" href="../../favicon.ico">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
</head>
<body>
	<%
		/* response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies. */
		/* 	    Doctor doctor = (Doctor)request.getSession();	    
			   	int doctorId = doctor.getDoctorId(); */

		/* 	    if(email==null){
			    	response.sendRedirect("index.jsp");
			    } */
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Doctor Home</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout.html">Log Out</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" style="">
					<li><a href="#" target="iframe_a">View Appointment</a></li>
					<li><a href="addScheduleForm.html" target="iframe_a">New Schedule</a></li>
					<li><a href="viewSchedule.html" target="iframe_a">View Schedule</a></li>
					<li><a href="viewPatientByDoctor.html" target="iframe_a">Patient
							List</a></li>
					<li><a href="newAbsentForm.html" target="iframe_a">Request
							Leaving</a></li>
					<li><a href="viewAbsentByDoctor.html" target="iframe_a">View Requested
							Leaving</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<iframe height="800px" width="100%" src="" name="iframe_a"
					style="border: none;">Welcome to Adminhome</iframe>
			</div>
		</div>
	</div>
</body>
</html>