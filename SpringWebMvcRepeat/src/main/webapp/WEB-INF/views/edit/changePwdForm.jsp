<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="changePwd.title"/></title>
</head>
<body>
	<form:form modelAttribute="changePasswordCommand">
		<label>
		<spring:message code="changePwd.currentPwd"/>
		<form:input path="currentPassword"/>
		<form:errors path="currentPassword"/>
		</label><br>
		<label>
		<spring:message code="changePwd.newPwd"/>
		<form:input path="newPassword"/>
		<form:errors path="newPassword"/>
		</label>
		<input type="submit" value="<spring:message code='changePwd.submit'/>"/>
	</form:form>
</body>
</html>