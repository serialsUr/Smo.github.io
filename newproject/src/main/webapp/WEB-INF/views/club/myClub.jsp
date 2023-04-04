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
<title>클럽 리스트</title>
<style>
</style>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"/></header>
<main>	
	<!-- 검색 -->
		<div id="subheader">
	<div class="row">
		<div class="eight columns">
			<p class="bread leftalign">
				<b>내 클럽</b>
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
<div class="row">
	<c:if test="${empty clubList}">
		<h3>가입된 클럽이 없습니다.</h3>
	</c:if>
    <!-- MAIN CONTENT -->
	<div class="eight columns noleftmargin">
    <c:if test="${!empty clubList}">
   	 <c:forEach var="clist" items="${clubList}">
		<div class="six columns">
			<div class="boxblog">
				<h5>클럽명 <a href="${path}/club/detail?categoryNo=${clist.categoryNo}&cNo=${clist.cNo}">${clist.cName}</a></h5>
				<p class="small date">
					클럽개설일 <fmt:formatDate value="${clist.creDate}" type="date" pattern="yyyy.MM.dd"/>
				</p>
				<p>
					클럽장 ${clist.masterId}
				</p>
				<p>
					활동지역 ${clist.cLoc}
				</p>
				<p>
					정원 ${clist.cPeople}
				</p>
			</div>
		</div>
		</c:forEach>
		</c:if>
	</div>
</div>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>