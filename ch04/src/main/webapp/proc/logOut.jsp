<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logOut/title>
</head>
<body>
	<h3>로그아웃</h3>
	<%
		// 로그아웃 처리 -> 클라이언트 세션값 삭제, 클라이언트 세션 종료
		session.removeAttribute("sessUser");
		session.invalidate();
		
		// 로그인 폼 이동
		response.sendRedirect("./loginForm.jsp?logOut=success");
	%>

</body>
</html>