<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원 가입 양식</h2>
<form action="step3" method="POST">
	<label>
	이름: <input type="text" name="name" id="name">
	</label><br>
	<label>
	이메일: <input type="text" name="email" id="email">
	</label><br>
	<label>
	비밀번호: <input type="password" name="password" id="password">
	</label><br>
	<label>
	비밀번호확인: <input type="password" name="confirmPassword" id="confirmPassword">
	</label><br>
	<input type="submit" value="제출">
	
</form>

</body>
</html>