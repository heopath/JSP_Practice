<%@page import="org.apache.coyote.http11.upgrade.UpgradeServletInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>result1 결과</h3>
	
	<%
		//전송 데이터 수신
		String params = request.getQueryString();
		String userid = request.getParameter("userid");
	%>
	
	<p>
		파라미터 : <%= params %><br>
		아이디 : <%= userid %><br>
	
	</p>
	
	<a href="../1_request.jsp">1_request</a>
</body>
</html>