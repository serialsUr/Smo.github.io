<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<script>
	$(function(){
		let allcount = ${allNotice}
		
		$('#noticeWrite').click(function(){
			location.href='${path}/notice/insert';
		});
		
		//보여줄 게시글 셀렉트 누를시
		$('#paging').change(function(){
			let count = $(this).val();
			
		})
		
		//ajax로 페이징처리 구현시도
		/* $.ajax({
			url: '${path}/notice/paging',
			type: 'get',
			data: {},
			success:function(data) {
				alert(data);
				//$('#pagingspan').html(data);
			}, error:function(){
				alert('ajax 실행 오류발생');
			}
		});  */
		//ajax 끝
		
	});

</script>
<title>공지사항</title>
<style>
#tableCenter{
	display: flex;
 	justify-content: center;
	
}
table{
	width:60%;
}

#btn {

}
</style>
</head>
<body>
<main>
<header><jsp:include page="/resources/module/header.jsp"/></header>
	<%-- 총 게시글수: ${result} --%>
	<%-- 현재 세션 아이디:${sessionId} --%>
	<%-- 게시글정보: ${noticeList} --%>
	<%-- grade:${loginUser.grade}
	전체게시글수allNotice:${allNotice} --%>
	<div id="subheader">
		<div class="row">
			<div class="eight columns">
				<p class="bread leftalign">
					<b>공지 사항</b>
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
	<input type="hidden" name="pageNo" value="${paging.cri.pageNo}">
	<input type="hidden" name="amount" value="${paging.cri.amount}">
	<!-- 관리자만 글쓰기 작성 활성화 -->
		<c:if test="${loginUser.grade == 999}">
				<div style="width:60%; margin-left:auto; margin-right:auto; text-align:right;">
					<input type="button" value="글쓰기" id="noticeWrite" class="readmore"/>
				</div>
		</c:if>
	<div id="tableCenter">
	<%-- <div id="btn">
		<c:if test="${loginUser.grade == 999}">
			<input type="button" value="글쓰기" id="noticeWrite" class="readmore"/>
		</c:if>
	</div> --%>
		<table border="1">
			<tr>
				<th>제목</th><th>작성자</th><th>작성시간</th><th>조회수</th>
			</tr>
			<c:if test="${empty noticeList}">
			<tr>
				<td colspan="5">작성된 공지사항이 없습니다</td>
			</c:if>
			<c:if test="${not empty noticeList}">
				<c:forEach items="${noticeList}" var="list">
				<tr> 
					<td><a href="${path}/notice/read?no=${list.no}">${list.title}</a></td>
					<td>${list.writername}</td>
					<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
					<td>${list.readcnt}</td>
				</tr>	
				</c:forEach>
		<%-- 	<tr>
				<td colspan="5" style="text-align: center;" id="pagingspan">
					<div class="board-list-paging">
						<ul class="pagination">
						<!-- 게시판 페이징 영역 -->
						<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
							<li class="current"><a href="${path}/notice?pageNo=${num}">${num}</a></li>
						</c:forEach>
						</ul>
					</div>
				</td>
			</tr> --%>
			</c:if>
		</table>
	</div>
	<div class="board-list-paging">
		<ul class="pagination">
				<!-- 게시판 페이징 영역 -->
				<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
					<li class="current"><a href="${path}/notice?pageNo=${num}">${num}</a></li>
				</c:forEach>
		</ul>
	</div>
</main>	
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>