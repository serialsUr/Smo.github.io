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
	$("#boardList").on("click",function(){
		location.href="${path}/board/list?cNo=${boardVO.cNo}&num=1";
	});
	$("#boardList1").on("click",function(){
		location.href="${path}/board/list?cNo=${boardVO.cNo}&num=1";
	});
	
	//글 수정
	$("#updateBoard").on("click",function(){
		location.href="${path}/board/boardUpdate?cNo=${boardVO.cNo}&boardNo=${boardVO.boardNo}&num=${num}";
	});
	
	//글 삭제
	$("#deleteBoard").on("click",function(){
		alert("삭제하시겠습니까?")
		location.href="${path}/board/deleteBoard?cNo=${boardVO.cNo}&boardNo=${boardVO.boardNo}&num=${num}";
	});

	//댓글 삭제
	$("#deleteComm").on("click",function(){
		alert("삭제하시겠습니까?")
	});
	
	

	
});
function openPop(){
	window.open('${path}/chat/room?roomNo=${clubDTO.cNo}', 'clubChat', 'width=700px,height=800px,scrollbars=yes');
};
</script>
<title>클럽게시판 글읽기</title>
<style>
	#boardDetail {
		width:66.6666%
	}
	
	#textarea {
		resize:none;
		width:598.46px;
		height:100px;
	}
	
	#btnComm {
		text-align:center;
	}


</style>
</head>
<body>

<header><jsp:include page="/resources/module/header.jsp"/></header>
<main>
	<%-- 게시글정보: ${boardList} ${boardVO} ${num} 세션 아이디:${loginUser.id}--%>
<!-- 출력해야하는 게시글 내용 :
${boardVO.boardNo} ${boardVO.bType} ${boardVO.bWriter} ${boardVO.bRegdate} ${boardVO.bModdate}
${boardVO.bTitle} ${boardVO.bContent}
-->
<!-- 출력해야하는 댓글 내용 : 
forEach var="comm" items="${commList}"
${comm.commNo} ${comm.commId} ${comm.commRegdate} ${comm.commModdate} ${comm.comment}
-->

<!-- 
	<form id="insertCommBoard" action="${path}/comm" method="POST">
 -->

	<input type="hidden" name="commId" id="commId" value="${loginUser.id}"/>
	<input type="hidden" name="cNo" id="cNo" value="${boardVO.cNo}"/>
  	<input type="hidden" name="num" id="num" value="${num}"/>
  	<input type="hidden" name="boardNo" id="boardNo" value="${boardVO.boardNo}"/>

 
 <!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="eight columns">
			<p class="bread leftalign">
				<b>${clubDTO.cName} 게시판</b>
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
		<div class="eight columns noleftmargin" id="boardDetail">
			
			<div class="sectiontitle">
			<a href="#" class="tags">${boardVO.bType}</a><h4>${boardVO.bTitle}</h4>
			</div>
						
		<div class="panel">
				<div class="avatar">
					<img src="http://www.wowthemes.net/demo/studiofrancesca/images/gravatar.png" alt="">
				</div>
				<h5 class="left">${boardVO.bWriter}</h5>
			<div class="right">			
		<div class="social facebook">
			<a href="#"></a>
		</div>
		<div class="social twitter">
			<a href="#"></a>
		</div>
		<div class="social deviantart">
			<a href="#"></a>
		</div>
		<div class="social flickr">
			<a href="#"></a>
		</div>
		<div class="social dribbble">
			<a href="#"></a>
		</div>
		<br/>
		<span class="comments">
			<c:if test="${boardVO.bRegdate == boardVO.bModdate}">작성 <fmt:formatDate pattern="yyyy-MM-dd" value="${boardVO.bRegdate}"/></c:if>
		 	<c:if test="${boardVO.bRegdate != boardVO.bModdate}">작성 <fmt:formatDate pattern="yyyy-MM-dd" value="${boardVO.bRegdate}"/>
		        (수정 <fmt:formatDate pattern="yyyy-MM-dd" value="${boardVO.bModdate}"/>)</c:if>
		</span>
		</div>
		<p class="clear authortext">
			<b><pre>${boardVO.bContent}</pre></b>
			<br class="clear">
		<p class="clear authortext">
		<!-- 본인글이면 수정 또는 삭제가능 -->
		<!-- <button type="button" onclick="location.href='${path}/board/?cNo=${boardVO.cNo}'">목록으로</button> -->
	  <span class="comments">
			<c:if test="${loginUser.id == boardVO.bWriter}">
	  		  <button type="submit" class="readmore" name="updateBoard" id="updateBoard">수정</button>
			  <button type="submit" class="readmore" name="deleteBoard" id="deleteBoard">삭제</button>
			</c:if>
	  </span>
		<br class="clear">
		</div>
		
		<h5>Comment</h5>
		<c:if test="${empty commList}">
		<p>작성된 댓글이 없습니다</p>
		</c:if>
		<c:forEach var="comm" items="${commList}">
		<br class="clear">
			<hr>
		<div class="gravatar">
			<img src="http://www.wowthemes.net/demo/studiofrancesca/images/gravatar.png" alt="" width=40px;>
		</div>
		<h5>${comm.commId}</h5><div class="comments right">
		<c:if test="${comm.commRegdate == comm.commModdate}">작성 <fmt:formatDate pattern="yyyy-MM-dd" value="${comm.commRegdate}"/></c:if>
	 	<c:if test="${comm.commRegdate != comm.commModdate}">작성 <fmt:formatDate pattern="yyyy-MM-dd" value="${comm.commRegdate}"/>
	        (수정 <fmt:formatDate pattern="yyyy-MM-dd" value="${comm.commModdate}"/>)</c:if>
		
		</div>
		<pre><br/>${comm.comment}</pre>
		<!-- 본인 댓글이면 수정 또는 삭제가능 -->
		<span class="comments">
		<c:if test="${loginUser.id == comm.commId}">
		<button type="submit" class="readmore" onClick="location='${path}/comm/updateComm?boardNo=${boardVO.boardNo}&commNo=${comm.commNo}'">수정</button>
		<button type="submit" class="readmore" onClick="location='${path}/comm/deleteComm?cNo=${boardVO.cNo}&boardNo=${boardVO.boardNo}&commNo=${comm.commNo}'">삭제</button>
		</c:if>
		</span>
		
		</c:forEach>	
		<br class="clear">
  		<h6 class="sidebartitle"></h6>
		<h5>Enter your comment</h5>
		<!-- 댓글작성  -->
		<form id="insertCommBoard" action="${path}/comm" method="POST">
		<input type="hidden" name="commId" id="commId" value="${loginUser.id}"/>
		<input type="hidden" name="cNo" id="cNo" value="${boardVO.cNo}"/>
	 	<input type="hidden" name="num" id="num" value="${num}"/>
	 	<input type="hidden" name="boardNo" id="boardNo" value="${boardVO.boardNo}"/>
		<textarea class="six smoothborder" id="textarea" rows="7" placeholder="Comments *" name="comment" id="comment" required="required"></textarea>
  		<br class="clear">
  		<!-- <input type="button" name="boardList1" id="boardList1" value="목록으로"/> -->
  		<div class="btnComm" id="btnComm">
		<button type="submit" class="readmore" name="boardList1" id="boardList1">목록으로</button>
		<button type="submit" class="readmore">등록</button>
  		</div>
		</form>	
		</div>
	
		<!-- SIDEBAR -->
		<div class="four columns" id=float style="margin-top: 15px;">
			<a href="<%=request.getContextPath()%>/club/detail?categoryNo=${clubDTO.categoryNo}&cNo=${boardVO.cNo}"><h6 class="sidebartitle">CLUB INTRODUCE</h6></a>
			<br class="clear"/>
			<a href="<%=request.getContextPath() %>/board/list?cNo=${boardVO.cNo}&num=1"><h6 class="sidebartitle">CLUB BOARD</h6></a>
			<br class="clear"/>
			<a href="#" target="_blank" onclick="openPop()"><h6 class="sidebartitle">CLUB CHAT</h6></a>
		</div>
		
	</div>
</div>
<div class="hr">
</div>
		</div>
 
 
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>