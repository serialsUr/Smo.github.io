package com.damoye.secondproject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoye.secondproject.dao.ChatDAO;
import com.damoye.secondproject.model.ChatDTO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

@Service
public class ChatService { 
	
	@Autowired
	private ChatDAO chatDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ChatService.class);
	
	public void addMessage(ChatDTO chatDTO) {
		chatDAO.addMessage(chatDTO);
	}

	public List<ChatDTO> listMessage(int roomNo) {
		List<ChatDTO> list = chatDAO.listMessage(roomNo);
		
		return list;
	}
	
	public int validClubMember(ClubMemberDTO clubMember) {
		return chatDAO.validClubMember(clubMember);
	}
	public ClubDTO getClubByNo(int cNo) {
		return chatDAO.getClubByNo(cNo);
	}
}

