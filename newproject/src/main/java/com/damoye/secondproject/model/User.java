package com.damoye.secondproject.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {

	private int no;
	@NotEmpty(message="아이디는 필수 입력입니다.")
	private String id;
	@NotEmpty(message="비밀번호는 필수 입력입니다.")
	private String password;
	@NotEmpty(message="이름은 필수 입력입니다.")
	private String name;
	@NotEmpty(message="우편번호는 필수 입력입니다.")
	private String zipcode;
	@NotEmpty(message="주소는 필수 입력입니다.")
	private String address;
	private String detailaddress;
	@NotEmpty(message="주민등록번호는 필수 입력입니다.")
	private String pricynum;
	@NotEmpty(message="이메일은 필수 입력입니다.")
	@Email(message="올바른 이메일 형식으로 작성해주십시오.")
	private String email;
	@NotEmpty(message="전화번호는 필수 입력입니다.")
	private String phonenum;
	@NotEmpty(message="성별은  필수 선택입니다.")
	private String gender;
	private int grade;
	private String regdate;

	
	public User() {}
	public User(int no, String id, String password, String name, String zipcode, String address, String detailaddress,
			String pricynum, String email, String phonenum, String gender, int grade, String regdate) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
		this.detailaddress = detailaddress;
		this.pricynum = pricynum;
		this.email = email;
		this.phonenum = phonenum;
		this.gender = gender;
		this.grade = grade;
		this.regdate = regdate;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public String getPricynum() {
		return pricynum;
	}
	public void setPricynum(String pricynum) {
		this.pricynum = pricynum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void changeMyInfo(String password, String email, String zipcode, String address, String detailaddress) {
		this.password = password;
		this.email = email;
		this.zipcode = zipcode;
		this.address = address;
		this.detailaddress = detailaddress;
	}
	
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	
	
	@Override
	public String toString() {
		return "User [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", zipcode=" + zipcode
				+ ", address=" + address + ", detailaddress=" + detailaddress + ", pricynum=" + pricynum + ", email="
				+ email + ", phonenum=" + phonenum + ", gender=" + gender + ", grade=" + grade + ", regdate=" + regdate + "]";
	}
	

}
