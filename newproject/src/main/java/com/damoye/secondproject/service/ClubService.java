package com.damoye.secondproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.CategoryDTO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubListPage;
import com.damoye.secondproject.model.ClubMemberDTO;
import com.damoye.secondproject.model.User;

@Service
public interface ClubService {

	//특정 카테고리 조회 selCategory
	//public List<CategoryDTO> getSelCategory();
	
	//특정 카테고리 조회
	public String getSelCategoryName(int categoryNo) throws Exception;
	//클럽 목록 조회 selClubList
	public ClubListPage getSelClubList(int categoryNo,int PageNo) throws Exception;	
	
	//검색
	public ClubListPage getSearchCName(ClubDTO clubDTO,int pageNo) throws Exception;
	//전체 검색
	public ClubListPage getAllSearchCName(ClubDTO clubDTO,int pageNo) throws Exception;
	//클럽 상세보기-소개글
	public ClubDTO getSelClubDetail(int cNo) throws Exception;
	//클럽 상세보기-가입자수
	public int getClubCount(int cNo) throws Exception;
	//클럽 상세보기-모임글
	public List<BoardVO> getSelBDetail(int cNo) throws Exception;
	//클럽 상세보기-클럽가입 아이디 리스트
	public List<ClubMemberDTO> getSignMember(int cNo) throws Exception;	
	//클럽 가입하기
	public void getSignClub(ClubMemberDTO clubMemberDTO) throws Exception;	
	//클럽 생성
	public int getCreClub(ClubDTO clubDTO) throws Exception;
	//클럽수정
	public int getUpdateClub(ClubDTO clubDTO) throws Exception;
	//클럽삭제
	public int getDel(int cNo) throws Exception;	
	//클럽회원삭제
	public int getMemberDel(int cMemberNo) throws Exception;
	//전체 클럽 조회 
	public ClubListPage getAllClubList(int pageNo) throws Exception;



	
	
	

	
}
