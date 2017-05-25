<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd ">
<html lang="en">
<head>
<!-- <meta charset="utf-8"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<link rel="icon" href="../../favicon.ico">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
<link
	href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css"
	rel="stylesheet">
<title></title>

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resource/css/style.css"
	rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
</head>

<body>
	<div class="se-pre-con"></div>
	<div class="container marketing">
		<div class="jumbotron ">
			<div class="row">
				<form action="NewCategoryServlet" method="post" id="form">
					<h2 class="" style="text-align: center;">Schedule</h2>
					<div class="form-group row">
						<label for="" class="col-sm-3 col-form-label">Category
							Name</label>
						<div class="col-sm-9">
							<input type="text" cssClass="form-control" id="categoryName"
								name="categoryName" maxlength="20" placeholder="Taco" required>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="workDay" cssClass="col-sm-3 col-form-label">Word Day</form:label>
						<div class="col-sm-9">
							<form:radiobutton path="workDay" value="Sunday" />
							Sunday
						</div>
						<form:radiobutton path="workDay" value="Monday" />
						Monday
						<form:radiobutton path="workDay" value="Tuesday" />
						Tuesday
						<form:radiobutton path="workDay" value="Wednesday" />
						Wednesday
						<form:radiobutton path="workDay" value="Thursday" />
						Thursday
						<form:radiobutton path="workDay" value="Friday" />
						Friday
						<form:radiobutton path="workDay" value="Saturday" />
						Saturday
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
				</form>
			</div>
		</div>
	</div>
</body>
</html>