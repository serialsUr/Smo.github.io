package com.damoye.secondproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.damoye.secondproject.model.GoodsVO;
import com.damoye.secondproject.model.ImageFileVO;

public interface PhotoGoodsService {
	
	//----------------------------------
	//글등록- 첨부파일정보 포함
	//파라미턴 Map newArticleMap:글관련정보+첨부파일정보
	public int addNewArticle(Map newArticleMap) throws Exception;

	//특정글의 id 조회
		public ImageFileVO selectimNo(String id)  throws DataAccessException;
		
	
	/*상품분류별 목록조회 
 	리턴유형  Map<String,List<GoodsVO>> : 상품정보목록으로 구성된 Map   */
	public Map<String,List<GoodsVO>> listGoods() throws Exception;
	
	/*상품상세(+상품이미지목록) 조회 
	//파라미터 int goods_id: 상품id
	//리턴 Map-GoodsVO : 상품상세
	 *      -List : 상품이미지목록*/
	public Map goodsDetail(int goods_id) throws Exception;

	//검색키워드에 따른 조회
	//파라미터 String keyword : 검색키워드
	//리턴      List<String> : 책이름 목록
	public List<String> keywordSearch(String keyword) throws Exception;
	
}








