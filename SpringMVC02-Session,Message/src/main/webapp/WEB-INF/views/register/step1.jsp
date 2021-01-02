<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="term"/></h2>
	<p>약관내용</p>
	<form action="step2" method="POST">
		<label>
			<input type="checkbox" value="true" name="agree"><spring:message code="term.agree"/>
		</label>
		<label>
			<input type="submit" value="<spring:message code="next.btn"/>">
		</label>
	</form>
</body>
</html>