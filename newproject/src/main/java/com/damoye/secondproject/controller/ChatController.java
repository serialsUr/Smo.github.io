package com.damoye.secondproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.damoye.secondproject.model.ChatDTO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;
import com.damoye.secondproject.model.User;
import com.damoye.secondproject.service.ChatService;


@Controller
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping("/clubNoJoin")
	public String clubNoJoin() {
		return "club/clubNoJoin2";
	}
	@RequestMapping("/chat/room")
	public String showRoom(int roomNo,HttpSession session, Model model) {
		User user = (User)session.getAttribute("loginUser");
		String userId = user.getId();
		model.addAttribute("userId", userId);
		
		int userNo = user.getNo();
		ClubMemberDTO clubMember = new ClubMemberDTO();
		clubMember.setcNo(roomNo);
		clubMember.setNo(userNo);
		int result = chatService.validClubMember(clubMember);
		if(result == 0) {
			return "redirect:/clubNoJoin";
		}
		
		ClubDTO clubDTO = chatService.getClubByNo(roomNo);
		model.addAttribute("clubDTO",clubDTO);
		return "chat/room";
	}
	@RequestMapping(value="/chat/addMessage", method=RequestMethod.POST)
	@ResponseBody
	public void addPostMessage(@RequestParam int roomNo,@RequestParam String content
								,HttpSession session) {
		ChatDTO chatDTO = new ChatDTO();
		User user = (User)session.getAttribute("loginUser");
		String writerId = user.getId();
		chatDTO.setRoomNo(roomNo);
		chatDTO.setWriterId(writerId);
		chatDTO.setContent(content);
		
		chatService.addMessage(chatDTO);
	}
	
	@RequestMapping(value = "/chat/checkMessage",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> listMessage(@RequestParam int roomNo) {
		Map<String, Object> rs = new HashMap<String, Object>();
		List<ChatDTO> list = chatService.listMessage(roomNo);
		rs.put("message",list);
		return rs;
	}

}
