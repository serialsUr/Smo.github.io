package com.damoye.secondproject.model;

import java.util.List;

public class BoardPage {

	//필드
	private int categoryNo;
	
	//클럽구분용(클럽번호)
	private int cNo;
	
	// 현재 페이지 번호
	private int num;

	// 게시물 총 갯수
	private int count;

	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 10;

	// 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
	private int pageNum;

	// 출력할 게시물
	private int displayPost;

	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt =5;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;

	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;
	
	
	
	
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getcNo() {
		return cNo;
	}
	
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public int getNum() {
		return num;
	}
	
	public int getCount() {
		return count;
	}
	public int getPostNum() {
		return postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setCount(int count) {
		this.count = count;
		
		dataCalc();
	}

	private void dataCalc() {
		
		
		/*if(endPageNum-endPageNum==0) {
			next=false;
		}*/
		if(endPageNum>pageNum) {
			next=false;
		}
		
		if(endPageNum-postNum==0) {
			next=false;
		}
		
		if(count!=0) {
		// 마지막 번호
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		
		// 시작 번호
		startPageNum = endPageNum - (pageNumCnt - 1);
		
		// 마지막 번호 재계산
		/*
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		*/
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		
		displayPost = (num-1) * postNum;
		
		//하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
		pageNum = (int)Math.ceil((double)count/postNum);
		if(endPageNum > pageNum) {
			endPageNum = pageNum;
		}
		
		}

	
	}
	

	@Override
	public String toString() {
		return "BoardPage [cNo=" + cNo + ", num=" + num + ", count=" + count + ", postNum=" + postNum
				+ ", pageNum=" + pageNum + ", displayPost=" + displayPost + ", pageNumCnt=" + pageNumCnt
				+ ", endPageNum=" + endPageNum + ", startPageNum=" + startPageNum + ", prev=" + prev + ", next=" + next
				+ "]";
	}
	
	
	
	
	
		
}
