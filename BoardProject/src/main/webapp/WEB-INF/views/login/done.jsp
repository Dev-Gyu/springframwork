<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
<style>
	#body{
		display: block;
		background-color: darkgray;
	}
	#boardTitle{
		text-align: center;
	}
	#body{
		text-align: center;
	}
	.welcome{
		font-size: 30px;
	}
	#body>a, #body>a:visited{
		color: black;
	}
	#body>a:hover{
		color: ivory;
	}
</style>
</head>
<body>
	<div id="layoutDiv">
		<div id="top">
			<jsp:include page="/resources/commons/layoutTop.jsp"/>
			
		<div id="boardTitle">
			<spring:message code="login.done"/>
		</div>
		
		<div id="body">
			<span class="welcome">${authInfo.name }님 환영합니다.</span>
			<p></p>
			<a href="<c:url value="/index"/>">메인화면으로 돌아가기</a>
		</div>
		
		</div>
	</div>
</body>
</html>