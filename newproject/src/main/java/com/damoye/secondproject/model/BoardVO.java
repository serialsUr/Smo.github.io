package com.damoye.secondproject.model;

import java.util.Date;

public class BoardVO {
	
	private int boardNo;
	private int cNo;
	private String bType;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private Date bRegdate;
	private Date bModdate;
	private int commCnt;
	private String bIsShow;
	
	
	public BoardVO() {
	}


	public BoardVO(int boardNo, int cNo, String bType, String bTitle, String bContent, String bWriter, Date bRegdate,
			Date bModdate, int commCnt, String bIsShow) {
		this.boardNo = boardNo;
		this.cNo = cNo;
		this.bType = bType;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.bRegdate = bRegdate;
		this.bModdate = bModdate;
		this.commCnt = commCnt;
		this.bIsShow = bIsShow;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public int getcNo() {
		return cNo;
	}

	public String getbType() {
		return bType;
	}

	public String getbTitle() {
		return bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public String getbWriter() {
		return bWriter;
	}

	public Date getbRegdate() {
		return bRegdate;
	}

	public Date getbModdate() {
		return bModdate;
	}

	public int getCommCnt() {
		return commCnt;
	}

	public String getbIsShow() {
		return bIsShow;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public void setbRegdate(Date bRegdate) {
		this.bRegdate = bRegdate;
	}

	public void setbModdate(Date bModdate) {
		this.bModdate = bModdate;
	}

	public void setCommCnt(int commCnt) {
		this.commCnt = commCnt;
	}

	public void setbIsShow(String bIsShow) {
		this.bIsShow = bIsShow;
	}



	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", cNo=" + cNo + ", bType=" + bType + ", bTitle=" + bTitle
				+ ", bContent=" + bContent + ", bWriter=" + bWriter + ", bRegdate=" + bRegdate + ", bModdate="
				+ bModdate + ", commCnt=" + commCnt + ", bIsShow=" + bIsShow + "]";
	}
	
	
	
	
}
