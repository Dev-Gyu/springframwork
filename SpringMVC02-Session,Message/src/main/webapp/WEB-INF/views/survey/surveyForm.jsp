<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
</head>
<body>
	<h2>설문조사</h2>
	<form method="POST">
	<c:forEach var="q" items="${questions }" varStatus="status">
	<p>
		${status.index +1 }번 문항. ${q.title }<br>
		<!-- 객관식으로 답변작성시킬경우 -->
		<c:if test="${q.choice }">
			<c:forEach var="options" items="${q.options }">
			<label><input type="radio" name="responses[${status.index }]" value="${options }">${options }</label>
			</c:forEach>
		</c:if>
		<!-- 주관식으로 답변작성시킬경우 -->
		<c:if test="${!q.choice }">
			<input type="text" name="responses[${status.index }]">
		</c:if>
	</p>
	</c:forEach>
	<p><label>응답자 위치=<input type="text" name="respondent.locationString"></label></p>
	<p><label>응답자 나이=<input type="text" name="respondent.age"></label></p>
	<input type="submit" value="제출">
	</form>
</body>
</html>