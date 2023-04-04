<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=request.getContextPath()%>"/> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#upId{width:291px;}
	#check_Id{width:124px;}
	#submit{margin-top:10px;}
</style>
<script>
var code=""; //이메일로 전송되는 인증번호 저장을 위한 변수작성

/* 인증번호 이메일 전송 */
$(document).ready(function(){
	$(".mail_button").click(function(){
		var email = $(".Email").val();// 입력한 이메일
		var checkBox = $("#mail-check-input"); //인증번호 입력란
	    $.ajax({
	        type:"GET",
	        url:"mailCheck?email=" + email,
	        success:function(data){ //data는 signUpController에서 return된 num을 받음
	        	console.log("data : " + data);
	        	checkBox.attr("disabled", false); //disabled해제(입력 가능으로 바뀜)
	        	checkBox.attr("placeholder", "인증번호 6자리를 입력해주세요");
	        	code = data;
	        	alert("요청하신 이메일로 인증번호를 보내드렸습니다.");
	        }
	    });
	});
});

/* 인증번호 비교*/
$(document).ready(function(){
	$("#mail-check-input").blur(function(){ //focus는 이벤트 발생시 포커스 받을 때, blur는 이벤트 발생시 포커스를 잃을 때
		var inputCode = $("#mail-check-input").val(); //입력코드(사용자가 입력하는 인증번호)
		var checkResult = $("#mail_check_input_box_warn"); //비교 결과

		if(inputCode==code){
			checkResult.html("인증번호가 일치합니다.");
			checkResult.attr("class", "correct");
			return true;
		} else{
			checkResult.html("인증번호가 일치하지 않습니다!");
			checkResult.attr("class", "incorrect");
			return false;
		}
	});
	
	let container = document.getElementById('container')

	toggle = () => {
	  container.classList.toggle('sign-in')
	  container.classList.toggle('sign-up')
	};

	setTimeout(() => {
	  container.classList.add('sign-in')
	}, 200);
});

/*아이디 중복 확인*/
$(document).ready(function(){
	$("#check_Id").click(function(){
        var id = $("#id").val();
        
        $.ajax({
            type:"GET",
            url:"/checkId",
            data: {"id" : id},
            success: function(data){ 
            	console.log(data);
                if(data == "N"){ // 만약 성공할시
                	msg = "사용 가능한 아이디입니다.";
                    $("#result_checkId").html(msg).css("color", "green");
                    $("#pass").trigger("focus");
                 
             }else{ // 만약 실패할시
            	 msg = "사용 불가능한 아이디입니다.";
                     $("#result_checkId").html(msg).css("color","red");
                     $("#id").val("").trigger("focus");
             }
                 
         },
            error : function(error){alert(error);}
        });
        
    });
    
});

/*주민번호 중복 확인*/
$(document).ready(function(){
	$(".Email").click(function(){
        var pricynum = $("#pricynum").val();
        
        $.ajax({
            type:"POST",
            url:"/checkPricynum",
            data: {"pricynum" : pricynum},
            success: function(cnt){ 
                if(cnt == 0){ 
                	 $("#result_pricynum").text("");
             }else{ // 만약 실패할시
            	 msg = "이미 가입된 회원입니다.";
                     $("#result_pricynum").html(msg).css("color","red");
                     $("#pricynum").val("").trigger("focus");
             }
         },
            error : function(error){alert(error);}
        });
    });   
});

/*submit*/
$(document).ready(function(){
	$("#submit").click(function(){
		
		if($("#result_checkId").text()==""){
			alert("아이디 중복검사를 해주세요.");
			console.log($("#result_checkId").text());
			return false;
		}
		else if($("#mail_check_input_box_warn").text()==""){
			alert("이메일 인증을 완료해주세요.");
			console.log($("#mail_check_input_box_warn").text());
			return false;
		}

		$("#signUpFrm").submit();

	});
});

/*아이디 비밀번호*/
$(document).ready(function(){
	$("#forgotId").click(function(){
		newWin = window.open("${path}/findId", "아이디 찾기", "resizeable");
		newWin.resizeTo(500, 400);
		newWin.onresize = (_=>{newWin.resizeTo(500, 400);})
	});
	$("#forgotPw").click(function(){
		newWin = window.open("${path}/findPw", "비밀번호 찾기", "resizeable");
		newWin.resizeTo(500, 400);
		newWin.onresize = (_=>{newWin.resizeTo(500, 400);})
	});
});
</script>
<style>
#zipcode{
	width: 60%;
}
#zipcode_Btn{
	width: 40%;
}
#email{
	width: 70%;
}
#email_Btn{
	width: 30%;
}
a{
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="container" class="container">
    <!-- FORM SECTION -->
    <div class="row">
      <!-- SIGN UP -->
      <div class="col align-items-center flex-col sign-up">
        <div class="form-wrapper align-items-center">
          <div class="form sign-up">
          	<form:form id="signUpFrm" modelAttribute="user" method="post" accept-charset="utf-8" action="/signUp">
            <div class="input-group" style="text-align:left;">
              <i class='bx bxs-user'></i>
              <form:input path="id" name="id" placeholder="ID" id="upId" required="required"/><button type="button" id="check_Id">중복확인</button><br/>
			  <span id="result_checkId" style="font-size:12px;"></span><br/>
            </div>
            <div class="input-group">
              <i class='bx bx-mail-send'></i>
              <form:password path="password" name="password" placeholder="Password" required="required"/><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="name" name="name" placeholder="Name" required="required"/><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="zipcode" name="zipcode" id="zipcode" placeholder="Zipcode" required="required"/><button type="button" id="zipcode_Btn" onclick="execDaumPostcode()">우편번호 찾기</button><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="address" name="address" placeholder="Address" required="required"/><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="detailaddress" name="detailaddress" placeholder="Detail_Address"/><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="pricynum" name="pricynum" placeholder="Pricynum" required="required"/><br/>
              <span id="result_pricynum" style="font-size:12px;"></span><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="email" class="Email" name="email" id="email"  placeholder="Email" required="required"/><button type="button" id="email_Btn" class="mail_button">본인인증</button><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <input type="text" id="mail-check-input" name="email_check" disabled="disabled" placeholder="이메일 입력과 본인인증을 해주세요" maxlength="6" placeholder="email_check"/>
              <span id="mail_check_input_box_warn"></span><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <form:input path="phonenum" name="phonenum" placeholder="Phonenum" required="required"/><br/>
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
             <div>
             	Gender
             </div>
             <div style="float:left; padding-left:157px;">
              <form:radiobutton path="gender" name="gender" class="gender" value="M"/> 남성
			  </div>
			  <div style="float:left;">
			  	<form:radiobutton path="gender" name="gender" class="gender" value="F"/> 여성<br/>
			  </div>            
            </div>
            <button id="submit">Sign Up</button>
            </form:form>
            <p>
              <span>
                Already have an account?
              </span>
              <b onclick="toggle()" class="pointer">
                Sign in here
              </b>
            </p>
          </div>
        </div>
      
      </div>
      <!-- END SIGN UP -->
      <!-- SIGN IN -->
      <div class="col align-items-center flex-col sign-in">
        <div class="form-wrapper align-items-center">
          <div class="form sign-in">
          	<form:form action="/signIn" modelAttribute ="user" method="post">
	            <div class="input-group">
	              <i class='bx bxs-user'></i>
	              <form:input path="id"  name="id" placeholder="ID" />
					<span class="fieldError"><form:errors path="id"/></span>
	            </div>
	            <div class="input-group">
	              <i class='bx bxs-lock-alt'></i>
	              <form:password path="password" placeholder="Password" />
				<span class="fieldError"><form:errors path="password" /></span>
	            </div>
	            <button id="Login_Btn" class="Login_Btn">Login in</button><br/>
            </form:form>
            <p>
              <b>
               <a href="#" id="forgotId">Forgot ID?</a>
              </b>
              /
              <b>
               <a href="#" id="forgotPw">Forgot password?</a>
              </b>
            </p>
            <p>
              <span>
                Don't have an account?
              </span>
              <b onclick="toggle()" class="pointer">
                Sign up here
              </b>
            </p>
          </div>
        </div>
        <div class="form-wrapper">
    
        </div>
      </div>
      <!-- END SIGN IN -->
    </div>
    <!-- END FORM SECTION -->
    <!-- CONTENT SECTION -->
    <div class="row content-row">
      <!-- SIGN IN CONTENT -->
      <div class="col align-items-center flex-col">
        <div class="text sign-in">
          <h2>
            Welcome to DAMOYE
          </h2>
  
        </div>
        <div class="img sign-in">
    
        </div>
      </div>
      <!-- END SIGN IN CONTENT -->
      <!-- SIGN UP CONTENT -->
      <div class="col align-items-center flex-col">
        <div class="img sign-up">
        
        </div>
        <div class="text sign-up">
          <h2>
            Join with us
          </h2>
  
        </div>
      </div>
      <!-- END SIGN UP CONTENT -->
    </div>
    <!-- END CONTENT SECTION -->
  </div>
  
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