<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="signout.title"/></title>
</head>
<body>
	<h3><spring:message code="input.nowPassword"/></h3>
	<form:form modelAttribute="signOutCommand">
	<form:errors/><br>
	<spring:message code="password"/><input type="text" name="nowPassword"/>
	<input type="submit" value="회원탈퇴"/>
	</form:form>

</body>
</html>