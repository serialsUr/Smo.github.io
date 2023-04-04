<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//목록으로
	$("#btnList").on("click",function(){
		location.href="${path}/board/list?cNo=${boardVO.cNo}&num=1";
	});
	//수정하기
	$("#btnUpdate").on("click",function(){
		location.href="${path}/board/boardUpdate";
	});
	
});

</script>
<title>클럽게시판 글수정</title>
<style>
	.twelve.columns.noleftmargin {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  height: 100%;
	}
	#boardWrite {
		width:643.33px;
	}
	#select {
		width:100px;
	}
	
	#btnComm {
		text-align:center;
	}

</style>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"/></header>
<main>
<!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="eight columns">
			<p class="bread leftalign">
				<b>게시글 수정</b>
			</p>
		</div>
		<div class="four columns">
			<div class="row collapse">
				<div class="ten mobile-three columns">
					<!-- <input type="text" class="nomargin" placeholder="Search..."> -->
				</div>
				<div class="two mobile-one columns">
					<!-- <a href="#" class="postfix button expand">Go</a> -->
				</div>
			</div>
		</div>
	</div>
</div>
<div class="hr">
</div>
<!-- CONTENT 
================================================= -->
<div class="row">
	<div class="twelve columns noleftmargin">
		<!-- MAIN CONTENT -->
<%-- 	${boardVO} --%>
<form id=boardUpdate action="${path}/board/boardUpdate" method="POST">
	  <input type="hidden" name="cNo" id="cNo" value="${boardVO.cNo}"/>
	  <input type="hidden" name="boardNo" id="boardNo" value="${boardVO.boardNo}"/>
	<div class="eight columns noleftmargin" id="boardWrite">
<h5>TITLE</h5>
		<div class="panel">
	    	 <span class="comments">글 타입을 선택하세요</span>
			<div class="select" id="select">
			<select name="bType" id="bType" required="required" value="${boardVO.bType}">
				<option value="모임">모임</option>
				<option value="자유">자유</option>
	    	</select>
		</div>
		<input type="text" name="bTitle" id="bTitle" required="required" value="${boardVO.bTitle}">
	</div>
	<h5>CONTENTS</h5>
	<div class="panel">
	
		<pre><textarea rows="30" cols="50" name="bContent" id="bContent" required="required">${boardVO.bContent}</textarea></pre>
	
	</div>
	<br class="clear">
	<div class="btnComm" id="btnComm">
		<button type="submit" class="readmore" name="btnList" id="btnList">목록으로</button>
	  	<button type="submit" class="readmore" name="btnUpdate" id="btnUpdate">수정하기</button>
	</div>	 
	  </form>
	</div>
  </div>
</div>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>