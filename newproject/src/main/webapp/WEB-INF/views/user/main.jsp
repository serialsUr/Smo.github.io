<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=request.getContextPath()%>"/>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>damoye</title>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"></jsp:include></header>
<div id="ei-slider" class="ei-slider">
	<ul class="ei-slider-large">
		<li>
		<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDExMjJfNjQg%2FMDAxNjA2MDU0NjM2ODY3.RljtHkVr8zixMBER4MACMBeiQhNSt1EGARM8h95R4GEg.NDMQdw902x8JjS3xjcDdUYFLfa2zMe_ySbf6TEPyNmIg.JPEG.andrichrich%2FIMG%25A3%25DF20201104%25A3%25DF011157.jpg&type=sc960_832" alt="image02" class="responsiveslide">
		<div class="ei-title">
			<h2>같이 공부해요 :)</h2>
			<h3>공부</h3>
		</div>
		</li>
		<li>
		<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMDVfNCAg%2FMDAxNjc1NTcyMTMwNjU5.fJNcSr5QvRK4bAkYZT4yS1tqSj9wpGewghNxllMSuPAg.Da54wC-vq7xVBo0sHLrQvl6TIXOy6wtqCHBjrgDuoKYg.JPEG.ljaskylove00%2FKakaoTalk_20221113_120311429_03.jpg&type=sc960_832" alt="image01" class="responsiveslide">
		<div class="ei-title">
			<h2>같이 요리해요 :)</h2>
			<h3>요리</h3>
		</div>
		</li>
		<li>
		<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEyMjJfMjIg%2FMDAxNjcxNjM5Mzg4NzI1.TOl2dnd87pQxHTATjMQLVADLASVZvnxLZ96dMsLNPGAg.6vpQaD3XQTo4emolDcWwqV6e4dtGTj1fTPrkfphnbVIg.JPEG.kangjs1981%2FKakaoTalk_Photo_2022-12-22-01-13-16_009.jpeg&type=sc960_832" alt="image03" class="responsiveslide">
		<div class="ei-title">
			<h2>같이 운동해요 :)</h2>
			<h3>운동</h3>
		</div>
		</li>
		
	</ul>
	<!-- slider-thumbs -->
	<ul class="ei-slider-thumbs">
		<li class="ei-slider-element">Current</li>
		<li><a href="#">Slide 1</a><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDExMjJfNjQg%2FMDAxNjA2MDU0NjM2ODY3.RljtHkVr8zixMBER4MACMBeiQhNSt1EGARM8h95R4GEg.NDMQdw902x8JjS3xjcDdUYFLfa2zMe_ySbf6TEPyNmIg.JPEG.andrichrich%2FIMG%25A3%25DF20201104%25A3%25DF011157.jpg&type=sc960_832" class="slideshowthumb" alt="thumb02"/></li>
		<li><a href="#">Slide 2</a><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMDVfNCAg%2FMDAxNjc1NTcyMTMwNjU5.fJNcSr5QvRK4bAkYZT4yS1tqSj9wpGewghNxllMSuPAg.Da54wC-vq7xVBo0sHLrQvl6TIXOy6wtqCHBjrgDuoKYg.JPEG.ljaskylove00%2FKakaoTalk_20221113_120311429_03.jpg&type=sc960_832" class="slideshowthumb" alt="thumb01"/></li>
		<li><a href="#">Slide 3</a><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjEyMjJfMjIg%2FMDAxNjcxNjM5Mzg4NzI1.TOl2dnd87pQxHTATjMQLVADLASVZvnxLZ96dMsLNPGAg.6vpQaD3XQTo4emolDcWwqV6e4dtGTj1fTPrkfphnbVIg.JPEG.kangjs1981%2FKakaoTalk_Photo_2022-12-22-01-13-16_009.jpeg&type=sc960_832" class="slideshowthumb" alt="thumb03"/></li>
	</ul>
</div>
<div class="minipause">
</div>
<!-- SUBHEADER
================================================== -->
<div id="subheader">
	<div class="row">
		<div class="twelve columns">
			<p class="text-center">
				 <b>환영합니다. 다모여입니다 :)</b>
			</p>
		</div>
	</div>
</div>
<!-- ANIMATED COLUMNS 
================================================== -->
<div class="row">
	<div class="twelve columns" style="margin-top:40px;margin-bottom: -5px;">
		<ul class="ca-menu">
			<li>
			<a href="${path}/club/allClubList">
			<span class="ca-icon"><i class="fa fa-user"></i></span>
			<div class="ca-content">
				<h2 class="ca-main">전체 모임</h2>
				<h3 class="ca-sub">전체 모임 보러가기</h3>
			</div>
			</a>
			</li>
			<li>
			<a href="${path}/club/clist?categoryNo=1">
			<span class="ca-icon"><i class="fa fa-pencil"></i></span>
			<div class="ca-content">
				<h2 class="ca-main">공부 모임</h2>
				<h3 class="ca-sub">공부 모임 보러가기</h3>
			</div>
			</a>
			</li>
			<li>
			<a href="${path}/club/clist?categoryNo=2">
			<span class="ca-icon"><i class="fa fa-utensils"></i></span>
			<div class="ca-content">
				<h2 class="ca-main">요리 모임</h2>
				<h3 class="ca-sub">요리 모임 보러가기</h3>
			</div>
			</a>
			</li>
			<li>
			<a href="${path}/club/clist?categoryNo=3">
			<span class="ca-icon"><i class="fa fa-dumbbell"></i></span>
			<div class="ca-content">
				<h2 class="ca-main">운동 모임</h2>
				<h3 class="ca-sub">운동 모임 보러가기</h3>
			</div>
			</a>
			</li>
		</ul>
	</div>
</div>
<!-- CONTENT 
================================================== -->
<div class="row">
	<div class="twelve columns">
		<div class="centersectiontitle">
			<h4>공지사항</h4>
		</div>
	</div>
	<c:forEach items="${noticeList}" var="list">
		<div class="four columns">
			<h5>${list.title}</h5>
			<p>
				${list.writername}
			</p>
			<p>
				<a href="${path}/notice/read?no=${list.no}" class="readmore">더보기</a>
			</p>
		</div>
	</c:forEach>
</div>
<div class="hr">
</div>
<footer><jsp:include page="/resources/module/footer.jsp"></jsp:include></footer>
</body>
</html>