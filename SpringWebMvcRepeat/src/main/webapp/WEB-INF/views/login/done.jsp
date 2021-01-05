<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<h2>${login.name } 님 환영합니다.</h2>
	<a href="<c:url value="/main"/>">메인화면으로 돌아가기</a>
</body>
</html>