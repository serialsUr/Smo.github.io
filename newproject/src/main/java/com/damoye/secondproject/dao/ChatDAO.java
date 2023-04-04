package com.damoye.secondproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.ChatDTO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;


@Repository
public class ChatDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ChatDAO.class);
	
	public void addMessage(ChatDTO chatDTO) {
		sqlSession.insert("mapper.chat.chatInsert", chatDTO);
	}

	public List<ChatDTO> listMessage(int roomNo) {
		
		List<ChatDTO> list = sqlSession.selectList("mapper.chat.chatList",roomNo);
		return list;
	}
	
	public int validClubMember(ClubMemberDTO clubMember) {
		return sqlSession.selectOne("mapper.club.clubJoinValid", clubMember);
	}
	
	public ClubDTO getClubByNo(int cNo) {
		return sqlSession.selectOne("mapper.club.selClubDetail", cNo);
	}
}
