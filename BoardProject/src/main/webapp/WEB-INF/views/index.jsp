<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gyu's Board</title>
<%-- CSS 파일 절대로 WEB-INF폴더 하위에 두지 말것. 불러올수 없음.--%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/commonCSS.css"/>
</head>
<body>
	<div id="layoutDiv">
		<%-- 레이아웃의 가장 윗부분을 모두 포함한 div --%>
		<div id="top">
			<jsp:include page="/resources/commons/layoutTop.jsp"/>
		</div>
		<%-- 레이아웃 탑부분 끝, 게시판 보조제목부분(SubTitle) 시작 --%>
		<div id="boardTitle">
			<span class="boardTitleLink"><a href="#">보조제목부분(SubTitle)</a></span>
		</div>
		<%-- 게시판 보조제목부분 끝, 바디부분 시작 --%>
		<div id="body">
			<div class="subBoard">
				<a href="#">좌측 보조게시판</a>
			</div>
			<div class="mainBody">
				메인 내용
			</div>
		</div> <%-- #top 닫힘태그 --%>
	</div> <%-- #layoutDiv 닫힘태그 --%>
</body>
</html>