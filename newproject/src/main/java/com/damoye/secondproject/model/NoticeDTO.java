package com.damoye.secondproject.model;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDTO {
	private int no;
	private String title;
	private String content;
	private String writername;
	private Date regdate;
	private Date modidate;
	private int readcnt;
	
	public NoticeDTO() {
		
	}
	
		
	public NoticeDTO(int no, String title, String content, String writername, Date regdate, Date modidate,
			int readcnt) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writername = writername;
		this.regdate = regdate;
		this.modidate = modidate;
		this.readcnt = readcnt;
	}




	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritername() {
		return writername;
	}
	public void setWritername(String writername) {
		this.writername = writername;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", writername=" + writername
				+ ", regdate=" + regdate + ", modidate=" + modidate + ", readcnt=" + readcnt + "]";
	}
	
	
	
}
