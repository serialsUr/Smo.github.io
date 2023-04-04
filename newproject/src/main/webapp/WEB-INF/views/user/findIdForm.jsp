<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/default.css">
<title>FIND ID</title>
<style>
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
		$("#findIdFrm").submit();
	})
})
</script>
</head>
<body>
<div style="padding-top:10px;">
<h2 style="text-align:center;">FIND ID</h2>
      <div style=" margin:auto; border:1px solid white; box-shadow:1px 1px 15px #CFCFCF; border-radius:15px; width:500px; height:170px;">
        <div>
          <div>
          	<form:form id="findIdFrm" action="findId" modelAttribute="user" method="post">
	            <div style="text-align:center; padding-top:10px; padding-bottom:10px;">
	              <form:input path="name" id="input1" placeholder="Name" />
					<span class="fieldError"><form:errors path="name"/></span>
	            </div>
	            <div style="text-align:center; padding-bottom:10px;">
	              <form:input path="email" id="input1" placeholder="Email" />
				<span class="fieldError"><form:errors path="email" /></span>
	            </div>
	            <div style="text-align:center; padding-bottom:10px;">
	              <form:input path="phonenum" id="input1" placeholder="Phone number" />
				<span class="fieldError"><form:errors path="phonenum" /></span>
	            </div>

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