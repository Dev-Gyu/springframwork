<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.detail"/></title>
</head>
<body>
	<h2><spring:message code="member.detail"/></h2><hr>
	<h3>${member.name } 님의 회원 정보입니다.</h3>
	<spring:message code="email"/>: ${member.email }<br>
	<spring:message code="cellphone"/>: ${member.cellphone }<br>
	<spring:message code="sex"/>: ${member.sex }<br>
	<a href="<c:url value="/member/changePw"/>">비밀번호 변경</a><hr>
	<a href="<c:url value="/index"/>">메인화면으로 돌아가기</a><br>
	<a href="<c:url value="/member/signout"/>">회원탈퇴</a>
</body>
</html>