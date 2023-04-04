package com.damoye.secondproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoye.secondproject.dao.BoardDAO;
import com.damoye.secondproject.dao.BoardDAOImpl;
import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAOImpl;

	@Override
	public List<BoardVO> getBoardList(int cNo) {
		List<BoardVO> boardList = boardDAOImpl.getBoardList(cNo);
		return boardList;
	}

	@Override
	public BoardVO getBoardDetail(int boardNo) {
		return boardDAOImpl.getBoardDetail(boardNo);
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAOImpl.insertBoard(boardVO);
	}

	
	@Override
	public int count(int cNo) {
		return boardDAOImpl.count(cNo);
	}

	@Override
	public List<BoardVO> getBoardListPage(int cNo, int displayPost, int postNum) throws Exception {
		return boardDAOImpl.getBoardListPage(cNo, displayPost, postNum);
	}

	@Override
	public int updateSubmitBoard(BoardVO boardVO) throws Exception {
		return boardDAOImpl.updateSubmitBoard(boardVO);
	}

	@Override
	public int deleteBoard(int cNo, int boardNo,BoardVO boardVO) {
		return boardDAOImpl.deleteBoard(cNo, boardNo, boardVO);
	}
	@Override
	public ClubDTO getClubDTOByNo(int cNo) {
		return boardDAOImpl.getClubDTOByNo(cNo);
	}
	@Override
	public int validClubMember(ClubMemberDTO clubMember) {
		return boardDAOImpl.validClubMember(clubMember);
	}
	
}
