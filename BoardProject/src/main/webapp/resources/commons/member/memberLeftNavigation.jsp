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
				<a href="<c:url value="/member/changePw"/>">비밀번호 변경</a>
				<p></p>
				<a href="<c:url value="/member/signout"/>">회원탈퇴</a>
				<p></p>
</body>
</html>