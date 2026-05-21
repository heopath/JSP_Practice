<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sub1.User1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 목록 출력 리스트
	List<User1> user1list = new ArrayList<>();
	
	//--------------------------------
	// 데이터베이스 작업
	//--------------------------------
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "heocoding";
	String pass = "1234";
	
	try {
		// 0) 드라이버 로드	(jsp에서는 생략불가)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 1) 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		// 2) SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
		
		// 3) SQL 실행
		String sql = "SELECT * FROM `User4`";
		ResultSet rs = stmt.executeQuery(sql);
		
		// 4) 결과셋(ResultSet) 처리
		while(rs.next()){
			
			User1 user1 = new User1();
			user1.setUserid(rs.getString(1));
			user1.setName(rs.getString(2));
			user1.setGender(rs.getString(3));
			user1.setAge(rs.getInt(4));
			user1.setHp(rs.getString(5));
			user1.setAddr(rs.getString(6));
			
			user1list.add(user1);
			
		}
		
		// 5) 데이터베이스 종료
	
		
	}catch (Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::목록</title>
	</head>
	<body>
		<h3>User4 목록</h3>
		<a href="/ch05/1_jdbc.jsp">메인</a>
		<a href="/ch05/user1/register4.jsp">등록</a>
	
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>번호</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<%
				for(User1 user1 : user1list){
			%>
			<tr>
				<td><%= user1.getUserid() %></td>
				<td><%= user1.getName() %></td>
				<td><%= user1.getGender() %></td>
				<td><%= user1.getAge() %></td>
				<td><%= user1.getHp() %></td>
				<td><%= user1.getAddr() %></td>
				<td>
					<a href="/ch05/user1/modify4.jsp?userid=<%= user1.getUserid()%>">수정</a>
					<a href="/ch05/user1/proc/delete4.jsp?userid=<%= user1.getUserid()%>">삭제</a>
				</td>
			</tr>
			<%
			}
			%>
		</table>	
	</body>
</html>