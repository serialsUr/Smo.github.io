<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<meta charset="UTF-8">
<style>
.a{
text-align:center;
}
</style>
<title>클럽가입</title>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"/></header>	
<main>
<span></span><span></span><span></span>

<script>
</script>
<h3 class="a">클럽에 가입 하시겠습니까?</h3>
<form id="signClub" method="post" action="${path}/club/sign">
<p><input type="hidden" name="categoryNo" id="categoryNo" readonly="readonly" value="${categoryNo}"/>
<p><input type="hidden" name="cNo" id="cNo" readonly="readonly" value="${clubMemberDTO.cNo}"/></p> <!-- 클럽번호 -->
<p><input type="hidden" name="no" id="no" readonly="readonly" value="${loginUser.no}"/></p> <!-- 회원번호 -->
<p><input type="hidden" name="signIn" id="signIn" readonly="readonly" value="${clubMemberDTO.signIn}"/></p> <!-- 회원번호 -->
<p class="a"><input type="submit" class="readmore" value="클럽가입"/></p>
</form>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
</body>
</html>