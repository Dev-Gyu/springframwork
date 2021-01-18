<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- CSS 파일 절대로 WEB-INF폴더 하위에 두지 말것. 불러올수 없음.--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
<title>Gyu's Board</title>
</head>
<body>
	<div id="layoutDiv">
		<%-- 레이아웃의 가장 윗부분을 모두 포함한 div --%>
		<div id="top">
			<div class="mainTitle"><a href ="<c:url value="/"/>">게시판 메인타이틀</a></div>
			<%-- 로그인 관련 영역 --%>
			<div class="loginInfo">
			<h3>
				<c:if test="${sessionScope.authInfo == null }">
				<span class="register"><a href="<c:url value="/register"/>">회원가입</a></span>
				<span class="login"><a href="<c:url value="/login"/>">로그인</a></span>
				</c:if>
				<c:if test="${sessionScope.authInfo != null }">
				<span class="register"><a href="<c:url value="/member/detail"/>">마이페이지</a></span>
				<span class="register"><a href="<c:url value="/logout"/>">로그아웃</a></span>
				</c:if>
			</h3></div>
			<hr>
			<div id="boardNames" class="boardNames">
				<div class="boardName"><a href="#">게시판1</a></div>
				<div class="boardName"><a href="#">게시판2</a></div>
				<div class="boardName"><a href="#">게시판3</a></div>
				<div class="boardName"><a href="#">게시판4</a></div>
			</div>
		</div>
		<div id="boardTitle">
			<div class="boardTitleLink"><a href="#">보조제목부분(SubTitle)</a></div>
		</div>
		<div id="body">
			<div class="subBoard">
				<div class="subBoardLink"><a href="#">좌측 보조게시판</a></div>
			</div>
			<div class="mainBody">
				메인 내용
			</div>
		</div>
	</div>



	<div id="layoutDiv">
		<div id="top">
			<div class="mainTitle"><h2>Hanshin Impact</h2></div>
			<div class="loginInfo">
			<h3>
				<c:if test="${sessionScope.authInfo == null }">
				<a href="<c:url value="/register"/>">회원가입</a>
				<a href="<c:url value="/login"/>">로그인</a>
				</c:if>
				<c:if test="${sessionScope.authInfo != null }">
				<a href="<c:url value="/member/detail"/>">마이페이지</a>
				<a href="<c:url value="/logout"/>">로그아웃</a>
				</c:if>
			</h3>
			</div>
			<hr>
			<div id="boardNames" class="boardNames">
				<div id="boardName1"><span>게시판1</span></div>
				<div id="boardName2">게시판2</div>
				<div id="boardName3">게시판3</div>
				<div id="boardName4">게시판4</div>
			</div>
		</div>
		<div id="boardTitle">
			보조 제목 부분 (SubTitle)
		</div>
		<div id="body">
			<div class="subBoard">
				좌측 보조게시판
			</div>
			<div class="mainBody">
				메인 내용
			</div>
		</div>
	</div>
</body>
</html>