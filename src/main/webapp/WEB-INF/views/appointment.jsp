<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.service.ScheduleServiceImpl"
	import="com.pojo.Schedule" import="java.util.List"
	import="java.util.Set" import="java.util.HashSet"
	import="java.util.ArrayList"%>
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

<title>New Schedule</title>
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
	<div class="se-pre-con"></div>
	<div class="container loginSession">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-12">
					<form:form action="newAppointment.html" method="post" id="form"
						modelAttribute="appointment">
						<%--  <c:set var="myDoctorId" value="${result}" />  --%>
						<c:forEach items="${result}" var="aaa">
							<c:out value="${aaa}"></c:out>
						</c:forEach>
						<input type="text" id="result" value="${result}" />
						<input type="text" id="res" value="${res}" />
						<input type="hidden" id="MyDoctorId" name="doctorId"
							value="${appointment.doctor.doctorId}" />
						<input type="hidden" name="patientId"
							value="${appointment.patient.patientId}" />
						<div class="form-group row">
							<form:label path="appointmentDate"
								class="col-sm-2 col-form-label">Appointment</form:label>
							<div class="col-sm-5">
								<div class='input-group date' id='date1'>
									<form:input path="appointmentDate" type='text'
										class="form-control" name="date1" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-time"></span>
									</span>
								</div>
							</div>
						</div>
						<input type="submit" class="btn btn-default" value="Booking">
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
<%
	/* ScheduleServiceImpl scheduleService = new ScheduleServiceImpl(); */
	/* Integer doctorId = (Integer)pageContext.getAttribute("myDoctorId");  */
	/* List<Schedule> sList = scheduleService.viewScheduleByDoctorId(new Integer("1")); */
	/* 	int[] s1 = new int[sList.size()];
		List<Integer> result = new ArrayList<Integer>();
		for(int i =0; i<sList.size(); i++){
			if(sList.get(i).getWorkDay().equals("Sunday")){
				s1[0]++;
			} else if(sList.get(i).getWorkDay().equals("Monday")) {
				s1[1]++;
			} else if(sList.get(i).getWorkDay().equals("Tuesday")){
				s1[2]++;
			} else if(sList.get(i).getWorkDay().equals("Wednesday")){
				s1[3]++;
			} else if(sList.get(i).getWorkDay().equals("Thursday")){
				s1[4]++;
			} else if(sList.get(i).getWorkDay().equals("Friday")){
				s1[5]++;
			} else {
				s1[6]++;
			}
		}
		for(int i = 0; i< 7 ; i++){
			if(s1[i] == 0){
				result.add(i);
			}
		}
		int[] res = new int[7-result.size()];
		for(int i = 0; i<result.size(); i++){
			res[i]=result.get(i);
		} */
%>


<script type="text/javascript">
	/* var disDay = $('result'); */
	var disDay = document.getElementById("result").value;
	var disDay2 = document.getElementById("result");
	var res = document.getElementById("res").value;
	var res2 = document.getElementById("res");
	var myId = document.getElementById("MyDoctorId").value;
	var myId2 = document.getElementById("aaa").value;
	$(function() {

		$('#date1').datetimepicker({
			/* daysOfWeekDisabled:"myDoctorId" */
			daysOfWeekDisabled : [ 0, 1 ]

		});

		/* alert($('#result').val); */
		alert(disDay);
		alert(disDay2);
		alert(res);
		alert(res2);
		alert(myId);
		alert(myId2);
	});
</script>
<script type="text/javascript">
	$('#timepicker1').timepicker();
</script>

</html>