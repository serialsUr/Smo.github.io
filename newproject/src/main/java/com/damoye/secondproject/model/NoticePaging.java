package com.damoye.secondproject.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoticePaging {
	private int total; //전체 게시글수
	private boolean prev, next; //이전 다음버튼 
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	private Criteria cri;   
	
	public NoticePaging() {
	}
	
	public NoticePaging(Criteria cri, int total) {
		this.endPage = (int) (Math.ceil(cri.getPageNo()/10.0))*10;
		this.startPage = this.endPage - 9;
		
		//전체 마지막 페이지
		int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "NoticePaging [total=" + total + ", prev=" + prev + ", next=" + next + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", cri=" + cri + "]";
	}
	
	
	
	
	
	
}
