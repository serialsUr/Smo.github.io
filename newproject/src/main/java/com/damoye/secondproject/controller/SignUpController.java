package com.damoye.secondproject.controller;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.damoye.secondproject.model.User;
import com.damoye.secondproject.service.UserService;



@Controller
public class SignUpController {

	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	
	// 회원등록 폼 이동
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String requestSignUpForm(@ModelAttribute("user") User user, Model model, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		return "user/signUpForm";
	}
	
	// 회원등록 데이터 처리
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String submitSignUp(@Valid User user, Model model, BindingResult bindingResult, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("signUp진입");
			if(bindingResult.hasErrors()) {
				List<ObjectError> list = bindingResult.getAllErrors();
				for(ObjectError e : list){
				}
				return "user/signUpForm";
			}
		
		userService.signUpUser(user);
		return "user/signInForm";
	}
	
	// 이메일 인증 
    @RequestMapping(value="/mailCheck", method=RequestMethod.GET)
    @ResponseBody
    public String mailCheckGET(String email) throws Exception{
        
        /* 뷰(View)로부터 넘어온 데이터 확인 */
        logger.info("이메일 데이터 전송 확인");
        logger.info("인증번호 받을 이메일 : " + email);
        
        /* 인증번호(난수) 생성 */
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;
        logger.info("인증번호 " + checkNum);
        
        /* 이메일 보내기 */
        String setFrom = "rudals407@naver.com";
        String toMail = "rudals6969@naver.com";
        String title = "다모여의 회원가입 인증 이메일 입니다.";
        String content = 
                "다모여에 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        String num = Integer.toString(checkNum);
        return num;
    }
    
    //아이디 중복 확인
    @RequestMapping(value="/checkId", method=RequestMethod.GET)
    @ResponseBody
    public String checkId(@RequestParam("id") String id) {
    	System.out.println("CONTROLLER");
    	String flag = "N";
    	
    	int cnt = userService.checkId(id);
    	System.out.println("cnt"+cnt);
    	
    	if(cnt == 1) flag = "Y";
    	
    	System.out.println("flag="+flag);
    	
    	return flag;
    }
    
	//아이디 중복체크
	@PostMapping("/checkPricynum")
	@ResponseBody
	public int Pricynumcheck(@RequestParam("pricynum") String pricynum) {
		System.out.println("컨트롤러 접근");
		int cnt = userService.pricynumCheck(pricynum);
		System.out.println("cnt="+cnt);
		return cnt;
		
	}
	


}
