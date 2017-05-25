<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.pojo.Doctor"%>
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
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">

<!-- Bootstrap core JavaScript
	================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"><\/script>')
</script>
<script src="js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<!--   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" /> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
</head>
<body>
	<%
		Doctor doctor = (Doctor) session.getAttribute("d1");
		int doctorId = doctor.getDoctorId();
	%>
	<div class="se-pre-con"></div>
	<div class="container loginSession">
		<!-- Example row of columns -->
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-12">
					<form:form action="addAbsent.html" method="post" id="form"
						modelAttribute="absent">
						<h2 class="" style="text-align: center;">New Absent</h2>
						<div class="form-group row">
							<label for="id" class="col-sm-4 col-form-label">Doctor ID</label>
							<div class="col-sm-8">
								<input class="form-control" value="<%=doctorId%>"
									name="doctorId" readonly /> <span
									class="form-control-feedback"></span>
							</div>
						</div>
						<div class="form-group row">
							<form:label path="leavingDate" class="col-sm-4 col-form-label">Leaving Date</form:label>
							<div class="col-sm-8">
								<div class='input-group date' id='leavingDate'>
									<form:input path="leavingDate" type='text' class="form-control"
										name="leavingDate" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<form:label path="returnDate" class="col-sm-4 col-form-label">Return Date</form:label>
							<div class="col-sm-8">
								<div class='input-group date' id='returnDate'>
									<form:input path="returnDate" type='text' class="form-control"
										name="returnDate" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<div class="offset-sm-3 col-sm-9 text-center">
								<button type="submit" class="btn btn-danger">Submit</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('#leavingDate').datetimepicker({
		/* format: 'LT' */
		});
		$('#returnDate').datetimepicker({
		/* format: 'LT' */
		});
		$("#leavingDate").on("dp.change", function(e) {
			$('#returnDate').data("DateTimePicker").minDate(e.date);
		});
		$("#returnDate").on("dp.change", function(e) {
			$('#leavingDate').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
</html>