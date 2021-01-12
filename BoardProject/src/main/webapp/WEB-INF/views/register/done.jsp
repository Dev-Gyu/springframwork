<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="register.done"/></title>
</head>
<body>
	<h2><spring:message code="register.done"/></h2>
	<h3>${registerCommand.name }님 환영합니다.</h3>
	<a href="<c:url value="/index"/>">메인화면으로 돌아가기</a>
</body>
</html>