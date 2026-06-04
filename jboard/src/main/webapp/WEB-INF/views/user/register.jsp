<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="../css/style.css"/>
    
    <script src="//t1.kakaocdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/jboard/js/daumPostcode.js"></script>
	<script>
		document.addEventListener('DOMContentLoaded', function(){
			
			const form = document.getElementsByTagName('form')[0];
			
			// 아이디 중복확인
			const btnUserid = document.getElementById('btnUserid');
			const useridResult = document.getElementsByClassName('useridResult')[0];
			
			btnUserid.addEventListener('click', async function(e){
				e.preventDefault();
				
				const userid = form.userid.value;
				
				if(userid.trim() === '') {
	                alert('아이디를 입력하세요.');
	                form.userid.focus();
	                return;
	            }
				
				// 아이디 중요여부 요청하기
				const response = await fetch('/jboard/user/check.do?userid=' + userid);
				const data = await response.json();
				
				console.log(data);
				if(data.count > 0) {
					useridResult.style.color = 'red';
					useridResult.innerText = '이미 사용중인 아이디입니다.';
                } else {
                	useridResult.style.color = 'green';
                	useridResult.innerText = '사용 가능한 아이디입니다.';
                }
				
			});
			
		})
	</script>

</head>
<body>
    <div id="wrapper">
    	<%@ include file="./_head.jsp" %>
        <main id="user">
            <section class="register">

                <form action="/jboard/user/register.do" method="post">
                    <h2 class="tit">사이트 이용정보 입력</h2>
                    <table border="1">                        
                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="userid" placeholder="아이디 입력"/>
                                <button type="button" id="btnUserid"><img src="../images/chk_id.gif" alt="중복확인"/></button>
                                <span class="useridResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="pass1" placeholder="비밀번호 입력"/></td>
                        </tr>
                        <tr>
                            <td>비밀번호 확인</td>
                            <td><input type="password" name="pass2" placeholder="비밀번호 입력 확인"/></td>
                        </tr>
                    </table>

                    <h2 class="tit">개인정보 입력</h2>
                    <table border="1">                        
                        <tr>
                            <td>이름</td>
                            <td>
                                <input type="text" name="name" placeholder="이름 입력"/>                        
                            </td>
                        </tr>
                        <tr>
                            <td>별명</td>
                            <td>
                                <p class="nickInfo">공백없는 한글, 영문, 숫자 입력</p>
                                <input type="text" name="nick" placeholder="별명 입력"/>
                                <button type="button"><img src="../images/chk_id.gif" alt="중복확인"/></button>
                                <span class="nickResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>
                                <input type="email" name="email" placeholder="이메일 입력"/>
                                <button type="button"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
                                <div class="auth">
                                    <input type="text" name="auth" placeholder="인증번호 입력"/>
                                    <button type="button"><img src="../images/chk_confirm.gif" alt="확인"/></button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td><input type="text" name="hp" placeholder="휴대폰 입력"/></td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td>
                                <input type="text" id="zip" name="zip" readonly placeholder="우편번호"/>
                                <button type="button" onclick="DaumPostcode()"><img src="../images/chk_post.gif" alt="우편번호찾기"/></button>
                                <input type="text" id="addr1" name="addr1" readonly placeholder="주소 검색"/>
                                <input type="text" id="addr2" name="addr2" placeholder="상세주소 입력"/>
                            </td>
                        </tr>
                    </table>

                    <div>
                        <a href="/jboard/user/login.do" class="btn btnCancel">취소</a>
                        <input type="submit" value="회원가입" class="btn btnRegister"/>
                    </div>

                </form>

            </section>
        </main>
    	<%@ include file="./_tail.jsp" %>
    </div>    
</body>
</html>