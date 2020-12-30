<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 양식</title>
</head>
<body>
	<h2>설문조사</h2>
	<form method="POST">
	<p>1.당신의 역할은?<br>
	<label><input type="radio" name="responses[0]" value="서버">서버개발자</label>
	<label><input type="radio" name="responses[0]" value="프론트">프론트개발자</label>
	<label><input type="radio" name="responses[0]" value="풀스택">풀스택개발자</label>
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