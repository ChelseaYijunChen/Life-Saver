<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>

	  		<div class="container ">
				<div class="col-md-10">
					<form:form action="doctorLoginForm.html" method="post" id="loginform1" modelAttribute="doctor">
					<h2 class="" style="text-align: center;">Login</h2>
 						<div class="form-group row">
						<form:label path="email" class="col-sm-3 col-form-label">Email Address</form:label>
							<div class="col-sm-9">
								<form:input path="email" type="email" class="form-control" name="userEmail" placeholder="Joey@gamil.com" />
							</div>
						</div> 
				 <div class="form-group row">
							<form:label path="password" class="col-sm-3 col-form-label">Password</form:label>
							<div class="col-sm-9">
								<form:input path="password" type="password" class="form-control" name="password" placeholder="Password"/>
							</div>
						</div>   
						<div class="form-group row">
							<div class="offset-sm-3 col-sm-9 text-center">
								<button type="submit" class="btn btn-default" >Login</button>
							</div>
						</div>
						<div class="form-group row">
           					<div class="offset-sm-3 col-sm-9">
             					<span id="message1"></span>
          					</div>
         				</div>
					</form:form>		
				</div>		
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>