package com.damoye.secondproject.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.damoye.secondproject.model.GoodsVO;
import com.damoye.secondproject.model.ImageFileVO;

//상품(goods)테이블과 상품이미지테이블(goods_detail_image)관련 작업
public interface PhotoGoodsRepository {

	
	//글등록- 첨부파일정보 포함
		//파라미터 Map newArticleMap:글관련정보
		public int insertNewArticle(Map newArticleMap) throws DataAccessException;
		//파라미터 List<ImageFileVO> fileList:첨부파일정보
		public void insertArticleImageFile(List<ImageFileVO> fileList) throws DataAccessException;
		
	/*상품분류별 목록조회 
    goods_statu='bestseller' 또는 'steadyseller' 또는 'newbook' 등-->
 	<select id="selectGoodsList" 
 	파라미터  String goodsStatus : 상품분류
 	리턴유형  List<GoodsVO> : 상품정보목록     */
	public List<GoodsVO> selectGoodsList(String goodsStatus) throws DataAccessException;
	
	//특정글의 id 조회
	public ImageFileVO selectimNo(String id)  throws DataAccessException;
	
	//상품상세 조회 
	//파라미터 int goods_id: 상품id
	//리턴 GoodsVO : 상품상세
	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException;

	//상품이미지목록조회 
	//파라미터 int goods_id: 상품id
	//리턴 List : 상품이미지목록*/
	public List selectGoodsDetailImage(int goods_id) throws DataAccessException;
	
	//검색키워드에 따른 조회
	//파라미터 String keyword : 검색키워드
	//리턴      List<String> : 책이름 목록
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException;
}












