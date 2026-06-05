<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>3
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3::등록</title>
	</head>
	<body>
		<h3>user3 등록</h3>
		
		<a href="/ch09">메인</a>
		<a href="/ch09/user3/list.do">목록</a>
		
		<form action="/ch09/user3/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="${requestScope.user3DTO.userid}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user3DTO.name}"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birth" value="${user3DTO.birth}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="hp" value="${user3DTO.hp}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user3DTO.addr}"></td>
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