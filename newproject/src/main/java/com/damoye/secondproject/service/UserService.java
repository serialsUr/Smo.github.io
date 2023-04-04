package com.damoye.secondproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.damoye.secondproject.model.NoticeDTO;
import com.damoye.secondproject.model.User;


@Service
public interface UserService {

	// 회원등록처리
	public void signUpUser(User user) throws Exception;
	
	//회원 id활용
	public User getMemberById(String id);
	
	//회원 아이디 찾기
	public User findId(String name, String email, String phonenum);
	
	//임시 비밀번호 변경
	public User newPassword(User user, String id, String name, String email);
	
	//회원 개인정보 수정
	public void modifyUserInfo(String id, String password, String email, String phonenum, String zipcode, String address, String detailaddress);
	
	//valid
	public Map<String, String> validateHandling(Errors errors);
	
	//아이디 중복체크
	public Integer checkId(String id);
	
	//주민번호 중복 체크
	public int pricynumCheck(String pricynum);
	
	// 회원목록조회
	public List<User> getAllMemberList();
	

	public List<NoticeDTO> getNoticeList();
}
