<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<meta name="viewport" content="width=device-width"/>
<link rel="stylesheet" href="${path}/resources/css/style.css">
<link rel="stylesheet" href="${path}/resources/css/skins/green.css">
<link rel="stylesheet" href="${path}/resources/css/responsive.css">
<meta charset="UTF-8">
<script>
	$(function(){
		$("#btnWrite").click(function(){
			location.href='${path}/board/boardWrite?cNo=${cNo}&num=${num}';
		});
	});
	function openPop(){
		window.open('${path}/chat/room?roomNo=${clubDTO.cNo}', 'clubChat', 'width=700px,height=800px,scrollbars=yes');
	};
</script>
<title>클럽게시판</title>
<style>

	.twelve.columns.noleftmargin {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  height: 100%;
	}
	#noBoard {
		width:643.33px;
    	display:table-cell;
  		vertical-align:middle;
  		margin:70px;
	}


</style>
</head>
<body>
<main>
<div class="row">
	<div class="twelve columns noleftmargin">
	     <!-- MAIN CONTENT -->
		<div class="eight columns noleftmargin" id="noBoard">
		<div class="hr"></div>
		<div class="tableCenter">
			<div class="dots blogdots"></div>
			<br class="clear">
			<h5 align="center">클럽 가입된 회원만 이용 가능합니다.</h5>
			<p>
			<br class="clear">
			<div class="dots blogdots"></div>
			<br class="clear">
		</div>
	  	
	   </div>
  	</div>
 </div>
 </main>
</body>
</html>