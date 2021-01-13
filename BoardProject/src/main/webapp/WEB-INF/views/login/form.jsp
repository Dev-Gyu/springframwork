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
	<h2><spring:message code="login.title"/></h2><hr>
	<form:form modelAttribute="loginCommand">
	<form:errors/><br>
	<spring:message code="email"/><form:input path="email"/><br>
	<spring:message code="password"/><form:input path="password"/><br>
	<input type="submit" value="<spring:message code="login.title"/>"/>
	</form:form>
</body>
</html>