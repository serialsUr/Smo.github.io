package com.damoye.secondproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.Criteria;
import com.damoye.secondproject.model.NoticeDTO;
import com.damoye.secondproject.model.NoticePaging;
import com.damoye.secondproject.model.User;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//공지사항 게시글 전체 리스트
	@Override
	public List<NoticeDTO> getNoticeList(Criteria cri) {
		List<NoticeDTO> noticeList = sqlSession.selectList("mapper.notice.noticeList", cri);
		System.out.println("noticeList"+noticeList);
		return noticeList;
	}
	
	//공지사항 글작성
	@Override
	public int noticeInsert(NoticeDTO noticeDTO) {
		return sqlSession.insert("mapper.notice.noticeInsert",noticeDTO);
	}

	@Override
	public NoticeDTO getDetailNotice(int no) {
		return sqlSession.selectOne("mapper.notice.getDetailNotice", no);
	}

	//공지사항 글 수정
	@Override
	public int updateNotice(NoticeDTO noticeDTO) {
		return sqlSession.update("mapper.notice.updateNotice", noticeDTO);
	}

	//공지사항 글 삭제
	@Override
	public int deleteNotice(int no) {
		return sqlSession.delete("mapper.notice.deleteNotice",no);
	}
	
	//공지사항 조회수 증가
	@Override
	public int updateReadCount(int no) {
		return sqlSession.update("mapper.notice.updateReadCount", no);
	}
	
	//공지사항 전체 글 수 조회
	@Override
	public int selectAllCount() {
		return sqlSession.selectOne("mapper.notice.totalcnt");
	}

	@Override
	public List<User> allUserList() {
		return sqlSession.selectList("mapper.notice.userAllList");
	}


}
