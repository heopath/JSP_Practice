<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="/jboard/css/style.css"/>
    
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            
            // Controller에서 리다이렉트할 때 보낸 success 파라미터 값을 가져옴
            const success = "${param.success}";
            
            // success 값이 "100"이면 로그인 실패 팝업 노출
            if(success === "100") {
                alert("아이디 또는 비밀번호가 일치하지 않습니다.");
            }
            
        });
    </script>
</head>
<body>
    <div id="wrapper">
    	<%@ include file="./_head.jsp" %>
        <main id="user">
            <section class="login">
                <form action="/jboard/user/login.do"method="post">                    
                    <table border="0">
                        <tr>
                            <td><img src="/jboard/images/login_ico_id.png" alt="아이디"/></td>
                            <td><input type="text" name="userid" placeholder="아이디 입력"/></td>
                        </tr>
                        <tr>
                            <td><img src="/jboard/images/login_ico_pw.png" alt="비밀번호"/></td>
                            <td><input type="password" name="pass" placeholder="비밀번호 입력"/></td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인" class="btnLogin"/>
                    
                </form>
                <div>
                    <h3>회원 로그인 안내</h3>
                    <p>
                        아직 회원이 아니시면 회원으로 가입하세요.
                    </p>
                    <div style="text-align: right;">
                        <a href="../find/userId.do">아이디 |</a>
                        <a href="../find/password.do">비밀번호찾기 |</a>
                        <a href="/jboard/user/terms.do">회원가입</a>
                    </div>                    
                </div>
            </section>
        </main>
    	<%@ include file="./_tail.jsp" %>
    </div>    
</body>
</html>