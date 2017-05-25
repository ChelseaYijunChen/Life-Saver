<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Life Save</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"><\/script>')
</script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="se-pre-con"></div>
	<div class="container marketing">
		<div class="col-md-12">
			<c:if test="${!empty doctorsList}">
				<table class="table">
					<thead class="thead-default">
						<tr>
							<th>Doctor Name</th>
							<th>Doctor Department</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${doctorsList}" var="doctor">
						<tbody>
							<tr>
								<td><c:out value='${doctor.doctorName}' /></td>
								<td><c:out value='${doctor.department.getDepartmentName()}' /></td>
								<td><a
									href="doctorWeekScheduelForm.html?doctorId=${doctor.doctorId}&page=0"
									class="btn btn-default">booking an appointment</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>

</html>