<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 
각 부분의 명칭(label)을 spring:message tag를 이용하여 출력하는 방법.
페이지에 중복되는 명칭을 하나의 properties파일로 관리하여 뷰페이지의 하드코딩으로인한
유지보수 어려움을 덜어줌.
input type="text"에 주석걸어둔 이유는 spring에서 제공하는 form tag로 input및 정규식검사시 에러발생하도록 하기위함
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="member.info"/></h2>
<form:form action="step3" modelAttribute="registerRequest">
	<label>
	<spring:message code="name"/> <!-- <input type="text" name="name" id="name"> -->
	<form:input path="name"/>
	<form:errors path="name"/>
	</label><br>
	<label>
	<spring:message code="email"/> <!-- <input type="text" name="email" id="email"> -->
	<form:input path="email"/>
	<form:errors path="email"/>
	</label><br>
	<label>
	<spring:message code="password"/> <!-- <input type="password" name="password" id="password"> -->
	<form:input path="password"/>
	<form:errors path="password"/>
	</label><br>
	<label>
	<spring:message code="password.confirm"/> <!-- <input type="password" name="confirmPassword" id="confirmPassword"> -->
	<form:input path="confirmPassword"/>
	<form:errors path="confirmPassword"/>
	</label><br>
	<input type="submit" value="<spring:message code="register.btn"/>">
	
</form:form>

</body>
</html>