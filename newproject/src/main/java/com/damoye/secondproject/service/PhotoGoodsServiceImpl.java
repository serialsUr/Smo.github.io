package com.damoye.secondproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.damoye.secondproject.dao.PhotoGoodsRepository;
import com.damoye.secondproject.model.GoodsVO;
import com.damoye.secondproject.model.ImageFileVO;

//goodsService인 Service Bean등록
//주입시키고자하는 곳에서는 @Autowired   GoodsService goodsService;
@Service("photoGoodsService")
public class PhotoGoodsServiceImpl implements PhotoGoodsService {

	 @Autowired   
	 PhotoGoodsRepository goodsRepository;
	 
	 
	 //--------------------------------------------
	//글등록- 첨부파일정보 포함
	//파라미턴 Map newArticleMap:글관련정보+첨부파일정보
	//리턴     입력된 글번호
	@Override
	public int addNewArticle(Map newArticleMap) throws Exception {

		//int article_id에는 article테이블에 지금 입력된 article테이블의 글번호
		int goods_id=goodsRepository.insertNewArticle(newArticleMap);
		
		//List<ImageFileVO> imageFileList에는 첨부파일정보
		List<ImageFileVO> imageFileList= (ArrayList)newArticleMap.get("imageFileList");
		for(ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setGoods_id(goods_id);
			System.out.println("서비스 for문안 imageFileVO="+imageFileVO);
		}
		goodsRepository.insertArticleImageFile(imageFileList);
		return goods_id;
	}
 
	/*상품분류별 목록조회 
    goods_status='bestseller' 또는 'steadyseller' 또는 'newbook' 등-->
 	<select id="selectGoodsList" 
 	리턴유형  Map<String,List<GoodsVO>> : 상품정보목록으로 구성된 Map   */
	@Override
	public Map<String,List<GoodsVO>> listGoods() throws Exception {
		Map<String,List<GoodsVO>> goodsMap = new HashMap();
		List<GoodsVO> goodList=goodsRepository.selectGoodsList("bestseller");
		goodsMap.put("bestseller",goodList);
		
		
		return goodsMap;
	}

	/*상품상세(+상품이미지목록) 조회 
	//파라미터 int goods_id: 상품id
	//리턴 Map-GoodsVO : 상품상세
	 *      -List : 상품이미지목록*/
	@Override
	public Map goodsDetail(int goods_id) throws Exception {
		
		Map<String,Object> goodsMap = new HashMap<String,Object>();
		
		//GoodsVO : 상품상세조회
		GoodsVO goodsVO = goodsRepository.selectGoodsDetail(goods_id);
		goodsMap.put("goodsVO", goodsVO);
		
		//List : 상품이미지목록조회
		List<ImageFileVO> imageList = goodsRepository.selectGoodsDetailImage(goods_id);
		System.out.println(goods_id+"별 이미지개수List.size()="+imageList.size());
		goodsMap.put("imageList",imageList);
		
		return goodsMap;
	}

	//검색키워드에 따른 조회
	//파라미터 String keyword : 검색키워드
	//리턴      List<String> : 책이름 목록
	@Override
	public List<String> keywordSearch(String keyword) throws Exception {
		return (ArrayList)goodsRepository.selectKeywordSearch(keyword);
	}

	//id찾기
	@Override
	public ImageFileVO selectimNo(String id) throws DataAccessException {
		return goodsRepository.selectimNo(id);
	}

	
}






