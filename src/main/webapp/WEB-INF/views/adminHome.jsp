<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%--   <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setDateHeader("Expires", 0); // Proxies.
	    
	   	String email=(String)request.getSession().getAttribute("email");
	    
	    if(email==null){
	    	response.sendRedirect("index.jsp");
	    }
	%> --%>
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
			<a class="navbar-brand" href="#">Admin Home</a>
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
				<ul class="nav " style="">
					<li><a href="addOrUpdateDoctorForm.html" target="iframe_a">Add
							a Doctor</a></li>
					<li><a href="viewAllDoctors.html" target="iframe_a">View
							All Doctors</a></li>
					<li><a href="searchDoctor.html" target="iframe_a">Search a
							Doctor</a></li>
					<!-- <li><a href="addScheduleForm.html" target="iframe_a">New
							Schedule</a></li> -->
				</ul>
				<ul class="nav " style="">
					<li><a href="viewAbsentNeedToBeApproved.html" target="iframe_a">Waiting Approve for Absent</a></li>
					<li><a href="viewApprovedAbsent.html" target="iframe_a">View Approved Absent</a></li>
					<li><a href="viewAllDepartments.html" target="iframe_a">View
							Department</a></li>
				</ul>
				<ul class="nav ">
					<li><a href="addOrUpdatePatientForm.html" target="iframe_a">Add
							a Patient</a></li>
					<li><a href="viewAllPatients.html" target="iframe_a">View
							All Patient</a></li>
					<li><a href="searchPatient.html" target="iframe_a">Search
							a Patient</a></li>
					<!-- <li><a href="appointmentForm.html" target="iframe_a">Make
							a appointment</a></li> -->
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- <h1 class="page-header">Welcome to Adminhome</h1> -->
				<iframe height="800px" width="100%" src="" name="iframe_a"
					style="border: none;">Welcome to Adminhome</iframe>
			</div>
		</div>
	</div>
</body>
</html>
