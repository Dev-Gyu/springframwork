<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="register.title"/></title>
</head>
<body>
	<form:form>
	<label>
	<spring:message code="form.email"/>
	<form:input path="email"/>
	<form:errors path="email"/>
	</label><br>
	<label>
	<spring:message code="form.password"/><form:input path="password"/><form:errors path="password"/>
	</label><br>
	<label>
	<spring:message code="form.name"/><form:input path="name"/><form:errors path="name"/>
	</label><br>
	<input type="submit" value="<spring:message code='form.submit'/>"/>
	</form:form>
</body>
</html>