<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title></title>

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/carousel.css"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="../js/vendor/jquery.min.js"><\/script>')
</script>
<script src="js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
	<div class="container marketing">
		<!-- Example row of columns -->
		<div class="jumbotron">
			<div class="row">
				<!-- <div class="login-session-1"> -->
				<div class="col-md-10">
					<!-- <form action="RegisterServlet" method="post" id="registerform" > -->
					<form:form action="addOrUpdatePatient.html" method="post"
						id="loginform1" modelAttribute="patient">
						<h2 class="" style="text-align: center;">New Or Update
							Patient</h2>
						<div class="form-group row">
							<form:label path="patientName" class="col-sm-3 col-form-label">Full Name</form:label>
							<div class="col-sm-9">
								<form:input path="patientName" type="text" class="form-control"
									name="fullName" placeholder="Joey" />
							</div>
						</div>
						<div class="form-group row">
							<form:label path="email" class="col-sm-3 col-form-label">Email</form:label>
							<div class="col-sm-9">
								<form:input path="email" type="email" class="form-control"
									name="email1" placeholder="Joey@gmail.com" />
							</div>
						</div>
						<div class="form-group row">
							<form:label path="gender" class="col-sm-3 col-form-label">Gender</form:label>
							<div class="col-sm-9">
								<form:radiobutton path="gender" value="Male" />
								Male
								<form:radiobutton path="gender" value="Female" />
								Female
								<%-- <form:errors path="sex" cssClass="error" /> --%>
							</div>
						</div>
						<div class="form-group row">
							<form:label path="password" class="col-sm-3 col-form-label">Password</form:label>
							<div class="col-sm-9">
								<form:input path="password" type="password" class="form-control"
									id="password1" name="password1" />
							</div>
						</div>
						<!-- <div class="form-group row"> 
           <label for="" class="col-sm-3 col-form-label">Confirm Password</label>
           <div class="col-sm-9">
             <input type="password" class="form-control" id="password2" name="password2" >
           	<div class="help-block with-errors"></div>
           </div> -->
				</div>
				<div class="form-group row">
					<div class="offset-sm-3 col-sm-9 text-center">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
				<div class="form-group row">
					<div class="offset-sm-3 col-sm-9">
						<span id="message"></span>
					</div>
				</div>
				</form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#form").submit(
				function(e) {
					e.preventDefault();
					$.post("NewProductServlet", $(this).serialize(), function(
							data, status) {
						$("#message").html(data);
						//alert("Data: " + data + "\nStatus: " + status);
					});

				});
	</script>
</body>
</html>