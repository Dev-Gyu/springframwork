<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="register.title"/></title>
<%-- CSS 파일 절대로 WEB-INF폴더 하위에 두지 말것. 불러올수 없음.--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
<style>
	#boardTitle{
		text-align:center;
		vertical-align:middle;
	}
	#body{
		display:block;
	}
	.registerTitle{
	color:ivory;
	font-size: 40px;
	}
	.registerform{
		text-align: center;
		margin: auto;
		background-color: white;
	}
</style>
</head>
<body>
<div id="layoutDiv">
	<div id="top">
	<jsp:include page="/resources/commons/layoutTop.jsp"/>
	</div>
	
	<div id="boardTitle">
		<span class="registerTitle"><spring:message code="register.title"/></span>
	</div>
	
	<div id="body">
		<form:form modelAttribute="registerCommand">
		<table class="registerform">
		<tr>
		<td><spring:message code="email"/>:</td><td><form:input path="email"/><form:errors path="email"/></td>
		</tr>
		<tr>
		<td><spring:message code="password"/>:</td><td><form:input path="password"/></td>
		</tr>
		<tr>
		<td><spring:message code="password.repeat"/>:</td><td><input id="passwordrepeat" type="text"/></td>
		</tr>
		<tr>
		<td><spring:message code="name"/>:</td><td><form:input path="name"/></td>
		</tr>
		<tr>
		<td><spring:message code="cellphone"/>:</td><td><form:input path="cellphone" place-holder="01x-xxxx-xxxx"/></td>
		<tr>
		<tr>
		<td><spring:message code="sex"/>:</td><td><form:radiobutton path="sex" value="남자"/>남자 <form:radiobutton path="sex" value="여자"/>여자</td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="회원가입"/></td>
		</tr>
		</table>
		</form:form>
	</div>
	
</div>
</body>
</html>