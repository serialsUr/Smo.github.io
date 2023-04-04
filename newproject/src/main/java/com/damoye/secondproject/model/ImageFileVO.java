package com.damoye.secondproject.model;

import java.util.Date;

//상품이미지테이블(goods_detail_image) 관련 데이터바인딩용 객체
public class ImageFileVO {
	private int goods_id; 
	private int image_id;
	private String fileName;
	private String fileType;
	private String id;
	private Date creDate;
	
	public ImageFileVO() {
	}
	
	public ImageFileVO(int goods_id, int image_id, String fileName, String fileType, String id, Date creDate) {
		this.goods_id = goods_id;
		this.image_id = image_id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.id = id;
		this.creDate = creDate;
	}



	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	@Override
	public String toString() {
		return "ImageFileVO [goods_id=" + goods_id + ", image_id=" + image_id + ", fileName=" + fileName + ", fileType="
				+ fileType + ", id=" + id + ", creDate=" + creDate + "]";
	}
	
	
	
}
