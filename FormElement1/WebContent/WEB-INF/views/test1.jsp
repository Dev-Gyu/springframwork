<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<form:form modelAttribute="dataBean" action="result">
		text: <form:input path="a1"/>
		text-area: <form:textarea path="a2"/>
		<form:button>확인버튼</form:button>
	</form:form>
</body>
</html>