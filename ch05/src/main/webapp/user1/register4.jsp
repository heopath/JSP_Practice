<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user1::등록</title>
</head>
<body>
	<h3>User4 등록</h3>
	<a href="/ch05/1_jdbc.jsp">메인</a>
	<a href="/ch05/user1/list4.jsp">목록</a>

	<form action="/ch05/user1/proc/register4.jsp"  method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" placeholder="아이디 입력"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름 입력"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><label><input type="radio" name="gender" value="M">남</label>
					<label><input type="radio" name="gender" value="F">여</label>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" placeholder="나이 입력"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" placeholder="휴대폰 입력"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" placeholder="주소 입력"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="등록하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>