<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test1</h1>
	<!-- Controller에서 @ModelAttribute에 의해 자동 주입된 객체는
		객체의 타입에서 첫글자 소문자 변경해서 주입된다. -->
	<h3>${requestScope.dataBean.data1 }</h3>
	<h3>${requestScope.dataBean.data2 }</h3>
</body>
</html>