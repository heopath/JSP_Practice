<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>3
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user2::등록</title>
	</head>
	<body>
		<h3>User2 등록</h3>
		
		<a href="/ch09">메인</a>
		<a href="/ch09/user2/list.do">목록</a>
		
		<form action="/ch09/user2/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="${requestScope.user2DTO.userid}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user2DTO.name}"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birth" value="${user2DTO.birth}"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${user2DTO.addr}"></td>
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