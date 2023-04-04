<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<title>탈퇴</title>
</head>
<body>
<c:if test="${cnt==1}">
		       <script>       
					alert("다음에 또 만나요~");
				</script>
</c:if>
<c:if test="${cnt==0}">
		       <script>       
					alert("실패");
				</script>
</c:if>
				
<script>
location.href="${path}/logoMain"; 
</script>
</body>
</html>