<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="detail.title"/></title>
</head>
<body>
	<h2><spring:message code="detail.title"/></h2><hr>
	<spring:message code="form.id"/>: ${member.id }<br>
	<spring:message code="form.email"/>: ${member.email }<br>
	<spring:message code="form.name"/>: ${member.name }<br>
	<spring:message code="form.regDate"/>: <tf:formatLocaldatetime value="${member.regDate }" pattern="yyyy-MM-dd"/>
</body>
</html>