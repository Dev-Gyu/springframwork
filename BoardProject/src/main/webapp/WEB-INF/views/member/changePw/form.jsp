<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="changePw.title"/></title>
</head>
<body>
	<h2><spring:message code="changePw.title"/></h2><hr>
	<h3>현재 비밀번호와 변경할 비밀번호를 입력해주세요.</h3>
	<form:form modelAttribute="changePwCommand">
	<form:errors/><br>
	<spring:message code="oldPassword"/>:<form:input path="oldPassword"/>
	<spring:message code="newPassword"/>:<form:input path="newPassword"/>
	<input type="submit" value="변경"/>
	</form:form>
</body>
</html>