<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- ck editor 5 -->
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<title>공지사항 작성</title>
<script>
	$(function(){
		$('#submit').click(function(){
			/* 제목 검증 */
			let title = $('#title').val();
			if(title=='') {
				alert('제목이 입력되지 않았습니다');
				$('#title').focus();
				return false;
			}
			
			let content = $('#content').val();
			if(content=='') {
				alert('내용이 입력되지않았습니다');
				$('#content').focus();
				return false;
			}
			
			$('#form').submit();
			
		});
		
		$('#backBtn').click(function(){
			history.back();
		});
	});
</script>
<style>
#tableCenter{
	display: flex;
 	justify-content: center;
}
table{
	width:60%;
}

#btn {
  /* position: absolute;
  top: 24.5%;
  left: 77.8%;
  transform: translateX(-50%); */
  /* text-align: right;
  margin-right: 285px; */
}
</style>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"></jsp:include></header>
<div id="subheader">
		<div class="row">
			<div class="eight columns">
				<p class="bread leftalign">
					<b>공지 사항 작성</b>
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
<main>
	<div class="hr">
	</div>
	<form action="${path}/notice/insert" method="post" id="form">
			<div style="width:60%; margin-left:auto; margin-right:auto; text-align:right;">
					<input type="submit" id="submit" value="작성하기" class="readmore"/>&nbsp;
					<input type="reset" value="취소" class="readmore"/>&nbsp;
					<input type="button" value="뒤로가기" id="backBtn" class="readmore"/>
			</div>
		<div id="tableCenter">
		<table border="1">
			<tr>
				<th>작성자</th><td><input type="hidden" name="writername" id="writername" value="${loginUser.name}"/>${loginUser.name}</td>
			</tr>
			<tr>
				<th>제목</th><td><input type="text" name="title" id="title" placeholder="제목을 입력해주세요"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="30" name="content" id="content" placeholder="내용을 입력해주세요"></textarea>
					<!-- <div id="content" name="content"></div> -->
				</td>
			</tr>
		</table>
		</div>
	</form>
</main>	
<footer><jsp:include page="/resources/module/footer.jsp"></jsp:include></footer>
</body>
</html>