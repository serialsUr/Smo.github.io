<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/default.css">
<title>MY INFORMATION</title>
 <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#update").click(function(){
		location.href="<%=request.getContextPath()%>/modifyMyInfo";
	});
});
</script>
<style>
	.radius{
		border:2px solid grey;
		border-radius:50%;
	}
</style>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"/></header>
<main>
	<div id="subheader">
		<div class="row">
			<div class="eight columns">
				<p class="bread leftalign">
					<b>내 정보</b>
				</p> 
			</div>
			<div class="four columns">
				<div class="row collapse">
					<div class="ten mobile-three columns">
						<div class="two mobile-one columns">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<div class="hr">
</div>
<div style="text-align:center; padding-top:1%;">
	
<div>
	<img src="${path}/resources/img/gravatar.png" width="170px;" height="170px;" class="radius">
		<table style="margin-left:auto; margin-right:auto; margin-top:20px; width:295px">
			<tr>
				<td colspan="2" style="text-align:center"><h5>${loginUser.name}님</h5></td>
			</tr>
			<tr>
				<th>등급</th>
				<c:choose>
		    	<c:when test="${loginUser.grade==999}">
		      	 	<td colspan="2">관리자</td>
		    	</c:when>
		    	<c:otherwise>
		      	  	<td colspan="2">회원</td>
		   		 </c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th>이메일</th> <td>${loginUser.email}</td>
			</tr>
			<tr>
				<th>전화번호</th> <td>${loginUser.phonenum}</td>
			</tr>
			<tr>
				<th>주소</th> <td>${loginUser.address}</td>
			</tr>
			<tr>
				<th>성별</th> 
				<c:choose>
			    	<c:when test="${loginUser.gender=='M'}">
			      	 	<td>남성</td>
			    	</c:when>
			    	<c:otherwise>
			      	  	<td>여성</td>
			   		</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th>가입일</th> <td>${loginUser.regdate}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center"><button id="update" class="readmore">내 정보 수정</button></td>
			</tr>
		</table>
</div>	

</div>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>