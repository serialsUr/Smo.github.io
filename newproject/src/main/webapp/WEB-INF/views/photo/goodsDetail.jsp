<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 	isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath"  value="${pageContext.request.contextPath}"  />
<c:set var="contextPath1" value="${pageContext.request.contextPath}"/>
<c:set var="goodsVO"  value="${goodsMap.goodsVO}" />
<c:set var="imageList"  value="${goodsMap.imageList}" />
<c:set var="path" value="<%=request.getContextPath()%>"/> 
    
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/default.css">

</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"></jsp:include></header>
<main>
<%--컨트롤러로부터 아래와 같이 Model받았다
 Map goodsMap : 상품상세+상품이미지목록 
Map-GoodsVO : 상품상세
   -List : 상품이미지목록
goodsMap.put("goodsVO", goodsVO);
List<ImageFileVO> imageList = goodsRepository.selectGoodsDetailImage(goods_id);
goodsMap.put("imageList",imageList); --%>
	<!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="twelve columns">
			<p class="left">
				 <b>사진게시판</b>
			</p>
		</div>
	</div>
</div>
<div class="hr">
</div>
<!-- CONTENT 
================================================== -->
<div class="row">
	<!-- PROJECT DESCRIPTION-->
	<br>
	<div class="six columns" >
		<div class="sectiontitle">
	
		<h4>제목:${goodsVO.goods_title}</h4>
		</div>
		<div><h6>작성자:${goodsVO.id}</h6></div>
		<h6>등록일:<fmt:formatDate value="${goodsVO.credate}" pattern="yyyy-MM-dd"/></h6><br/>
		
		<style>
    .box {
        width: 450px;
        height: 250px;
    }
</style>

<div class="box" style="border:1px solid;">
    <p>${goodsVO.goods_content}</p>
</div>
			
	
		
		
	</div>
	
	<!-- end main content-->
	
	<!-- SLIDER-->
	
	<div class="six columns">
		<div class="slider-wrapper theme-default">
			<div id="slider" class="nivoSlider detailslider">
				<img src="${conPath}/thumbnails?goods_id=${goodsVO.goods_id}&fileName=${goodsVO.fileName}">
			</div>
			
		</div>
	</div>
	<!-- end sliderr-->
	
</div>

<div class="hr">
</div>
	
</main>
<footer><jsp:include page="/resources/module/footer.jsp"></jsp:include></footer>
</body>
</html>
<%-- 로그인여부 담기 --%>












