package com.damoye.secondproject.model;

import java.sql.Date;

public class CommBoardVO {
	
	private int commNo;
	private String comment;
	private String commId;
	private Date commRegdate;
	private Date commModdate;
	private String commIsShow;
	private int boardNo;
	
	
	public CommBoardVO() {
	}

	public CommBoardVO(int commNo, String comment, String commId, Date commRegdate, Date commModdate, String commIsShow, int boardNo) {
		this.commNo = commNo;
		this.comment = comment;
		this.commId = commId;
		this.commRegdate = commRegdate;
		this.commModdate = commModdate;
		this.commIsShow = commIsShow;
		this.boardNo = boardNo;
	}



	public int getCommNo() {
		return commNo;
	}

	public String getComment() {
		return comment;
	}

	public String getCommId() {
		return commId;
	}

	public Date getCommRegdate() {
		return commRegdate;
	}

	public Date getCommModdate() {
		return commModdate;
	}

	public String getCommIsShow() {
		return commIsShow;
	}

	public int getBoardNo() {
		return boardNo;
	}

	
	public void setCommNo(int commNo) {
		this.commNo = commNo;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCommId(String commId) {
		this.commId = commId;
	}

	public void setCommRegdate(Date commRegdate) {
		this.commRegdate = commRegdate;
	}

	public void setCommModdate(Date commModdate) {
		this.commModdate = commModdate;
	}

	public void setCommIsShow(String commIsShow) {
		this.commIsShow = commIsShow;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "CommBoardVo [commNo=" + commNo + ", comment=" + comment + ", commId=" + commId + ", commRegdate="
				+ commRegdate + ", commModdate=" + commModdate + ", commIsShow=" + commIsShow + ", boardNo=" + boardNo
				+ "]";
	}

	
}
