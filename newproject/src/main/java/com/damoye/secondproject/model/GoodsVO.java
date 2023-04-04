package com.damoye.secondproject.model;

import java.util.Date;

//상품(goods)테이블 관련 데이터바인딩용 객체
public class GoodsVO {
	

	private int    goods_id;		//goods_id컬럼
	private String goods_title;		//제목
	private String goods_content; //내용
	private Date   credate;  //등록일
	private	 String fileName;//이미지 
	private String id;
			
			
	public GoodsVO() {}


	public GoodsVO(String id,int goods_id, String goods_title, String goods_content, Date credate, String fileName) {
		this.goods_id = goods_id;
		this.goods_title = goods_title;
		this.goods_content = goods_content;
		this.credate = credate;
		this.fileName = fileName;
		this.id = id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGoods_id() {
		return goods_id;
	}


	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}


	public String getGoods_title() {
		return goods_title;
	}


	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}


	public String getGoods_content() {
		return goods_content;
	}


	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}


	public Date getCredate() {
		return credate;
	}


	public void setCredate(Date credate) {
		this.credate = credate;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "GoodsVO [goods_id=" + goods_id + ", goods_title=" + goods_title + ", goods_content=" + goods_content
				+ ", credate=" + credate + ", fileName=" + fileName + "]";
	}
	
	

	}