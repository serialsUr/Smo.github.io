<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../resources/css/chat-room.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>    
<title>${ clubDTO.cName} 채팅방</title>
</head>


	 <script type="text/javascript">
	 
		$(document).ready(function(){

			var listCount; //db에서 가져온 메시지의 크기
			
			/* 작성버튼 클릭시 입력동작  */
			$('#formBtn').on("click",function(){
				addMessage();
			});
			
			/* 작성폼에서 엔터시 입력동작 */ 
			$('#content').on("keyup",function(key){
		        if(key.keyCode==13) {
		        	addMessage();
		        }
		    });
			
			// 메시지 작성 
			function addMessage(){
				var content = $('#content').val().trim();
				var roomNo = ${param.roomNo};
				
				if(content.length == 0){
					$('#content').focus();
					
					return false;
				}
				$.ajax({
		 			type: "POST",
		 			url: "./addMessage",
		 			data:{
		 				roomNo : roomNo,
		 				content : content
		 			},
		 			dataType:"json",
		 			success:console.log("add message"),
		 			error: function(){
		 				console.log("insert error");
		 			}
		 		});
				$('#content').val(null);
				$('html, body').scrollTop($('#scrollTest').scrollHeight);
			};
			
			//메시지 불러오기 
			function loadMessage(){
				var roomNo = ${param.roomNo};
				var loginId ='${userId}';

				$.ajax({
		 			type: "POST",
		 			url: "./checkMessage",
		 			data:{
		 				roomNo:roomNo
		 			},
		 			success: function(data){
		 				if(listCount == data.message.length){
		 					return;
		 				}
		 				listCount = data.message.length;
		 				document.getElementById("chatInfo").innerHTML = '';
		 				for(var i=0;i<data.message.length;i++){
		 					
		 					var writerData = data.message[i].writerId;
		 					
		 					if(loginId == writerData){
		 						drawMyMessage(data.message[i]);
		 					}else{
			 					drawMessage(data.message[i]);
		 					} 
		 				}
		 				$('html, body').scrollTop($(document).height());
		 			},
		 			error: function(){
		 				console.log("error1");
		 			}
		 		});
			};
			
			//다른사람의 메시지 구분 
			function drawMessage(chatMessage){
			
				 $('#chatInfo').append(	'<div class="friend-chat"><div class="friend-chat-col">'+
										' <span class="profile-name" id="chatName">'+chatMessage.writerId+'</span>'+
										'<span class="balloon" id="chatContent">'+chatMessage.content+'</span>'+
										' <span id="chatTime">'+chatMessage.creDate+'</span></div></div>'); 
			
			}; 
			
			//내가 쓴 메시지 구분
			function drawMyMessage(chatMessage){
				
				$('#chatInfo').append(	'<div class="me-chat"><div class="me-chat-col">'+
										'<span class="balloon" id="chatContent">'+chatMessage.content+'</span>'+
										' <span id="chatTime">'+chatMessage.creDate+'</span></div></div>');

			}; 
			
			//실시간 메시지 (1초마다 메시지리스트함수 실행)
			setInterval(loadMessage,1000);
			
		}); //ready end
		
		
	</script>
<body>
	<div id="chat-body">
            <!-- 프로필 사진, 프로필명 -->
            <header>
                <div class="profile-col">
                    <span class="profile-name">${clubDTO.cName}</span>
                </div>
            </header>
            <main>
                <!-- 채팅 내용 시작 -->
                <div class="chat-content" id="chat-content">
                    <!-- 채팅 내용 -->
                    <div class="main-chat">
                           <div class="friend-chat-col" id="chatInfo">
                           </div>
                  	 </div>
                </div>
                <div class="scrollTest" id="scrollTest"></div>
                <!-- 채팅 입력창 -->
                <div class="insert-content">
                	 <form name="chatform" id="addForm" method="post" >
					 		<input type="hidden" name="roomNo" value="${param.roomNo }"/><br>
							<textarea  name="content" id="content"></textarea>
							<span id="formBtn" class="chat-submit">작성</span>
					</form> 
                </div>
            </main>
        </div>
</body>
</html>