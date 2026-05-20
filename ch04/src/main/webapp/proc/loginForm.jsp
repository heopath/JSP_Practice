<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="./loginProc.jsp" method="post">
		<input type="text" name="userid" placeholder="아이디입력"><br>
		<input type="passward" name="pass" placeholder="비밀번호입력"><br>
		<input type="submit" value="전송">	
</body>
</html>