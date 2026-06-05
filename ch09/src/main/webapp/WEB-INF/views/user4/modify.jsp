<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>3
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::등록</title>
	</head>
	<body>
		<h3>user4 등록</h3>
		
		<a href="/ch09">메인</a>
		<a href="/ch09/user4/list.do">목록</a>
		
		<form action="/ch09/user4/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="${requestScope.user4DTO.userid}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user4DTO.name}"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" value="${user4DTO.gender}"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user4DTO.age}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="hp" value="${user4DTO.hp}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user4DTO.addr}"></td>
				</tr>
				<tr>					
					<td colspan="2" align="right">
						<input type="submit" value="등록하기">
					</td>
				</tr>			
			</table>		
		</form>		
	</body>
</html>