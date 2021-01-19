<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
<%-- CSS 파일 절대로 WEB-INF폴더 하위에 두지 말것. 불러올수 없음.--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
<style>
	#boardTitle{
		text-align:center;
		color: ivory;
		background-color: darkgray;
	}
	table{
		text-align:center;
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
		<div id="boardTitle"><spring:message code="login.title"/></div>
			<div class="form">
			<form:form modelAttribute="loginCommand">
			<table>
			<tr>
			<td colspan="2"><form:errors/></td>
			</tr>
			<tr>
			<td><spring:message code="email"/>:</td><td><form:input path="email" size="30"/>&nbsp;</td>
			</tr>
			<tr>
			<td><spring:message code="password"/>:</td><td><form:input path="password" size="30"/>&nbsp;</td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="<spring:message code="login.title"/>"/>&nbsp;</td>
			</tr>
			</table>
			</form:form>
		</div>
	</div>
</body>
</html>