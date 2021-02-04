<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- get,post 넘겨준 파라미터값들도 ViewResolver에의해 해당 페이지의 파라미로 리턴해주기때문에
		포워딩한 페이지에서 그대로 가져다 사용할 수 있다. -->
	<a href="test1?data1=100&data2=200">test1</a><br/>
	<a href="test2">test2</a><hr>
	
	<a href="test3">test3</a><br/>
	<a href="test4">test4</a>
</body>
</html>