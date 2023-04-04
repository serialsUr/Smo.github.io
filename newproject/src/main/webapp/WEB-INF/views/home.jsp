<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
  integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx" crossorigin="anonymous"></script>
<script>
  Kakao.init('21e0d5f68f588827af92c418f9ecdfbc'); // 사용하려는 앱의 JavaScript 키 입력
</script>
<script>
  function loginWithKakao() {
	    Kakao.Auth.authorize({
	      redirectUri: 'http://localhost:8083/kakao-login',
	    });
	    
	    // 아래는 데모를 위한 UI 코드입니다.
	    displayToken()
	    function displayToken() {
	      var token = getCookie('authorize-access-token');

	      if(token) {
	        Kakao.Auth.setAccessToken(token);
	        Kakao.Auth.getStatusInfo()
	          .then(function(res) {
	            if (res.status === 'connected') {
	              document.getElementById('token-result').innerText
	                = 'login success, token: ' + Kakao.Auth.getAccessToken();
	            }
	          })
	          .catch(function(err) {
	            Kakao.Auth.setAccessToken(null);
	          });
	      }
	    }

	    function getCookie(name) {
	      var parts = document.cookie.split(name + '=');
	      if (parts.length === 2) { return parts[1].split(';')[0]; }
	    }
  }
</script>
</head>
<body>
<h1>
	<a href="<%=request.getContextPath()%>/signIn">로그인하러가기</a><br/>
</h1>
	<a id="kakao-login-btn" href="javascript:loginWithKakao()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
    alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
