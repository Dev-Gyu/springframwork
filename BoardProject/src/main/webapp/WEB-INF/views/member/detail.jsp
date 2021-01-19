<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.detail"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
<style>
	.name{
		font-size: 30px;
		margin-bottom:10px;
	}
	.info{
		font-size: 20px;
	}
</style>
</head>
<body>
	<div id="layoutDiv">
		<div id="top"><jsp:include page="/resources/commons/layoutTop.jsp"/></div>
		
		<div id="boardTitle"><spring:message code="member.detail"/></div>
		
		<div id="body">
			<%-- 마이페이지 왼쪽 네비게이션 --%>
			<div class="subBoard"> 
				<jsp:include page="/resources/commons/member/memberLeftNavigation.jsp"/>
			</div>
			
			<div class="mainBody">
				<div class="name">${member.name } 님의 회원 정보입니다.</div>
				<div class="info">
				<spring:message code="email"/>: ${member.email }<br>
				<spring:message code="cellphone"/>: ${member.cellphone }<br>
				<spring:message code="sex"/>: ${member.sex }<br>
				<button type="button" onclick="location.href='<c:url value="/index"/>'">메인화면으로 돌아가기</button><br>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>