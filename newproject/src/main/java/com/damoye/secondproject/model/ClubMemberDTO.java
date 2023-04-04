package com.damoye.secondproject.model;

import java.util.Date;

//클럽구성원DTO
public class ClubMemberDTO {
	private int cMemberNo; //클럽에 가입한 회원번호
	private int cNo; //클럽번호
	private int no; //회원번호
	private Date joinDate; //클럽 가입일
	private String signIn; //가입여부
	
	private String id;// 회원아이디
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public ClubMemberDTO() {}
	public ClubMemberDTO(int cMemberNo, int cNo, int no, Date joinDate, String signIn) {
		this.cMemberNo = cMemberNo;
		this.cNo = cNo;
		this.no = no;
		this.joinDate = joinDate;
		this.signIn = signIn;
	}
	public int getcMemberNo() {
		return cMemberNo;
	}
	public void setcMemberNo(int cMemberNo) {
		this.cMemberNo = cMemberNo;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getSignIn() {
		return signIn;
	}
	public String setSignIn(String signIn) {
		return this.signIn = signIn;
	}
	@Override
	public String toString() {
		return "ClubMemberDTO [cMemberNo=" + cMemberNo + ", cNo=" + cNo + ", no=" + no + ", joinDate=" + joinDate
				+ ", signIn=" + signIn + "]";
	}
	
	
	

}
