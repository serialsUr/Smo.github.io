package com.damoye.secondproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoye.secondproject.dao.NoticeDAO;
import com.damoye.secondproject.model.Criteria;
import com.damoye.secondproject.model.NoticeDTO;
import com.damoye.secondproject.model.NoticePaging;
import com.damoye.secondproject.model.User;
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDAO noticeDAOImpl;
	
	@Autowired
	Criteria cri;
	
	
	@Override
	public List<NoticeDTO> getNoticeList(Criteria cri) {
		List<NoticeDTO> noticeList = noticeDAOImpl.getNoticeList(cri);
		return noticeList;
	}

	//공지사항 글 작성
	@Override
	public int noticeInsert(NoticeDTO noticeDTO) {
		return noticeDAOImpl.noticeInsert(noticeDTO);
	}

	@Override
	public NoticeDTO getDetailNotice(int no) {
		return noticeDAOImpl.getDetailNotice(no);
	}
	
	//공지사항 글 수정
	@Override
	public int updateNotice(NoticeDTO noticeDTO) {
		return noticeDAOImpl.updateNotice(noticeDTO);
	}
	
	//공지사항 글 삭제
	@Override
	public int deleteNotice(int no) {
		return noticeDAOImpl.deleteNotice(no);
	}
	
	//공지사항 조회수 증가
	@Override
	public int updateReadCount(int no) {
		return noticeDAOImpl.updateReadCount(no);
	}
	
	//공지사항 전체게시글 수
	@Override
	public int selectAllCount() {
		return noticeDAOImpl.selectAllCount();
	}
	
	//유저 전체 리스트
	@Override
	public List<User> allUserList() {
		return noticeDAOImpl.allUserList();
	}

}
