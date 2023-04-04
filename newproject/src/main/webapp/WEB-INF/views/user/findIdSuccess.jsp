<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FIND ID SUCCESS</title>
<style>
	#sub{
  border: 0;
  outline: none;
  font-size: 25px;
  margin: 30px;
  margin-top:20px;
  margin-bottom:5px;
  background: #257E52;
  color: white;
  padding: 10px;
  cursor: pointer;
  border-radius: 10px;
  width:100px;
  }
</style>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#sub").click(function(){
		window.close();
	})
})
</script>
</head>
<body>
<div style="text-align:center; padding-top:45px;">
	<div><h2>요청하신 회원님의 아이디는 [${findId.id}]입니다.</h2></div>
	<div>
		<button id="sub">확인</button>
	</div>
</div>
</body>
</html>