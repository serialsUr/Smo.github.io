package com.damoye.secondproject.service;

import java.util.List;

import com.damoye.secondproject.model.Criteria;
import com.damoye.secondproject.model.NoticeDTO;
import com.damoye.secondproject.model.User;

public interface NoticeService {
	
	
	//공지사항 게시글 리스트
	public List<NoticeDTO> getNoticeList(Criteria cri);
	
	//공지사항 글작성
	public int noticeInsert(NoticeDTO noticeDTO);

	public NoticeDTO getDetailNotice(int no);
	
	//공지사항 글 수정
	public int updateNotice(NoticeDTO noticeDTO);
	
	//공지사항 글 삭제
	public int deleteNotice(int no);
	
	//공지사항 조회수 증가
	public int updateReadCount(int no);
	
	//공지사항 전체게시글 수 조회
	public int selectAllCount();
	
	//유저 전체 리스트	
	public List<User> allUserList();
	
}
