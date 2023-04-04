<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/default.css">
<title>FIND PASSWORD</title>
<style>
	.error{font-size:5px;}
	#input1{width:350px; height:40px; background:#EFEFEF; font-size:15px; border:1px solid white; border-radius:5px;}
	#input1::placeholder{color:#969696}
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
  width:300px;
  }
</style>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#sub").click(function(){
		$("#findPwFrm").submit();
	})
})
</script>
</head>
<body>
<div style="padding-top:10px;">
<h2 style="text-align:center;">FIND PASSWORD</h2>
      <div style=" margin:auto; border:1px solid white; box-shadow:1px 1px 15px #CFCFCF; border-radius:15px; width:500px; height:170px;">
        <div>
          <div>
          	<form:form id="findPwFrm" action="findPw" modelAttribute="user" method="post">
	            <div style="text-align:center; padding-top:10px; padding-bottom:10px;">
	              <form:input path="id" name="id" id="input1" placeholder="ID"/><br/>
					<c:if test="${errors.id}"><span class="error"></span></c:if>
	            </div>
	            <div style="text-align:center; padding-bottom:10px;">
	              <form:input path="name" name="name" id="input1" placeholder="name"/><br/>
				 <c:if test="${errors.name}"><span class="error"></span></c:if>
	            </div>
	            <div style="text-align:center; padding-bottom:10px;">
	              <form:input path="email" name="email" id="input1" placeholder="email"/><br/>
				 <c:if test="${errors.email}"><span class="error"></span></c:if> 
	            </div>
				<c:if test="${errors.notMatch}"><span class="error">일치하는 회원이 없습니다.</span></c:if>
            </form:form>
          </div>
        </div>
        </div>
        	    <div style="text-align:center; padding-top:10px;">
	            	<button id="sub">Find</button>
	            </div>
</div>
</body>
</html>