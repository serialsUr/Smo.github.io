package com.damoye.secondproject.controller;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.damoye.secondproject.model.ImageFileVO;
import com.damoye.secondproject.model.User;
import com.damoye.secondproject.service.PhotoGoodsService;

@Controller
public class PhotoController extends  PhotoBaseController {

	private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);
	
	 @Autowired   
	 PhotoGoodsService goodsService;
	
	//입력폼보여주기
	//요청방식 get
	//요청주소 ~컨페/addForm
	@GetMapping("/photo/addForm")
	public String insertArticleForm(HttpSession session,Model model) {
		//1.파라미터받기 //2.비즈니스로직
		//3.model
		//원칙적으로는 (로그인한 user가) 글입력 권한을 가진 사용자가 글입력해야지만
		//여기에서는 임시로 세션에 정보를 저장하여 진행하겠다
		
		//HttpSession session = request.getSession();
		//session.setAttribute("isLogOn",true);
		//session.setAttribute("AUTHUSER_ID", "hongid");//임시
		User user = (User)session.getAttribute("loginUser");
		String loginId = user.getId();
		model.addAttribute("loginId",loginId );
		//4.view
		return "/photo/addForm";
	}
	
	//파일저장경로
  	private static final String REPO_PATH = "C:\\spring\\article_repo";
	
	//입력처리
	//요청방식 post
	//요청주소 ~컨페/article/addNewarticle.do
	//@PostMapping("/article/addNewarticle")
	@RequestMapping(value="/photo/addNewarticle" ,method={RequestMethod.POST})
	public ResponseEntity submitArticleForm(ModelAndView mv,
			MultipartHttpServletRequest multipartRequest) throws Exception {			
		//multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap(); //글관련정보+첨부파일정보
  		
		//1.form요소 중에서(<input type="file">이 아닌 요소의 name속성의 값)파라미터명 가져오기
		Enumeration enu = multipartRequest.getParameterNames();  
		while( enu.hasMoreElements() ) {
			//map에는 key이름으로  파라미터명으로(form의 name속성값) 사용하겠다
			//value는 가져온 파라미터명을 이용하여 추출
			String name = (String)enu.nextElement();
			String value= multipartRequest.getParameter(name);
			System.out.println("컨트롤러 while문안 map.put(name,value)="+name+","+value);
	  		map.put(name,value);  //name에 들어가는 "memberId","file1","file2","file3"
	  		//<input type="file">이 아닌 것들에 대한 파라미터명과  값이 담긴다
		}
		
		//session 등록자id를 구하기
		HttpSession session=multipartRequest.getSession();
		/* 세션속성명과 값이  정해졌으나, 아직 소스가 합쳐지기 전상태라면
		AuthUser authUser = new AuthUser();
		authUser.setUserNo(1);
		authUser.setUserId("hongId");
		authUser.setUserName("홍GD");
		session.setAttribute("AUTHUSER",authUser);
		
		AuthUser authUser = session.getAttribute("AUTHUSER");
		String reg_id=authUser.getUserId();*/
		
		//AuthUser라는 객체가 없는 상태라면 아래와 같이 임시 저장해놓고 사용하다가
		//소스합쳐지면 잊지말고   정리하자~~~~~!!!!!!!!!!!!!!!
		//session.setAttribute("AUTHUSER_NO",1);
		//session.setAttribute("AUTHUSER_ID","hongId");//로그인했다 가정하고
		//session.setAttribute("AUTHUSER_NAME","홍GD");
		User user = (User)session.getAttribute("loginUser");
		String id = user.getId();
		//String id = (String)session.getAttribute("AUTHUSER_ID");
		
				
		//2.form요소 중에서<input type="file"> 가져오기		
		//여기에서는 다중파일업로드이므로  n개이니 List로 처리하겠다
		//여기에서는 BaseController로 부터 상속받은 upload()호출
		List<ImageFileVO> imageFileList = upload(multipartRequest);
		if( imageFileList!=null && imageFileList.size()!=0) {
			for( ImageFileVO imageFileVO  : imageFileList) {
				imageFileVO.setId(id);//등록자id를 set
				logger.info("컨트롤러 for문안 imageFileVO="+imageFileVO);
			}
			map.put("imageFileList",imageFileList);
		}//if끝
	   
		
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		String msg = null;
		String imageFileName = null;

		try {
			int goods_id=goodsService.addNewArticle(map);//글관련정보+첨부파일정보			
			
			//입력성공이 되면 
			//"글등록이 되었습니다."라는 alert띄우기+입력폼페이지로 이동+임시파일을 저장소로 이동
			//1)임시파일을 저장소로 복사(->temp폴더안의 임시파일을  글번호폴더생성후 그 하위에 이동)
			if( imageFileList!=null && imageFileList.size()!=0) {
				for( ImageFileVO imageFileVO : imageFileList) {
					imageFileName=imageFileVO.getFileName();
					File srcFile = new File(REPO_PATH+"\\temp\\"+imageFileName);
					File destDir = new File(REPO_PATH+"\\"+goods_id);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}//if
			
			//2)"글등록이 되었습니다."라는 alert띄우기
			msg = "<script>";
			msg+= "alert('글등록이 되었습니다.');";
			msg+= "location.href='"+multipartRequest.getContextPath()+"/photo/main';";
			msg+= "</script>";
			//3)입력폼페이지로 이동
		}catch(Exception e) {
			//입력실패 되면 
			//"오류발생."라는 alert띄우기+입력폼페이지로 이동+업로드된 이미지삭제
			//1)업로드된 이미지삭제
			if(imageFileList!=null && imageFileList.size()!=0) {
				for( ImageFileVO imageFileVO : imageFileList) {
					imageFileName=imageFileVO.getFileName();
					File srcFile = new File(REPO_PATH+"\\temp\\"+imageFileName);
					srcFile.delete();
				}
			}//if
			
			
			//2)"오류발생."라는 alert띄우기   + 3)입력폼페이지로 이동
			msg = "<script>";
			msg+= "alert('오류가 발생했습니다.PLZ Retry');";
			msg+= "location.href='"+multipartRequest.getContextPath()+"/photo/addForm';";
			msg+= "</script>";
			
			e.printStackTrace();
		}
		
		resEntity = new ResponseEntity(msg,responseHeaders,HttpStatus.OK);
		return resEntity;//~~~~~~~~~~~~~~~~~~~~~
	}//입력처리 끝

}











