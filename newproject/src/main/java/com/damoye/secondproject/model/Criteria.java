package com.damoye.secondproject.model;

import org.springframework.stereotype.Repository;

@Repository
public class Criteria {
	private int pageNo; //현재페이지
	private int amount; //한페이지당 보여줄 게시글수
	private int skip; //스킵? (pageNo - 1) * amount 의 의미
	
	
	public Criteria() { //기본생성자 호출시 pageNo 1 한페이지당 글수 5개로 초기화
		this.pageNo = 1;
		this.amount = 10;
		this.skip = 0;
	}
	
	public Criteria(int pageNo, int amount) { //별도 호출시 값을 저장해서 뿌려줄 별도 파라미터 값 있는 생성자
		this.pageNo = pageNo;
		this.amount = amount;
		this.skip = (pageNo - 1) * amount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.skip = (pageNo - 1) * this.amount;
		this.pageNo = pageNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip = (this.pageNo - 1) * amount;
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	@Override
	public String toString() {
		return "Criteria [pageNo=" + pageNo + ", amount=" + amount + ", skip=" + skip + "]";
	}

	
	
	
}
