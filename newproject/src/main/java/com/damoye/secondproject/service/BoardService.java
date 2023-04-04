package com.damoye.secondproject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

public interface BoardService {
	
	//클럽게시판 글목록조회
	public List<BoardVO> getBoardList(int cNo) throws Exception;
	
	//클럽게시판 상세조회
	public BoardVO getBoardDetail(int boardNo) throws Exception;
	
	//클럽게시판 게시글 수
	public int count(int cNo) throws Exception;
	
	//클럽게시판 글등록
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//클럽게시판 글목록조회+페이징
	public List<BoardVO> getBoardListPage(int cNo, int displayPost, int postNum) throws Exception;
	
	//클럽게시판 글수정
	public int updateSubmitBoard(BoardVO boardVO) throws Exception;

	//클럽게시판 글삭제
	public int deleteBoard(int cNo, int boardNo, BoardVO boardVO);

	public ClubDTO getClubDTOByNo(int cNo);

	public int validClubMember(ClubMemberDTO clubMember);



	




	
	
	
}
