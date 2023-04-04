package com.damoye.secondproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubMemberDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	 @Override
    public List<BoardVO> getBoardList(int cNo) {
        return sqlSession.selectList("boardList", cNo);
    }
	
	 //클럽게시판 글 상세보기
	 @Override
	 public BoardVO getBoardDetail(int boardNo){
		 return sqlSession.selectOne("mapper.board.getBoardDetail",boardNo);
	 }
	 
	 //클럽게시판 글작성
	 @Override
	 public void insertBoard(BoardVO boardVO) {
		 int cnt = sqlSession.insert("mapper.board.insertBoard", boardVO);
		 System.out.println("cnt="+cnt);
		 
	 }
	
	 //클럽게시판 댓글카운트
	 @Override
	 public int count(int cNo) {
		 return sqlSession.selectOne("mapper.board.count", cNo);
	 }
	 
	 //클럽게시판 리스트+페이징
	 @Override
	 public List<BoardVO> getBoardListPage(int cNo, int displayPost, int postNum) {
		
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("cNo", cNo);
		data.put("displayPost", displayPost);
		data.put("postNum",postNum);
		
		return sqlSession.selectList("boardListPage", data);
	 }
	 
	 //클럽게시판 글수정
	 @Override
	 public int updateSubmitBoard(BoardVO boardVO) throws DataAccessException{
		int cnt=sqlSession.update("mapper.board.updateSubmitBoard", boardVO);
		System.out.println(cnt);
		return cnt;
	 }
	
	 //클럽게시판 글삭제(update)
	 @Override
	 public int deleteBoard(int cNo, int boardNo, BoardVO boardVO) {
		int cnt=sqlSession.update("mapper.board.deleteBoard", boardVO);
		System.out.println(cnt);
		return cnt;
	 }
	 
	 @Override
	 public ClubDTO getClubDTOByNo(int cNo) {
		 return sqlSession.selectOne("mapper.club.selClubDetail", cNo);
	 }
	 @Override
	 public int validClubMember(ClubMemberDTO clubMember) {
		return sqlSession.selectOne("mapper.club.clubJoinValid", clubMember);
	}
	
}
