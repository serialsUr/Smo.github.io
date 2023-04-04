<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<c:set var="contextPath1" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- ck editor 5 -->
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
<link rel="stylesheet" href="${path}/resources/css/default.css">
<title>사진 등록</title>
<style>

input[type=file]::file-selector-button {
  width: 73.3px;
  height: 30px;
  color:white;
  background: #286D4B;
  border: 0px solid white;
  cursor: pointer;
  &:mouseover {
    background: rgb(77,77,77);
    color: #fff;
  }

}		
</style>
<script>
let count=1; //기존의 것

var cnt=0; //새로추가


$(document).ready(function(){
//<input type="button" value="파일삭제" id="btnDelFile"/>
  $("#btnDelFile").click(function(){ 
  	
  	if(count==1){ //유지해야하는 파일수보다 적다면
  		alert("반드시 한개는 있어야 합니다.");
  		return;
  	}
  	
  	let tr = $("#files"+count).parents("tr");
  	//id가 "i1"요소의 바로 앞에 위치한 형제(자매)를 삭제되는 것처럼 보인다
   //$(기준요소).remove();
   $(tr).remove();
  	count--; 
   
  });
  
  
  //<input type="button" value="파일추가" id="btnAddFile"/>
    $("#btnAddFile").click(function(){ 
     count++;
     
     if(count==4){ //허용된 첨부파일수(3개)보다 크다면
     	alert("첨부파일은 최대 3개까지 가능합니다.");
     	count=3;
     	return; //함수종료
     }
     
     let tr = "<tr><th>첨부파일</th><td>";
      	tr+="<input type='file' name='fileName"+count+"' id='fileName"+count+"'/></td></tr>";
     
     //id가 "i1"요소의 바로 앞에 위치한 형제(자매)붙인다
     //$(기준요소).before(추가할요소);	
     $("#i1").before(tr);	
    });
    
 //======================================================================
 $("#btnDelFile2").click(function(){ 
  	
  	if(cnt==0){ //유지해야하는 파일수보다 적다면
  		alert("반드시 한개는 있어야 합니다.");
  		return;
  	}
  	
  	let tr = $("#newfiles"+cnt).parents("tr");
  	//id가 "i1"요소의 바로 앞에 위치한 형제(자매)를 삭제되는 것처럼 보인다
   //$(기준요소).remove();
   $(tr).remove();
   cnt--; 
   
  });
 
//<input type="button" value="파일추가" id="btnAddFile2"/>
 $("#btnAddFile2").click(function(){ 
	  cnt++;
  
  if(cnt==5){ //허용된 첨부파일수(3개)보다 크다면
  	alert("첨부파일은 최대 3개까지 가능합니다.");
  	cnt=3;
  	return; //함수종료
  }
  
  let tr = "<tr><th>첨부파일</th><td>";
   	tr+="<input type='file' name='fileName"+count+"' id='fileName"+count+"'/></td></tr>";
  
  //id가 "i1"요소의 바로 앞에 위치한 형제(자매)붙인다
  //$(기준요소).before(추가할요소);	
  $("#i1").before(tr);	
 });
});//jQuery끝
 
 
  //<input type="button" value="fn_addFile()파일추가" id="btnAddFile2" onclick="fn_addFile()"/>
 
  
  function fn_addFile(){
	   cnt++;
	    
	    if(cnt==5){ //허용된 첨부파일수(3개)보다 크다면
	    	cnt=4;
	    	return; //함수종료
	    }
	   
	  let tr2 = "<tr><th>첨부파일</th><td>";
      tr2+="<input  type='file' id='newfiles"+cnt+"' name='detail_image"+cnt+"' /></td></tr>";
     //$("#d_file").append("<br>"+"<input  type='file' id='newfiles"+cnt+"' name='detail_image"+cnt+"' />");
    
     
     //id가 "i1"요소의 바로 앞에 위치한 형제(자매)붙인다
     //$(기준요소).before(추가할요소);	
     $("#i2").before(tr2);	
  }
  
  
  //<input type="button" value="MAIN_첨부파일upload하기" onclick="fn_add_new_goods(this.form)"/>
  //메인 이미지는 반드시 첨부해야 합니다.  필수적으로 메인에 출력할 1개이미지를 첨부하도록 유도
  function fn_add_new_goods(obj){
      fileName = $('#f_main_image').val();
	  alert(fileName.length);
      if(fileName.length!=0 && fileName != null && fileName != undefined){
         obj.submit();
      }else{
   	   alert("메인 이미지는 반드시 첨부해야 합니다.");
         return;
      }
      
  }
</script>
<style>
#tableCenter{
   display: flex;
    justify-content: center;
}
table{
   width:60%;
}
</style>
</head>
<body>
<header><jsp:include page="/resources/module/header.jsp"></jsp:include></header>
<div id="subheader">
      <div class="row">
         <div class="eight columns">
            <p class="bread leftalign">
               <b>사진 게시판 작성</b>
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
   <form id="uploadFrm" 
  		method="post" enctype="multipart/form-data" 
  		action="${contextPath}/photo/addNewarticle">  
      <div id="tableCenter">
      <table border="1">
         <tr>
            <th>작성자</th>
            <td>${loginId}</td>
         </tr>
         <tr>
            <th>제목</th><td><input type="text" name="goods_title" id="goods_title" placeholder="내용을 입력해주세요"/></td>
         </tr>
         <tr>
            <th>내용</th>
            <td>
               <textarea rows="10" cols="30" name="goods_content" id="content" placeholder="내용을 입력해주세요"></textarea>
               <!-- <div id="content" name="content"></div> -->
            </td>
         </tr>
         <tr>
	     <th>파일추가/삭제</th>
	     <td>
	        <input type="button" class="readmore" value="파일추가" id="btnAddFile2" onclick="fn_addFile()"/>
	      
	    	<input type="button" class="readmore" value="파일삭제" id="btnDelFile2"/>
	     </td>
	    </tr>
	    <tr>
	     <th>사진파일</th>
	     <td>
	     	<input  type='file' name='main_image' id='f_main_image' />
	     </td>
	    </tr>
 		<tr id="i2">
 		 <td colspan="2" style="text-align:center;">
 		 <input type="button" value="사진업로드" class="readmore" onclick="fn_add_new_goods(this.form)"/>
 		 <input type="reset" id="btnReset" class="readmore" value="취소"/></td>	
 		 <tr>
 		</table>
 	  </tbody>
      </div>
   </form>
</main>   
<footer><jsp:include page="/resources/module/footer.jsp"></jsp:include></footer>
</body>
</html>