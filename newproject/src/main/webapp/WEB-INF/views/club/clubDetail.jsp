<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<c:set var="gMember" value="${!empty loginUser && loginUser.grade==1 && (loginUser.id != clubDTO.masterId)}"/>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css" type="text/css">
<meta charset="UTF-8">
<script type="text/javascript">
$(document).ready(function(){	
	//클럽가입
	$("#btnSign").on("click",function(){
				location.href="${path}/club/sign?categoryNo=${clubDTO.categoryNo}&cNo=${clubDTO.cNo}&no=${loginUser.no}";	 
	});

	//클럽회원탈퇴
	$("#btnDelMember").on("click",function(){
		var c=confirm("클럽을 탈퇴하시겠습니까?");
			if(c){
				location.href="${path}/club/clubMemberDel?cMemberNo=${currentMember.cMemberNo}";
				}else{
				return false;
			}
	});
	//클럽삭제버튼
	$("#btnADel").on("click",function(){
		var c=confirm("클럽을 삭제하시겠습니까?");
			if(c){
				location.href="${path}/club/clubADel?cNo=${clubDTO.cNo}";
				}else{
				return false;
			}
	});	
}); 
	function openPop(){
		window.open('${path}/chat/room?roomNo=${clubDTO.cNo}', 'clubChat', 'width=700px,height=800px,scrollbars=yes');
	};
</script>
<title>클럽 상세보기</title>
<style>
	#clubMain{
		width: 66.6666%;
	}
	#tableCenter{
		display: flex;
	    justify-content: center;		
	}
	.c{
	text-align:center;
	}
	.r{
	text-align:right;
	}
	.w{
	 borderBottom:1px;
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
	 width:100%; 
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
				<b>${clubDTO.cName}</b>  
			</p>
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
		<div class="eight columns noleftmargin" id="clubMain">
			<h4>${clubDTO.cName} <span class="comments"><fmt:formatDate value="${clubDTO.creDate}" type="date" pattern="yyyy.MM.dd"/></span></h4>
			<div class="dots blogdots">
			</div>
			<div id="tablecenter">
				<table class="t">
				<tbody style="margin:30px;">
				<tr>
					<th colspan="3" class="w">클럽명</th>
					<td colspan="3" class="c">${clubDTO.cName}</td> <!-- 클럽명 -->
					<th colspan="3" class="w">가입인원</th>
					<td colspan="3" class="c">${sPeople}/${clubDTO.cPeople}(명)</td><!--가입자수/ 정원(명) -->
				</tr>
				<tr>
					<th colspan="3" class="w">클럽장</th>
					<td colspan="3" class="c">${clubDTO.masterId}</td><!-- 클럽장 -->		
					<th colspan="3" class="w">개설일</th>
					<td colspan="3" class="c"><fmt:formatDate value="${clubDTO.creDate}" type="date" pattern="yyyy.MM.dd"/></td><!-- 클럽개설일 -->
				</tr>
				<tr>
					<th colspan="6" class="w">활동지역(구)</th>
					<td colspan="6" class="c">${clubDTO.cLoc}</td><!-- 지역 -->
				</tr>
				<tr>
					<th colspan="12" class="w" style="width:50%;"><클럽소개글></th>
				</tr>
				<tr>
					<td colspan="12" class="c"><u:pre value="${clubDTO.cIntro}"/></td><!-- 클럽소개글 -->
				</tr>
				<c:if test="${empty boardVO}">
				<tr>
					<th colspan="12" class="w"><모임활동></th>
				</tr>
				<tr>
					<td colspan="12" class="c">개설된 모임활동이 없습니다</td>
				</tr>	
				</c:if>
				<c:if test="${!empty boardVO}">	
				<c:forEach var="board" items="${boardVO}">
				<tr>
					<th colspan="12" class="w"><모임활동></th>
				</tr>
				<tr>
					<th colspan="3" class="w">모임명</th>
					<td colspan="3" class="c">${board.bTitle}</td><!-- 타이틀 -->
					<th colspan="3" class="w">주최자</th>
					<td colspan="3" class="c">${board.bWriter}</td><!-- 작성자 -->
				</tr>
				<tr>
					<th colspan="12" class="w">모집내용</th>
				</tr>
				<tr>
					<td colspan="12" class="c"><u:pre value="${board.bContent}"/></td><!-- 모집내용 -->
				</tr>
				</c:forEach>
				</c:if>
				<%--관리자모드 --%>
				<c:if test="${(!empty loginUser) && (loginUser.grade == 999)}"> 
				<tr>
					<th colspan="12" class="w"><가입자 리스트></th>
				</tr>
				<tr>
					<th colspan="4" class="w">회원번호</th>
					<th colspan="4" class="w">회원아이디</th>
					<th colspan="4" class="w">가입일</th>
				</tr>
				<c:forEach var="sMember" items="${signMemberList}">
				<tr>
					<td colspan="4" class="c">${sMember.no}</td><%-- 회원번호 --%>
					<td colspan="4" class="c">${sMember.id}</td><%-- 회원아이디 --%>
					<td colspan="4" class="c"><fmt:formatDate value="${sMember.joinDate}" type="date" pattern="yyyy.MM.dd"/></td><%-- 클럽가입자날짜 --%>
				</tr>
				</c:forEach>
				</c:if>
				</tbody>
				</table>
				<%-- 클럽장,관리자만 수정 가능 --%>
				<c:if test="${(!empty loginUser) && (loginUser.grade == 999) || (loginUser.id == clubDTO.masterId)}">
						<div class="r">
						<form id="updateFrm" action="${path}/club/clubUp" method="get">
						<input type="hidden" name="cNo" id="cNo" value="${clubDTO.cNo}"/>
						<input type="hidden" name="cName" id="cName" value="${clubDTO.cName}"/>
						<input type="hidden" name="cIntro" id="cIntro" value="${clubDTO.cIntro}"/>
						<input type="hidden" name="categoryNo" id="categoryNo" value="${clubDTO.categoryNo}"/>
						<input type="hidden" name="cLoc" id="cLoc" value="${clubDTO.cLoc}"/>
						<input type="hidden" name="cPeople" id="cPeople" value="${clubDTO.cPeople}"/>
						<input type="submit" class="readmore" value="클럽수정"/>
						</form>
						</div>
						<div class="r">
							<input type="button" name="btnADel" id="btnADel" class="readmore" value="클럽삭제"/>
						</div>
		 		</c:if>
		 		<!-- 클럽에 가입하지않은 회원 -->
				<c:if test="${gMember && (currentMember.signIn != 'Y')}">
						<div class="r">
							<input type="button" name="btnSign" id="btnSign" class="readmore" value="클럽가입"/>
						</div>
				</c:if>
				<%-- 클럽에 가입한 일반회원만 보이게 처리 필요 --%>
				<c:if test="${gMember && (currentMember.signIn == 'Y') && (loginUser.no == currentMember.no)}">
						<div class="r">
							<input type="button" name="btnDelMember" id="btnDelMember" class="readmore" value="클럽탈퇴(회원)"/>
						</div>
				</c:if>
			</div>
		</div>
		<!-- SIDEBAR -->
		<div class="four columns" style="margin-top: 15px;">
			<a href="${path}/club/detail?categoryNo=${categoryNo}&cNo=${clubDTO.cNo}"><h6 class="sidebartitle">CLUB INTRODUCE</h6></a>
			<br class="clear"/>
			<a href="${path}/board/list?cNo=${clubDTO.cNo}&num=1"><h6 class="sidebartitle">CLUB BOARD</h6></a>
			<br class="clear"/>
			<a href="#" target="_blank" onclick="openPop()"><h6 class="sidebartitle">CLUB CHAT</h6></a>

		</div>

	</div>

</div>
</div>
<div class="hr">

</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>