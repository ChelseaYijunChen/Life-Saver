<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Fig & Olive</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}css/carousel.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>
</head>
<body>
	<div class="container marketing">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-12">
					<form:form action="searchPatientByName.html" method="post"
						role="form" modelAttribute="doctorWeekSchedule">
						<table class="table">
							<thead class="thead-default">
								<tr>
									<th>Sunday</th>
									<th>Monday</th>
									<th>Tuesday</th>
									<th>Wednesday</th>
									<th>Thursday</th>
									<th>Friday</th>
									<th>Saturday</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<c:forEach items="${doctorWeekSchedule.workDate}"
										var="workDate">
										<td><c:out value="${workDate}"></c:out></td>
									</c:forEach>
								</tr>
								<tr>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[0]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[0]}</a>
									</td>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[1]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[1]}</a>
									</td>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[2]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[2]}</a>
									</td>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[3]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[3]}</a>
									</td>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[4]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[4]}</a>
									</td>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[5]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[5]}</a>
									</td>
									<td><a
										href="newAppointment.html?appointmentDate=${doctorWeekSchedule.workDate[6]}&doctorId=${doctorId}">${doctorWeekSchedule.officeHour[6]}</a>
									</td>
								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-sm-3 col-sm-6 ">
					<button type="button" class="btn btn-default" id="previous">previous</button>
				</div>
				<div class="offset-sm-3 col-sm-6 ">
					<button type="button" class="btn btn-default" id="next">next</button>
				</div>
			</div>
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
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			var page = $
			{
				doctorWeekSchedule.page
			}
			;
			if (page == 0) {
				$("#previous").prop('disabled', true);
			}
			if (page == 10) {
				$("#next").prop('disabled', true);
			}
		});
		$("#previous").click(
				function() {
					var page = $
					{
						doctorWeekSchedule.page
					}
					-1;
					var docotrId = $
					{
						doctorWeekSchedule.doctorId
					}
					;
					location.href = "doctorWeekScheduelForm.html?doctorId="
							+ docotrId + "&page=" + page;
				});
		$("#next").click(
				function() {
					var page = $
					{
						doctorWeekSchedule.page
					}
					+1;
					var docotrId = $
					{
						doctorWeekSchedule.doctorId
					}
					;
					location.href = "doctorWeekScheduelForm.html?doctorId="
							+ docotrId + "&page=" + page;
				});
	</script>
</body>
</html>