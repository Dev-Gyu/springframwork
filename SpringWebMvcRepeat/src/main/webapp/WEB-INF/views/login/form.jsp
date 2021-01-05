<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form modelAttribute="loginCommand">
	<form:errors/><br>
	<label>
		<spring:message code="form.email"/>
		<form:input path="email"/>
		<form:errors path="email"/>
	</label><br>
	<label>
		<spring:message code="form.password"/>
		<form:input path="password"/>
		<form:errors path="password"/>
	</label>
	<input type="submit" value="<spring:message code='login.btn'/>"/>
	</form:form>
</body>
</html>