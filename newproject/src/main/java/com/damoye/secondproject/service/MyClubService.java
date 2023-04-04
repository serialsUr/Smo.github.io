package com.damoye.secondproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoye.secondproject.dao.MyClubDAO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

@Service
public class MyClubService {

	@Autowired
	private MyClubDAO myClubDAO;

	public List<ClubDTO> getMyClub(int userNo) {
		List<ClubMemberDTO> myClubList = myClubDAO.getMyClubNo(userNo);
		List<ClubDTO> list = new ArrayList<ClubDTO>();
		for(int i=0;i<myClubList.size();i++) {
			list.add(myClubDAO.getMyClubList(myClubList.get(i).getcNo()));
		}
		return list;
	}
}
