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
		location.href="${path}/board/list?cNo=${cNo}&num=${num}";
	});
	
	//글쓰기
	$("#boardUpload").on("click",function(){
		location.href="${path}/board/list?cNo=${cNo}&num=1";
	});
	
});

</script>
<title>클럽게시판 글쓰기</title>
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
				<b>클럽게시판 글쓰기</b>
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
================================================== -->
<div class="row">
	<div class="twelve columns noleftmargin">
	     <!-- MAIN CONTENT -->
	     <form action="${path}/board/boardWrited?cNo=${cNo}&num=${num}" method="post">
	<input type="hidden" name="bWriter" id="bWriter" value="${loginUser.id}"/>
	<input type="hidden" name="cNo" id="cNo" value="${cNo}"/>
	<input type="hidden" name="num" id="num" value="${num}"/>
		<div class="eight columns noleftmargin" id="boardWrite">
		<h5>TITLE</h5>
		<div class="panel">
	    	 <span class="comments">글 타입을 선택하세요</span>
			<div class="select" id="select">
			<select name="bType" id="bType" required="required">
			<option value="모임">모임</option>
			<option value="자유" selected>자유</option>
	    	</select>
			</div>
	    	<input type="text" name="bTitle" id="bTitle" required="required" placeholder="제목을 입력하세요"/>
		</div>
		<h5>CONTENTS</h5>
		<div class="panel">
			
			<pre><textarea rows="30" cols="50" name="bContent" id="bContent" required="required" placeholder="내용을 입력하세요"></textarea></pre>
		

		<!-- 본인글이면 수정 또는 삭제가능 -->
		<!-- <button type="button" onclick="location.href='${path}/board/?cNo=${boardVO.cNo}'">목록으로</button> -->
		</div>
	  <div class="btnComm" id="btnComm">
		<button type="submit" class="readmore" name="btnList" id="btnList" >목록으로</button>
	  	<button type="submit" class="readmore"name="boardUpload" id="boardUpload">작성하기</button>
	  </div>
		<br class="clear">
	     </form>
	</div>


</div>
 
 
</main>

<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>