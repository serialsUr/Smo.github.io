package com.damoye.secondproject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.damoye.secondproject.model.CommBoardVO;

public interface CommboardService {
	
	//댓글목록조회
	public List<CommBoardVO> getcommList(int boardNo) throws Exception;
	
	//댓글입력
	public void insertCommBoard(CommBoardVO commBoardVO) throws Exception;
	
	//댓글선택
	public CommBoardVO selectComm(CommBoardVO commBoardVO) throws Exception;

	//댓글수정
	public int updateSubmitComm(CommBoardVO commBoardVO) throws Exception;
	
	//댓글삭제
	public int deleteComm(int commNo) throws Exception;
	

}
