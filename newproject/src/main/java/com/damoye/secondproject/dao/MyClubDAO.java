package com.damoye.secondproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

@Repository
public class MyClubDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<ClubMemberDTO> getMyClubNo(int userNo) {
		List<ClubMemberDTO> list = sqlSession.selectList("mapper.myClub.getMyClubNo", userNo);
		return list;
	}

	public ClubDTO getMyClubList(int cNo) {
		ClubDTO clubDTO = sqlSession.selectOne("mapper.myClub.getMyClub", cNo);;
		return clubDTO;
	}
	
}
