<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL Format -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- ContextPath -->
<c:set var="path" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${path}/resources/css/default.css">
<style>
.btn {

}
</style>
<script>
	/* Jquery 선언부 */
		$(function(){
			//목록 돌아가기 버튼
			$('#moveNoticeList').click(function(){
				location.href='${path}/notice';
			});
			
			//수정버튼
			$('#updateNotice').click(function(){
				location.href='${path}/notice/updateForm?no=${noticeDTO.no}';
			});
			
			//삭제버튼
			$('#deleteNotice').click(function(){
				if(confirm('정말 삭제하시겠습니까?')) {
					location.href='${path}/notice/delete?no=${noticeDTO.no}';
				} else {
					return;
				}
			});
		});
</script>
<title>Insert title here</title>
<style>
#tableCenter{
	display: flex;
 	justify-content: center;
	
}
table{
	width:60%;
}
.btn {
/*   position: absolute;
  top: 24.5%;
  left: 72.8%;
  transform: translateX(-50%); */
    text-align: right;
  margin-right: 285px;
}
</style>
</head>
<body>
<header><jsp:include page="${path}/resources/module/header.jsp"/></header>
<main>
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
		<div style="width:60%; margin-left:auto; margin-right:auto; text-align:right;">
		<c:if test="${loginUser.grade == 999}">

		
			<input type="button" name="" id="updateNotice" value="수정" class="readmore"/>
			<input type="button" name="" id="deleteNotice" value="삭제" class="readmore"/>

		</c:if>
			<input type="button" name="moveNoticeList" id="moveNoticeList" value="목록" class="readmore"/>
		</div>

	<div id="tableCenter">
		<table border="1">
			<tr>
				<th>작성자</th><td>${noticeDTO.writername}</td>
			</tr>
			<tr>
				<th>제목</th><td>${noticeDTO.title}</td>
			</tr>
			<tr>
				<th>내용</th><td>${noticeDTO.content}</td>
			</tr>
			<tr>
				<th>작성일자</th><td><fmt:formatDate value="${noticeDTO.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
			</tr>
			<tr>
				<th>마지막수정일자</th><td><fmt:formatDate value="${noticeDTO.modidate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
			</tr>
			<tr>
				<th>조회수</th><td>${noticeDTO.readcnt}</td>
			</tr>
		</table>
	</div>
</main>	
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>	
</body>
</html>