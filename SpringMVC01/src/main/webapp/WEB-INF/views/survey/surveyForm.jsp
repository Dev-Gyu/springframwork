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
	<p>
	1.${questions[0].title }<br>
	<c:forEach var="options" items="${questions[0].options }" varStatus="status">
	<label><input type="radio" name="responses[0]" value="${options}">${options }개발자</label>
	</c:forEach>
	</p>
	<p>2.가장 많이 사용하는 개발도구는?<br>
	<label><input type="radio" name="responses[1]" value="Eclipse">이클립스</label>
	<label><input type="radio" name="responses[1]" value="InteliJ">인텔리J</label>
	<label><input type="radio" name="responses[1]" value="Sublime">서브라임</label>
	</p>
	<p>3.하고싶은 말<br>
	<label><input type="radio" name="responses[2]" value="코딩잘하고싶다">코딩잘하고싶다!!!!</label>
	<label><input type="radio" name="responses[2]" value="코잘알이되고싶다">코잘알이되고싶다!!!</label>
	<label><input type="radio" name="responses[2]" value="스프링도잘하고싶다">스프링도잘하고싶다!!!</label>
	</p>
	<p><label>응답자 위치=<input type="text" name="respondent.locationString"></label></p>
	<p><label>응답자 나이=<input type="text" name="respondent.age"></label></p>
	<input type="submit" value="제출">
	</form>
</body>
</html>