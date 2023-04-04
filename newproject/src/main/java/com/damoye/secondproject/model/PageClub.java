package com.damoye.secondproject.model;

import java.util.List;

//클럽페이징+검색 기능구현을 위한 DTO
public class PageClub {
	private int totalCount;//전체 글의 갯수
	private int totalPage;//전체 페이지의 수 
	private int perPage;//페이지당 글의 수 
	private int totalBlock;//전체 블럭의 수 
	private int perBlock;//페이지당 블럭의 수 
	private int curBlock;//현재 블럭 번호 
	private String kind;//게시판 테이블의 컬럼 kind
	private String search;//검색어 search
	private int startNum;//페이지 시작번호 startNum
	private int lastNum;//페이지 끝번호 lastNum
	private boolean lastCheck;//마지막 블럭 조사 lastCheck
	private int startRow;//첫 시작 행 startRow
	
}

