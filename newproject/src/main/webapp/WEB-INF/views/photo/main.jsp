<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}" />
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<c:set var="imageList"  value="${goodsMap.imageList}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<meta charset="UTF-8">
<html lang="ko">
<head>
  
<body>
<header><jsp:include page="/resources/module/header.jsp"></jsp:include></header>
<main>
<!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="twelve columns">
			<p>
				 <b>사진게시판</b>
			</p>
		</div>
	</div>
</div>
<div class="hr">
</div>
<!-- CONTENT 
================================================== -->
<div class="row" style="display: flex; justify-content: right;">
	<input type="button" value="사진업로드" onClick="location.href='${conPath}/photo/addForm'" class='readmore' style="width:100px;"/>
</div>
<div id="portofolio" class="row">
	<!-- Project 1-->
	<c:set  var="goods_count" value="0" />
	<c:if test="${empty goodsMap.bestseller}">
		<div>
			<h3>등록된 사진이 없습니다.</h3>
		</div>
	</c:if>
	<c:forEach items="${goodsMap.bestseller}" var="item">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="six columns category trains">
			<h4>제목:${item.goods_title}</h4>
			<h6>작성자:${item.id}</h6>
			<div class="portofoliothumb">
				<div class="portofoliothumboverlay">
					<div class="inner">
						<a class="projectdetail" href="${conPath}/photo/goodsDetail?goods_id=${item.goods_id}">+ Project Details</a>
					</div>
				</div>
				<!-- image here -->
				<img src="${conPath}/thumbnails?goods_id=${item.goods_id}&fileName=${item.fileName}" alt="image error">
			</div>
		</div>
	</c:forEach>
</div>
<div class="hr">
</div>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"></jsp:include></footer>
</body>
</html>




