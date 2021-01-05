<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전체멤버조회페이지</h2>
	<hr>
	<c:forEach var="member" items="${members }" varStatus="status">
		${status.index +1 } 번째 멤버 <br>
		아이디: ${member.id }
		이름: ${member.name }
		이메일: ${member.email }
		<br>
	</c:forEach>
</body>
</html>