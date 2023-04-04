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
	
});

</script>
<title>클럽게시판 댓글수정</title>
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
				<b>클럽게시판 댓글수정</b>
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
<%-- 댓글수정 ${boardNo} ${comm} --%>
<form action="${path}/comm/updateComm" method="POST">
	<input type="hidden" name="boardNo" id="boardNo" value="${boardNo}"/>
	<input type="hidden" name="commNo" id="commNo" value="${comm.commNo}"/>
	<div class="eight columns noleftmargin" id="boardWrite">
		<h5>CONTENTS</h5>
		<div class="panel">
		<pre><textarea rows="7" cols="20" name="comment" id="comment" required="required">${comm.comment}</textarea></pre>
		
	  	</div>
	  	<br class="clear">
		<div class="btnComm" id="btnComm">
	  		<button type="submit" class="readmore">등록</button>
	  </div>
	</form>
    </div>
  </div>
</div>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>