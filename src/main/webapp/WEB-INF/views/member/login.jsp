<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
       <style>
html,
body {
  height: 100%;
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 400;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff') format('woff');
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 700;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamBold.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamBold.woff') format('woff');
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
.lottemartdream * {
 font-family: 'LotteMartDream', sans-serif;
}
body {
  font-family: 'LotteMartDream';
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
    .id_ok{color: blue; display: none;}
    .id_already{color:red; display: none;}
    .password_ok{color: blue; display: none;}
    .password_diff{color:red; display: none;}
  
   </style>
<main class="form-signin">
  <form action="/member/login" method="post" id="login">
    <h1 class="h3 mb-3 fw-normal">Please Login!</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="id" name="userid">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control mt-2" id="password" name="password">
      <label for="floatingPassword">비밀번호</label>
      <font color="red" class="mb-1">${message}</font>
    </div>
    <input class="w-100 btn btn-lg btn-primary" type="button" id="loginbtn" value="로그인"/>
    <input class="w-100 btn btn-lg btn-dark mt-2" type="button" id="signupbtn"  value="회원가입"/>
    <input class="w-100 btn btn-lg btn-warning mt-2" type="button" id="token"  value="token 발급"/>
     <input class="w-100 btn btn-lg btn-warning mt-2" type="button" id="token_valid"  value="token 유효확인"/>
    <br><br>
    </form>
   	 <input class="w-100 btn btn-xs btn checkBtn" type="button"  id="id" name="pswdloss" value="ID 찾기"/>
     <input class="w-100 btn btn-xs btn checkBtn" type="button" id="pw" name="pswdloss" value="비밀번호 찾기"/>
 
</main>


<script type="text/javascript">
   $(function(){
        
	   var sur;
	   
	   $('#loginbtn').click(function(){
        	$('#login').submit();
        });
        
        $(".checkBtn").click(function() {
			console.log(this.id);
			var id = this.id;
			var userName;
			
			if("id"==id)userName = "Y";
			else		userName = "N";
			
			
			location.href="/member/loss?userName="+userName;
		});
		$("#signupbtn").click(function() {
			
			location.href="/member/signupbtn";
		});
		$("#token").click(function() {
			var email = $('#id').val();
			var password = $('#password').val();
			var data2 = {
					"email":email,
					"password":password
					}
			console.log(data2);
			 $.ajax({
			        url:'http://localhost:8081/auth/login',
			        type:'POST',
			        data: JSON.stringify(data2),
			        contentType : "application/json; charset=utf-8",
			        crossDomain: true,
			        
			        beforeSend:function(jqXHR) {
			            console.log("ajax호출전");
			        },// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
			        success: function(data) {
			            console.log("호출성공");
			            console.log(data);
			            const obj = {
			            	    value : data2.email,
			            	    expire :data.accessTokenExpiresIn
			            	  }
			            const objString = JSON.stringify(obj);
			            localStorage.setItem("time", objString);
			            sessionStorage.setItem("email",data2.email)
			            sessionStorage.setItem("jwt",data.accessToken)
			            console.log(data.accessToken);
			          /*   location.href="/"; */
			     
			        },// 요청 완료 시
			        error:function(jqXHR) {
			            console.log("실패입니다.");
			        }// 요청 실패.
			    });
		});
		$("#token_valid").click(function() {
		
			var obj = {
					  "email": "heiditty@gmail.com",
					  "password": "1q2w3e4r"
					};
// 			obj =$.toJSON(obj);
// 			console.log(obj);
// 			return;
			
			 $.ajax({
			        url:'http://localhost:8081/member/me',
			        type:'POST',
			        crossDomain: true,
			        data: JSON.stringify(obj),
			        dataType: 'json',			       
 			        contentType : "application/json; charset=utf-8",
			        beforeSend:function(jqXHR) {
 			        	jqXHR.setRequestHeader('Authorization', 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoZWlkaXR0eSIsImlkIjoxLCJleHAiOjE2NTEzODYyODYsInVzZXJuYW1lIjoiaGVpZGl0dHkifQ.dtO7ZPukjgdkVEkZXF3TSm6Q1eehDq_PtLQEn6UKNVuRceeMvFOXkCM35VbwuEPJhU5KJXft7LYSqr7FIQ7Z_g');
			        },// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
			        success: function(data) {
			            console.log("호출성공");
			            console.log(data);
			        },// 요청 완료 시
			        error:function(jqXHR) {
			            console.log("실패입니다.");
			        }// 요청 실패.
			    });
		});
    });
    
	        
	        
</script>