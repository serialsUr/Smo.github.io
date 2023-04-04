package com.damoye.secondproject.model;

import java.util.List;

public class ClubListPage {

	private int total;
	private int currentPage;
	private List<ClubDTO> clubDTO;
	private int totalPage;
	private int startPage;
	private int endPage;
	public ClubListPage() {}
	public ClubListPage(int total, int currentPage, int size,List<ClubDTO> clubDTO) {
		this.total = total;
		this.currentPage = currentPage;
		this.clubDTO = clubDTO;
		if(total ==0) {
			totalPage = 0;
			startPage = 0;
			endPage = 0;
		}else {
			totalPage = total/size;
			if(total%size>0) {
				totalPage++;
			}
			int ModVal = currentPage %5;
			startPage = currentPage/5*5+1;
			if(ModVal == 0) {
				startPage -=5;
			}
			endPage = startPage+4;
			if(endPage>totalPage) {
				endPage = totalPage;
			}
		}
	}
	
	
	public void setTotal(int total) {
		this.total = total;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setClubDTO(List<ClubDTO> clubDTO) {
		this.clubDTO = clubDTO;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getTotal() {
		return total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public List<ClubDTO> getClubDTO() {
		return clubDTO;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public boolean hasNoClub() {
		return total ==0;
	}
	public boolean hasClub() {
		return total >0;
	}
	
}
