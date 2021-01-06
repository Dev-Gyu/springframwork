<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="main.title"/></title>
</head>
<body>
	<h2><spring:message code="main.title"/></h2>
	<hr>
	<c:if test="${authInfo == null }">
	<a href="<c:url value="/login"/>">로그인</a> <a href="<c:url value="/register"/>">회원가입</a>
	</c:if>
	<c:if test="${authInfo != null }">
	<a href="<c:url value="/select/all"/>">모든 멤버 조회</a> <a href="<c:url value="/edit/changePassword"/>">비밀번호 변경</a>
	</c:if>
</body>
</html>