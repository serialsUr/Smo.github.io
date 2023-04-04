package com.damoye.secondproject.model;

import java.util.Date;

//클럽관련 DTO
public class ClubDTO {
	private int cNo; //클럽번호
	private String cName; //클럽명
	private String cIntro; //클럽소개글
	private String masterId; //클럽장아이디
	private String cLoc; //클럽활동지역
	private Date creDate; //클럽생성일
	private int cPeople; //클립인원수 10, 30, 50, 100 선택
	private String cIsShow; //노출여부 Y | N
	private int categoryNo; //카테고리번호
	
	
	private String searchCName; //검색어

	public ClubDTO(int cNo, String cName, String cIntro, String masterId, String cLoc, Date creDate, int cPeople,
			String cIsShow, int categoryNo, String searchCName) {
		this.cNo = cNo;
		this.cName = cName;
		this.cIntro = cIntro;
		this.masterId = masterId;
		this.cLoc = cLoc;
		this.creDate = creDate;
		this.cPeople = cPeople;
		this.cIsShow = cIsShow;
		this.categoryNo = categoryNo;
		this.searchCName = searchCName;
	}
	
	
	public String getSearchCName() {
		return searchCName;
	}


	public void setSearchCName(String searchCName) {
		this.searchCName = searchCName;
	}


	public ClubDTO() {}
	public ClubDTO(int cNo, String cName, String cIntro, String masterId, String cLoc, Date creDate, int cPeople,
			String cIsShow, int categoryNo) {
		this.cNo = cNo;
		this.cName = cName;
		this.cIntro = cIntro;
		this.masterId = masterId;
		this.cLoc = cLoc;
		this.creDate = creDate;
		this.cPeople = cPeople;
		this.cIsShow = cIsShow;
		this.categoryNo = categoryNo;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcIntro() {
		return cIntro;
	}
	public void setcIntro(String cIntro) {
		this.cIntro = cIntro;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getcLoc() {
		return cLoc;
	}
	public void setcLoc(String cLoc) {
		this.cLoc = cLoc;
	}
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
	public int getcPeople() {
		return cPeople;
	}
	public void setcPeople(int cPeople) {
		this.cPeople = cPeople;
	}
	public String getcIsShow() {
		return cIsShow;
	}
	public void setcIsShow(String cIsShow) {
		this.cIsShow = cIsShow;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "ClubDTO [cNo=" + cNo + ", cName=" + cName + ", cIntro=" + cIntro + ", masterId=" + masterId + ", cLoc="
				+ cLoc + ", creDate=" + creDate + ", cPeople=" + cPeople + ", cIsShow=" + cIsShow + ", categoryNo="
				+ categoryNo + ", searchCName=" + searchCName + "]";
	}
	

}
