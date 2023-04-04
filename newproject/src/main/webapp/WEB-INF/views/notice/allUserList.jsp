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
<style></style>
<script>
	/* Jquery 선언부 */
		$(function(){
			$('#delete').click(function(){
		
			});
		});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>유저 전체 목록 리스트</h1>
	<table border="1">
		<tr>
			<th> </th>
			<th>ID</th>
			<th>이름</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>이메일</th>
			<th>휴대폰번호</th>
			<th>성별</th>
			<th>등급</th>
			<th>회원가입일</th>
		</tr>
		<c:if test="${empty userList}">
			<tr>
				<td colspan="11">등록된 회원이 없습니다</td>
			</tr>
		</c:if>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td><input type="checkbox" value="${user.no}" id="usernoCheck" class="userno"></td>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.zipcode}</td>
			<td>${user.address}</td>
			<td>${user.detailaddress}</td>
			<td>${user.email}</td>
			<td>${user.phonenum}</td>
			<td>${user.gender}</td>
			<td>${user.grade}</td>
			<td>${user.regdate}</td>	
		</c:forEach>
		<tr>
			<td colspan="11"><input type="button" id="delete" name="delete" value="삭제"></td>
		</tr>	
	</table>
</body>
</html>