package com.damoye.secondproject.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.damoye.secondproject.model.GoodsVO;
import com.damoye.secondproject.model.User;
import com.damoye.secondproject.service.PhotoGoodsService;

/* 여기에서는 servlet-context.xml문서에서 아래와 bean을 등록할 수 있다
 * <!-- 파라미터가 없는 기본생성자를 이용한 bean객체 생성 -->
<!-- bean요소  
     class="패키지명.클래스명"
     id="id명" -->
<!-- EmpServiceImpl empService = new EmpServiceImpl(); -->     	
<!-- <beans:bean 
            class="com.mycom.app.emp.service.EmpServiceImpl" 
            id="empService"></beans:bean> */

/* com.ourcom.main패키지안의 MainController클래스를
   id가 mainController인 bean으로 등록
   <beans:bean 
            class="com.ourcom.main.MainController" 
            id="mainController"></beans:bean>
 */
@Controller("photoMainController")
public class PhotoMainController extends PhotoBaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoMainController.class);
	
	@Autowired   
	PhotoGoodsService goodsService;
	
	//메인화면에 출력하고 싶은 컨트롤러의 요청함수를 구현하면된다
	//여기에서는 메인화면에 상품전체목록보기 처리를 구현
	@RequestMapping(value = "/photo/main", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session
			 ) throws Exception {
		//session.setAttribute("isLogOn",true);  //세션에 값저장하기
		//session.setAttribute("AUTHORUSER_ID","hongid");  
		
		//HttpSession session1=multipartRequest.getSession();
		//session.removeAttribute("admin_mode");
		//session.removeAttribute("my_page");
		
		//User user=new User();
		
		//user = (User)session1.getAttribute("AUTHORUSER_ID");
		//String id = user.getId();
		
		//session.setAttribute("isLogOn",true);  //세션에 값저장하기
		//session.setAttribute("AUTHORUSER_ID",id);  
		//session.setAttribute("side_menu","admin_mode");  //관리자모드로 설정
		//session.setAttribute("side_menu","my_page");  //로그인한 유저
		//ession.setAttribute("속성명",값);  //세션에 값저장하기
		//${속성명}  //세션에 값가져오기-jsp
		
		//특정글번호의 id조회
		/*
		 * ImageFileVO Id = goodsService.selectimNo(id);
		 * 
		 * model.addAttribute("Id", Id); session.setAttribute("AUTHUSER_Id",
		 * Id.getId());//로그인한 회원의 모든 정보가 담긴상태
		 */
		
		Map<String,List<GoodsVO>> goodsMap = goodsService.listGoods();
		model.addAttribute("goodsMap", goodsMap);
		return "photo/main";
	}
	
}





