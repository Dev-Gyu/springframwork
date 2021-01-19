<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%-- 반드시 공통 스타일시트 링크로 걸어서 사용할것. 페이지별로 별개 레이아웃 적용할때 편함 --%>
<meta charset="UTF-8">
<title>Gyu's Board</title>
</head>
<body>
			<%-- 이 파일로 탑부분 공통으로 사용할때 반드시 #layoutDiv, #top Div태그 안에 이거 넣어서 사용해야됨. 탑부분 모듈임 --%>
			<div class="mainTitle"><a href ="<c:url value="/"/>">게시판 메인타이틀</a></div>
			<%-- 로그인 관련 영역, 로그인 후의 링크들 효과는 로그인 전의 링크들 효과랑 똑같이줌--%>
			<div class="loginInfo">
					<c:if test="${sessionScope.authInfo == null }">
					<span class="register"><a href="<c:url value="/register"/>">회원가입</a></span>
					<span class="login"><a href="<c:url value="/login"/>">로그인</a></span>
					</c:if>
					<c:if test="${sessionScope.authInfo != null }">
					<span class="register"><a href="<c:url value="/member/detail"/>">마이페이지</a></span>
					<span class="register"><a href="<c:url value="/logout"/>">로그아웃</a></span>
					</c:if>
			</div>
			<hr>
			<div id="boardNames" class="boardNames">
					<div class="boardName"><a href="#">게시판1</a></div>
					<div class="boardName"><a href="#">게시판2</a></div>
					<div class="boardName"><a href="#">게시판3</a></div>
					<div class="boardName"><a href="#">게시판4</a></div>
			</div>
</body>
</html>