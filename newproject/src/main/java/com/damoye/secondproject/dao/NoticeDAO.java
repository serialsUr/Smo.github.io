package com.damoye.secondproject.dao;

import java.util.List;

import com.damoye.secondproject.model.Criteria;
import com.damoye.secondproject.model.NoticeDTO;
import com.damoye.secondproject.model.NoticePaging;
import com.damoye.secondproject.model.User;

public interface NoticeDAO {
	
	//공지사항 글 리스트(페이징)
	public List<NoticeDTO> getNoticeList(Criteria cri);
	
	//공지사항 글작성
	public int noticeInsert(NoticeDTO noticeDTO);
	
	//공지사항 해당 글 상세보기
	public NoticeDTO getDetailNotice(int no);

	//공지사항 글 수정
	public int updateNotice(NoticeDTO noticeDTO);
	
	//공지사항 글 삭제
	public int deleteNotice(int no);
	
	//공지사항 조회수 증가
	public int updateReadCount(int no);
	
	//공지사항 전체 글 수 조회
	public int selectAllCount();
	
	//유저 전체 리스트
	public List<User> allUserList();
	
	
}
