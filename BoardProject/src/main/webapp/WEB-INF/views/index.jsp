<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.mainTitle{
		text-align:center;
	}
	.loginInfo{
		text-align:right;
	}
</style>
<title>Gyu's Board</title>
</head>
<body>
	<div class="mainTitle"><h2>Dev Gyu's Boards</h2></div>
	<div class="loginInfo"><h3></h3></div>
	<hr>
	<h3>게시판 메인화면 입니다.</h3>
	<c:if test="${sessionScope.authInfo == null }">
	<a href="<c:url value="/register"/>">회원가입</a>
	<a href="<c:url value="/login"/>">로그인</a>
	</c:if>
	<c:if test="${sessionScope.authInfo != null }">
	<a href="<c:url value="/mypage"/>">마이페이지</a>
	<a href="<c:url value="/signout"/>">회원탈퇴</a>
	</c:if>
</body>
</html>