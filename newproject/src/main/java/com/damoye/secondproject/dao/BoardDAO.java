package com.damoye.secondproject.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

public interface BoardDAO {
	
	//클럽게시판 글목록
	public List<BoardVO> getBoardList(int cNo);
	
	public BoardVO getBoardDetail(int boardNo);
	
	//클럽게시판 글작성
	public void insertBoard(BoardVO boardVO);

	//클럽게시판 게시글 수
	public int count(int cNo);
	
	//클럽게시판 글목록+페이징
	public List<BoardVO> getBoardListPage(int cNo,int displayPost, int postNum);

	//클럽게시판 글수정
	public int updateSubmitBoard(BoardVO boardVO) throws DataAccessException;

	//클럽게시판 글삭제(update)
	public int deleteBoard(int cNo, int boardNo,BoardVO boardVO) throws DataAccessException;

	public ClubDTO getClubDTOByNo(int cNo);

	public int validClubMember(ClubMemberDTO clubMember);
	
}
