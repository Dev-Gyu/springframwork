<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="changePw.title"/></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
<style>
	#body{
		text-align: center;
	}
	.formdiv{
		background-color: white;
	}
	.explain{
		font-size: 22px;
	}
	table{
		margin: auto;
	}
</style>
</head>
<body>
	<div id="layoutDiv">
		<div id="top"><jsp:include page="/resources/commons/layoutTop.jsp"/></div>
		
		<div id="boardTitle"><spring:message code="changePw.title"/></div>
		
		<div id="body">
			<div class="subBoard"><jsp:include page="/resources/commons/member/memberLeftNavigation.jsp"/></div>
			<div class="mainBody">
			<div class="explain">현재 비밀번호와 변경할 비밀번호를 입력해주세요.</div>
			<div class="form">
				<form:form modelAttribute="changePwCommand">
				<table>
				<tr>
				<td colspan="2"><form:errors/></td>
				</tr>
				<tr>
				<td><spring:message code="oldPassword"/>:</td><td><form:input path="oldPassword"/></td>
				</tr>
				<tr>
				<td><spring:message code="newPassword"/>:</td><td><form:input path="newPassword"/></td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="변경"/></td>
				</tr>
				</table>
				</form:form>
			</div>
			</div>
		</div>
	</div>
</body>
</html>