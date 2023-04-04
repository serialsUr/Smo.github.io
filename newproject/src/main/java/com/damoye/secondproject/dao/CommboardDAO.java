package com.damoye.secondproject.dao;

import java.util.List;

import com.damoye.secondproject.model.CommBoardVO;

public interface CommboardDAO {

	//댓글조회
	public List<CommBoardVO> list(int boardNo) throws Exception;
	
	//댓글작성
	public void insertCommBoard(CommBoardVO commBoardVO) throws Exception;
	
	//댓글선택
	public CommBoardVO selectComm(CommBoardVO commBoardVO) throws Exception;

	//댓글수정
	public int updateSubmitComm(CommBoardVO commBoardVO) throws Exception;
	
	//댓글삭제
	public int deleteComm(int commNo) throws Exception;
}
