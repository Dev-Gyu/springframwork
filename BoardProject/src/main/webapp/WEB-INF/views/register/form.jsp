<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="register.title"/></title>
</head>
<body>
<form:form modelAttribute="registerCommand">
<h2><spring:message code="register.title"/></h2><hr>
<spring:message code="email"/>: <form:input path="email"/><br>
<spring:message code="password"/>: <form:input path="password"/><br>
<spring:message code="name"/>: <form:input path="name"/><br>
<input type="submit" value="회원가입"/>
</form:form>
</body>
</html>