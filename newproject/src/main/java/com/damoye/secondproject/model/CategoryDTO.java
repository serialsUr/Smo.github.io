package com.damoye.secondproject.model;

//카테고리 관련 DTO
public class CategoryDTO {
	private int categoryNo; //카테고리번호
	private String categoryName; //카테고리이름
	public CategoryDTO() {}
	public CategoryDTO(int categoryNo, String categoryName) {
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryDTO [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	

}
