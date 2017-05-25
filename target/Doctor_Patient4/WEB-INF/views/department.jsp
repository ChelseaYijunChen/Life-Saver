<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 main">
				<h1 class="page-header">Department</h1>
				<c:if test="${!empty departmentList}">
					<%-- <form:form action="viewDoctorByDepartment.html" method="post" modelAttribute="department"> --%>
					<c:forEach items="${departmentList}" var="department">
						<div class="row placeholders">
							<div class="col-xs-6 col-sm-3 placeholder">
								<h4>
									<a
										href="viewDoctorByDepartment.html?departmentId=${department.departmentId}"
										class="btn btn-default"> <c:out
											value='${department.departmentName}' /></a>
								</h4>
								<!-- <span class="text-muted">Something else</span> -->
							</div>
						</div>
					</c:forEach>
				</c:if>
				<%-- </form:form> --%>
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
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>