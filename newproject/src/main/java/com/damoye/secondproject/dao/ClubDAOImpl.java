package com.damoye.secondproject.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.CategoryDTO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubListPage;
import com.damoye.secondproject.model.ClubMemberDTO;
import com.damoye.secondproject.model.User;


@Repository
public class ClubDAOImpl implements ClubDAO {

	//필드
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ClubDTO> getAllClubList(int pageNum) throws DataAccessException {
		
		List<ClubDTO> cList=sqlSession.selectList("mapper.club.allClubList", pageNum);
		return cList;
	}

	//특정 카테고리 조회
	@Override
	public String getSelCategoryName(int categoryNo) throws DataAccessException{
		String category= sqlSession.selectOne("mapper.club.selCategoryName",categoryNo);
		return category;
	}

	//클럽 목록 조회 selClubList
	@Override
	public List<ClubDTO> getSelClubList(int categoryNo,int pageNum) throws DataAccessException{
		Map map = new HashMap();
		map.put("categoryNo",categoryNo);
		map.put("pageNum",pageNum);
		return sqlSession.selectList("mapper.club.selClubList",map);
	}
	
	//검색
	@Override
	public List<ClubDTO> getSearchCName(ClubDTO clubDTO,int pageNum) throws DataAccessException {
		Map map = new HashMap();
		String cName = clubDTO.getcName();
		int categoryNo = clubDTO.getCategoryNo();
		map.put("cName",cName);
		map.put("categoryNo",categoryNo);
		map.put("pageNum",pageNum);
		List<ClubDTO> list = sqlSession.selectList("mapper.club.searchClub", map);
		return list;
	}
	
	//전체 검색
	@Override
	public List<ClubDTO> getAllSearchCName(ClubDTO clubDTO,int pageNum) throws DataAccessException {
		Map map = new HashMap();
		String cName = clubDTO.getcName();
		map.put("cName",cName);
		map.put("pageNum",pageNum);
		List<ClubDTO> list = sqlSession.selectList("mapper.club.allSearchClub", map);
		return list;
	}
	//클럽 상세보기-소개글
	@Override
	public ClubDTO getSelClubDetail(int cNo)throws DataAccessException{
		return (ClubDTO)sqlSession.selectOne("mapper.club.selClubDetail", cNo);
	}
	//클럽 상세보기-가입자수
	@Override
	public int getClubCount(int cNo) throws DataAccessException {
		return sqlSession.selectOne("mapper.club.clubCount", cNo);
	}
	//클럽 상세보기-모임글
	@Override
	public List<BoardVO> getSelBDetail(int cNo) throws DataAccessException {
		List<BoardVO> boardList = sqlSession.selectList("mapper.club.selBoardDetail", cNo);
		System.out.println("DAO"+boardList);//확인용
		return boardList;
	}
	
	//클럽 상세보기-클럽가입 아이디 리스트
	@Override
	public List<ClubMemberDTO> getSignMember(int cNo) throws DataAccessException {
		List<ClubMemberDTO> memberList=sqlSession.selectList("mapper.club.clubMemeber", cNo);
		return memberList;
	}
	//클럽 가입하기
	@Override
	public void getSignClub(ClubMemberDTO clubMemberDTO) throws DataAccessException {
		sqlSession.insert("mapper.club.signClub", clubMemberDTO);
	}
	//클럽 생성
	@Override
	public int getCreClub(ClubDTO clubDTO) throws DataAccessException{
		sqlSession.insert("mapper.club.createClub", clubDTO);
		return clubDTO.getcNo();
	}
	//클럽수정 updateClub
	@Override
	public int getUpdateClub(ClubDTO clubDTO) throws DataAccessException {
		int cnt=sqlSession.update("mapper.club.updateClub", clubDTO);
		System.out.println("수정성공시1"+cnt);
		return cnt;		
	}
	
	//클럽삭제
	@Override
	public int getDel(int cNo) throws DataAccessException {
		int cnt=sqlSession.delete("mapper.club.clubAdminDel", cNo);
		System.out.println("DAO"+cnt);
		return cnt;
	}

	//클럽 멤버 삭제
	@Override
	public int getMemberDel(int cMemberNo) throws DataAccessException {
		int cnt = sqlSession.delete("mapper.club.clubDelMember", cMemberNo);
		return cnt;
	}

	//클럽 토탈 
	@Override
	public int clubCount() throws DataAccessException {
		return sqlSession.selectOne("mapper.club.totalCnt");
	}
	//클럽 토탈 
	@Override
	public int categoryClubCount(int categoryNo) throws DataAccessException {
		return sqlSession.selectOne("mapper.club.categoryTotalCnt",categoryNo);
	}
	@Override
	public int searchTotalCnt(ClubDTO clubDTO) throws DataAccessException {
		String cName = clubDTO.getcName();
		return sqlSession.selectOne("mapper.club.searchTotalCnt",cName);
	}
	//클럽 토탈 
	@Override
	public int searchCategoryTotalCnt(ClubDTO clubDTO) throws DataAccessException {
		Map map = new HashMap();
		map.put("cName",clubDTO.getcName());
		map.put("categoryNo",clubDTO.getCategoryNo());
		return sqlSession.selectOne("mapper.club.searchCategoryTotalCnt",map);
	}

	
}
