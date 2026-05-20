<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createCookie</title>
</head>
<body>
	<h3>쿠키 생성</h3>
	
	<%
		// 전송 데이터 수신
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String age = request.getParameter("age");
		
		// 쿠기 생성
		Cookie cookie1 = new Cookie("userid", userid);
		cookie1.setPath("/"); // 쿠기 사용 범위
		cookie1.setMaxAge(60 * 4); // 쿠키 수명 (3분)
		
		Cookie cookie2 = new Cookie("name", name);
		cookie2.setPath("/");
		cookie2.setMaxAge(60 * 3);
		
		Cookie cookie3 = new Cookie("birth", birth);
		cookie3.setPath("/"); 
		cookie3.setMaxAge(60 * 2); 
		
		Cookie cookie4 = new Cookie("age", age);
		cookie4.setPath("/"); 
		cookie4.setMaxAge(60 * 1); 
		
		// 쿠키 전송
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
	%>
	
		<a href="./confirmCookie.jsp">쿠키 확인</a>
		



</body>
</html>