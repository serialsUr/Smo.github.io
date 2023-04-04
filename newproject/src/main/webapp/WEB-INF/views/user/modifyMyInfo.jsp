<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY MY INFORMATION</title>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#ment").hover(function(){
		$("#updateCheck").text("수정 시 로그아웃되므로 재로그인 부탁드립니다.");
	});
	$("#ment").mouseleave(function(){
		$("#updateCheck").text("");
	});
});
</script>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"/></header>
<main>
<div id="subheader">
		<div class="row">
			<div class="eight columns">
				<p class="bread leftalign">
					<b>회원정보 수정</b>
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
<div style="padding-left:40%;">
<form:form action="modifyMyInfo" method="post" modelAttribute="user">
<input type="hidden" name="id" value="${loginUser.id}"/>
<b style="padding-left:5%;">아이디, 이름, 성별, 등급, 가입일은 수정하실 수 없습니다.</b>
<table style="width:450px;">
	<tr>
		<th>아이디</th>
		<td>${loginUser.id}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td colspan="2">${loginUser.name}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td colspan="2"><form:password path="password" value="${loginUser.password}"/></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td colspan="2"><form:input path="email" value="${loginUser.email}"/></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td colspan="2"><form:input path="phonenum" value="${loginUser.phonenum}"/></td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td><form:input path="zipcode" value="${loginUser.zipcode}"/></td>
		<td><button type="button" onclick="execDaumPostcode()" class="readmore">우편번호 찾기</button></td>
	</tr>
	<tr>
		<th>주소</th>
		<td colspan="2"><form:input path="address" value="${loginUser.address}"/></td>
	</tr>
	<tr>
		<th>상세주소</th>
		<td colspan="2"><form:input path="detailaddress" value="${loginUser.detailaddress}"/></td>
	</tr>
	<tr>
		<th>성별</th>
			<c:choose>
		    	<c:when test="${loginUser.gender=='M'}">
		      	 	<td colspan="2">남성</td>
		    	</c:when>
		    	<c:otherwise>
		      	  	<td colspan="2">여성</td>
		   		</c:otherwise>
			</c:choose>
	</tr>
	<tr>
		<th>등급</th>
		<c:choose>
    	<c:when test="${loginUser.grade==999}">
      	 	<td colspan="2">관리자</td>
    	</c:when>
    	<c:otherwise>
      	  	<td colspan="2">회원</td>
   		 </c:otherwise>
		</c:choose>
	</tr>
		<tr>
		<th>가입일</th>
		<td colspan="2">${loginUser.regdate}</td>
	</tr>
</table>
<div style="padding-left:15%;">
	<input id="ment" type="submit" class="readmore" value="수정" />
	<input type="button" class="readmore" onclick="location.href='/myInfo'" value="취소" />
	
</div>
<div style="padding-left:8%;">
<br/>
	<p id="updateCheck"></p>
</div>
</form:form>
</div>
</main>
<footer><jsp:include page="/resources/module/footer.jsp"/></footer>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address").value = roadAddr;
            document.getElementById("jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
</script>
</body>
</html>