<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Life Saver</title>
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
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-12">
					<form:form action="addSchdule.html" method="post" id="form"
						modelAttribute="schedule">
						<h2 class="" style="text-align: center;">New Schedule</h2>

						<div class="form-group row">
							<label for="id" class="col-sm-3 col-form-label">Doctor ID</label>
							<div class="col-sm-8">
								<input class="form-control" value="<%=doctorId%>"
									name="doctorId" readonly /> <span
									class="form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Monday"
								name="workDay1" />Monday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin1'>
									<input type='text' class="form-control" name="beginTime1" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end1'>
									<input type='text' class="form-control" name="endTime1" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Tuesday"
								name="workDay2" />Tuesday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin2'>
									<input type='text' class="form-control" name="beginTime2" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end2'>
									<input type='text' class="form-control" name="endTime2" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Wednesday"
								name="workDay3">Wednesday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin3'>
									<input type='text' class="form-control" name="beginTime3" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end3'>
									<input type='text' class="form-control" name="endTime3" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Thursday"
								name="workDay4">Thursday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin4'>
									<input type='text' class="form-control" name="beginTime4" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end4'>
									<input type='text' class="form-control" name="endTime4" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Friday"
								name="workDay5">Friday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin5'>
									<input type='text' class="form-control" name="beginTime5" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end5'>
									<input type='text' class="form-control" name="endTime5" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Saturday"
								name="workDay6">Saturday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin6'>
									<input type='text' class="form-control" name="beginTime6" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end6'>
									<input type='text' class="form-control" name="endTime6" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label class="form-check-label col-sm-2"> <input
								type="checkbox" class="form-check-input" value="Sunday"
								name="workDay7">Sunday
							</label> <label for="exampleSelect1" class="col-sm-2 col-form-label">Begin
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='begin7'>
									<input type='text' class="form-control" name="beginTime7" /> <span
										class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
							<label for="exampleSelect1" class="col-sm-2 col-form-label">End
								Hour</label>
							<div class="col-sm-3">
								<div class='input-group date' id='end7'>
									<input type='text' class="form-control" name="endTime7" /> <span
										class="input-group-addon"> <span
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
		$('#begin1').datetimepicker({
			format : 'LT'
		});
		$('#end1').datetimepicker({
			format : 'LT'
		});
		$("#begin1").on("dp.change", function(e) {
			$('#end1').data("DateTimePicker").minDate(e.date);
		});
		$("#end1").on("dp.change", function(e) {
			$('#begin1').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#begin2').datetimepicker({
			format : 'LT'
		});
		$('#end2').datetimepicker({
			format : 'LT'
		});
		$("#begin2").on("dp.change", function(e) {
			$('#end2').data("DateTimePicker").minDate(e.date);
		});
		$("#end2").on("dp.change", function(e) {
			$('#begin2').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#begin3').datetimepicker({
			format : 'LT'
		});
		$('#end3').datetimepicker({
			format : 'LT'
		});
		$("#begin3").on("dp.change", function(e) {
			$('#end3').data("DateTimePicker").minDate(e.date);
		});
		$("#end3").on("dp.change", function(e) {
			$('#begin3').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#begin4').datetimepicker({
			format : 'LT'
		});
		$('#end4').datetimepicker({
			format : 'LT'
		});
		$("#begin4").on("dp.change", function(e) {
			$('#end4').data("DateTimePicker").minDate(e.date);
		});
		$("#end4").on("dp.change", function(e) {
			$('#begin4').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#begin5').datetimepicker({
			format : 'LT'
		});
		$('#end5').datetimepicker({
			format : 'LT'
		});
		$("#begin5").on("dp.change", function(e) {
			$('#end5').data("DateTimePicker").minDate(e.date);
		});
		$("#end5").on("dp.change", function(e) {
			$('#begin5').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#begin6').datetimepicker({
			format : 'LT'
		});
		$('#end6').datetimepicker({
			format : 'LT'
		});
		$("#begin6").on("dp.change", function(e) {
			$('#end6').data("DateTimePicker").minDate(e.date);
		});
		$("#end6").on("dp.change", function(e) {
			$('#begin6').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('#begin7').datetimepicker({
			format : 'LT'
		});
		$('#end7').datetimepicker({
			format : 'LT'
		});
		$("#begin7").on("dp.change", function(e) {
			$('#end7').data("DateTimePicker").minDate(e.date);
		});
		$("#end7").on("dp.change", function(e) {
			$('#begin7').data("DateTimePicker").maxDate(e.date);
		});

	});
</script>
<script type="text/javascript">
	$('#timepicker1').timepicker();
</script>
</html>