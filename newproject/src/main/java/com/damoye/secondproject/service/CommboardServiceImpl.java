package com.damoye.secondproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoye.secondproject.dao.CommboardDAO;
import com.damoye.secondproject.model.CommBoardVO;

@Service
public class CommboardServiceImpl implements CommboardService {
	
	@Autowired
	CommboardDAO commboardDAOImpl;
	
	@Override
	public List<CommBoardVO> getcommList(int boardNo) throws Exception {
		List<CommBoardVO> commList = commboardDAOImpl.list(boardNo);
		return commList;
	}

	@Override
	public void insertCommBoard(CommBoardVO commBoardVO) throws Exception {
		commboardDAOImpl.insertCommBoard(commBoardVO);
	}
	
	@Override
	public CommBoardVO selectComm(CommBoardVO commBoardVO) throws Exception {
		return commboardDAOImpl.selectComm(commBoardVO);
		
	}
	
	@Override
	public int updateSubmitComm(CommBoardVO commBoardVO) throws Exception {
		return commboardDAOImpl.updateSubmitComm(commBoardVO);
	}

	@Override
	public int deleteComm(int commNo) throws Exception {
		return commboardDAOImpl.deleteComm(commNo);
	}

}
