package com.damoye.secondproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.CommBoardVO;

@Repository
public class CommboardDAOImpl implements CommboardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CommBoardVO> list(int boardNo) throws Exception {
		return sqlSession.selectList("mapper.comm.commList", boardNo);
	}

	@Override
	public void insertCommBoard(CommBoardVO commBoardVO) throws Exception {
		int cnt = sqlSession.insert("mapper.comm.insertCommBoard", commBoardVO);
		System.out.println("cnt="+cnt);
	}
	
	//댓글선택
	@Override
	public CommBoardVO selectComm(CommBoardVO commBoardVO) throws Exception {
		return sqlSession.selectOne("mapper.comm.selectComm", commBoardVO);
	}
	
	@Override
	public int updateSubmitComm(CommBoardVO commBoardVO) throws Exception {
		int cnt = sqlSession.update("mapper.comm.updateComm", commBoardVO);
		System.out.println(cnt);
		return cnt;
	}

	@Override
	public int deleteComm(int commNo) throws Exception {
		int cnt=sqlSession.update("mapper.comm.deleteComm", commNo);
		return cnt;
	}
	
	

}
