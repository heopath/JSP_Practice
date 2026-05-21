<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	// 전송 데이터 수신
	String userid = request.getParameter("userid");

	// ----------------------------
	// 데이터베이스 작업 수정 데이터 조회
	// ----------------------------
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "heocoding";
	String pass = "1234";
	
	try{
		
	// 1) 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
	// 2) 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, pass);
	
	// 3) SQL 실행 객체 생성
	String sql = "SELECT * FROM `User1` WHERE `userid` = ?";

	// 4) SQL 실행

	// 5) 결과셋 처리

	// 6) 데이터베이스 종료
	}catch(Exception e){
		e.printStackTrace();
	}
		
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::수정</title>
	</head>
	<body>
		<h3>User1 수정</h3>
		<a href="/ch05/1_jdbc.jsp">메인</a>
		<a href="/ch05/user1/list.jsp">목록</a>
		
		<form action="/ch05/user1/proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="수정하기">
					</td>
				</tr>			
			</table>		
		</form>		
	</body>
</html>