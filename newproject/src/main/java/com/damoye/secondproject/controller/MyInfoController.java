package com.damoye.secondproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.damoye.secondproject.model.User;
import com.damoye.secondproject.service.UserService;


@Controller
public class MyInfoController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/myInfo", method=RequestMethod.GET)
	public String requestMyInfomation(User user) {
		
		return "user/myInfo";
	}
	
	@RequestMapping(value="/modifyMyInfo", method=RequestMethod.GET)
	public String requestModifyMyInfomation(User user) {
		
		return "user/modifyMyInfo";
	}
	
	@RequestMapping(value="/modifyMyInfo", method=RequestMethod.POST)
	public String submitMyInfo(HttpSession session,@ModelAttribute("user") User user, String id, String password, String email, String phonenum, String zipcode, String address, String detailaddress) {
		
		userService.modifyUserInfo(user.getId(), password, email, phonenum, zipcode, address, detailaddress);

		return "redirect:/logout";
	}
}
