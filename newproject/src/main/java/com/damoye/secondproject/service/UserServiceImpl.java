package com.damoye.secondproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.damoye.secondproject.dao.UserDAO;
import com.damoye.secondproject.model.Criteria;
import com.damoye.secondproject.model.NoticeDTO;
import com.damoye.secondproject.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	// 회원등록
	@Override
	public void signUpUser(User user) throws Exception {

		//회원가입
		userDAO.signUpUser(user);
	}

	@Override
	public User getMemberById(String id) {
		
		User user = userDAO.getMemberById(id);
		
		return user;
	}

	@Override
	public User findId(String name, String email, String phonenum) {
		
		User user = userDAO.findId(name, email, phonenum);
		
		return user;
	}
	
	@Override
	public User newPassword(User user, String id, String name, String email) {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        String newPwd = str;
		
		user = userDAO.getMemberByInfo(id, name, email);
		
		user.changePassword(newPwd);
		userDAO.updatePw(user);
		return user;
	}
	
	@Override
	public void modifyUserInfo(String id, String password, String email, String phonenum, String zipcode, String address, String detailaddress) {
		User user = null;
		user = userDAO.getMemberById(id);
		user.changeMyInfo(password, email, zipcode, address, detailaddress);
		userDAO.modifyUserInfo(user);
	}
	
	public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<String, String>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

	@Override
	public Integer checkId(String id) {
		System.out.println("Service");
        int result = 0;
        
        result = userDAO.checkId(id);
        return result;
    }
	
	@Override
	public int pricynumCheck(String pricynum) {
		int cnt = userDAO.pricynumCheck(pricynum);
		System.out.println("cnt: " + cnt);
		return cnt;
	}	

	
	@Override
	public List<User> getAllMemberList() {

		List<User> memberList = userDAO.getAllMemberList();
		
		return memberList;
	}
	
	@Override
	public List<NoticeDTO> getNoticeList() {
		List<NoticeDTO> noticeList = userDAO.getNoticeList();
		return noticeList;
	}

}
