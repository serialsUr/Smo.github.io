<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<style type="text/css">
 .texta{
	  font-size:1.1em;
	  border: none;
	  resize: none;
	  }
 .w{
	 width:80px;
	 height:40px;
	 font-weight:bold;
	 font-size:1.1em;
	 }
 .t{
	 margin:auto; 
	 margin-top:30px; 
	 margin-bottom:30px; 
	 display: flex; 
	 justify-content:center; 
	 width:43%; 
	 }
</style>
<meta charset="UTF-8">
<script>
$(document).ready(function(){
	//클럽개설
		$("#createDone").on("click",function(){
			let categoryNo = $('#categoryNo').val();
			if(categoryNo == '' || categoryNo == 0) {
				alert('카테고리를 선택해주세요.');
				$('#categoryNo').focus();
				return false;
			}
			let cName = $('#cName').val();
			if(cName == '' || cName == null) {
				alert('클럽명을 작성해주세요');
				$('#cName').focus();
				return false;
			}
			
			let cPeople = $('#cPeople').val();
			if(cPeople == '' || cPeople == 0) {
				alert('정원을 선택해주세요');
				$('#cPeople').focus();
				return false;
			}

			let cLoc = $('#cLoc').val();
			if(cLoc == '' || cLoc == null) {
				alert('지역을 입력해주세요');
				$('#cLoc').focus();
				return false;
			}
			
			let cIntro = $('#cIntro').val();
			if(cIntro == '' || cIntro == null) {
				alert('소개글을 작성해주세요');
				$('#cIntro').focus();
				return false;
			}

		
		 var c=confirm("클럽 개설 성공!!");
		  if(c){
			  $('#creaFrm').attr("action","${path}/club/clubCre").submit();
		  }else{
			 return false;		 
			} 
	  	});	
});
</script>
<title>클럽 개설</title>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"/></header>
<!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="eight columns">
			<p class="bread leftalign">
				<b>클럽 개설</b>  
			</p>
		</div>
	</div>
</div>
<div class="hr">
</div>
<!-- CONTENT 
================================================== -->
<form id="creaFrm" action="${path}/club/clubCre" method="post">
<table border="1" class="t">
	<tr>
		<th class="w">카테고리</th>
		<td>		
		<select name="categoryNo" id="categoryNo">
			<option value=0>선택</option>
			<option value=1>공부</option>
			<option value=2>요리</option>
			<option value=3>운동</option>
		</select>		
		</td>
	</tr>
	<tr>
		<th class="w">클럽명</th>
		<td><input type="text" name="cName" id="cName" autofocus="autofocus" placeholder="클럽명을 입력해주세요."/></td>
	</tr>
	<tr>
		<th class="w">클럽장</th>
		<td><input type="text" name="masterId" id="masterId" readonly="readonly" value="${loginUser.id}"/></td>
	</tr>
	<tr>
		<th class="w">정원(명)</th>
		<td>
		<select name="cPeople" id="cPeople">
			<option value=0>선택</option>
			<option value=10>10명</option>
			<option value=30>30명</option>
			<option value=50>50명</option>
			<option value=100>100명</option>
		</select>		
		</td>
	</tr>
	<tr>
		<th class="w">활동지역(구)</th>
		<td>
			<input type="text" name="cLoc" id="cLoc" placeholder="예시)서울시 강남구"/>
		</td>
	</tr>
	<tr>
		<th style="font-size:1.1em;"><b>클럽<br/>소개글</b></th>
		<td>
			<textarea class="texta" rows="20" cols="70" name="cIntro" id="cIntro" placeholder="클럽을 소개해주세요!"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<div style="text-align: right;">
		<button class="readmore" type="button" name="createDone" id="createDone">클럽개설</button>
		</div>
		</td>
	</tr>
</table>
</form>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>