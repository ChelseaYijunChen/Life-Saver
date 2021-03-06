<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Life Save</title>
</head>
<body>
	<form:form cssClass="form" method="POST"
		action="addOrUpdateDoctor.html" modelAttribute="doctor">
		<div class="form-group row">
			<form:label path="doctorId" for="id"
				cssClass="col-sm-4 col-form-label">Doctor ID</form:label>
			<div class="col-sm-8">
				<form:input path="doctorId" cssClass="form-control"
					placeholder="Doctor ID will be autogenerated" disabled="true" />
				<span class="form-control-feedback"></span>
			</div>
		</div>

		<div class="form-group row">
			<form:label path="doctorName" for="fullName"
				cssClass="col-sm-4 col-form-label">Doctor Name</form:label>
			<div class="col-sm-8">
				<form:input path="doctorName" cssClass="form-control"
					placeholder="Doctor Name" />
				<span class="form-control-feedback"></span>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="isAdmin" class="col-sm-3"
				for="inlineFormCustomSelect">Admin?</form:label>
			<div class="col-sm-9">
				<form:select path="isAdmin" class="form-control "
					id="inlineFormCustomSelect" name="departmentId">
					<!-- <option selected></option> -->
					<%-- <c:forEach items= "${deparmentList}" var="department"> 
					<option value="0" >${department.getDepartmentName()}</option>  --%>
					<option value="Yes">Yes</option>
					<option value="No">No</option>
					<%-- </c:forEach>  
				 <c:out value="${department.getDepartmentName()}">${department.getDepartmentName()}</c:out> --%>
				</form:select>
			</div>
		</div>

		<%-- <div class="form-group row">
                                <form:label path="specialty" for="specialty" cssClass="col-sm-4 col-form-label">Specialty</form:label>
                                <div class="col-sm-8">
                                    <form:input path="specialty" cssClass="form-control" placeholder="Specialty" />
                                    <span class="form-control-feedback"></span>
                                </div>
                            </div> --%>

		<div class="form-group row">
			<form:label path="email" for="email"
				cssClass="col-sm-4 col-form-label">Email</form:label>
			<div class="col-sm-8">
				<form:input path="email" cssClass="form-control" placeholder="Email" />
				<span class="form-control-feedback"></span>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="password" for="password"
				cssClass="col-sm-4 col-form-label">Password</form:label>
			<div class="col-sm-8">
				<form:password path="password" showPassword="true"
					cssClass="form-control" placeholder="Password" />
				<span class="form-control-feedback"></span>
			</div>
		</div>
		<div class="text-center">
			<input class="btn btn-primary" type="submit" value="Add New Doctor" />
		</div>
	</form:form>
</body>
</html>