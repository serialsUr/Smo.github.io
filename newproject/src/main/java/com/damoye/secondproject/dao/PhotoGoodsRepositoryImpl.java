package com.damoye.secondproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.damoye.secondproject.model.GoodsVO;
import com.damoye.secondproject.model.ImageFileVO;

//id가 goodsRepository인 Bean등록
//주입시키고자하는 곳에서는 @Autowired   GoodsRepository goodsRepository;
@Repository("photoGoodsRepository")
public class PhotoGoodsRepositoryImpl implements PhotoGoodsRepository{

	@Autowired
	private SqlSession sqlSession;
	
	
	//---------------------------------
		//글등록- 첨부파일정보 포함
		//파라미터 Map newArticleMap:글관련정보
		//리턴      int 입력된 글번호
		@Override
		public int insertNewArticle(Map newArticleMap) throws DataAccessException {
			//sqlSession.insert("실행쿼리문id",파라미터);
			sqlSession.insert("mapper.goods.insertNewArticle",newArticleMap);
			return Integer.parseInt((String)newArticleMap.get("goods_id"));
		}

		//글등록- 첨부파일정보 포함
		@Override
		public void insertArticleImageFile(List<ImageFileVO> fileList) throws DataAccessException {
			//첨부파일의 수 만큼  insert문을 실행
			for(int i=0; i<fileList.size();i++){
				ImageFileVO imageFileVO=(ImageFileVO)fileList.get(i);
				sqlSession.insert("mapper.goods.insertArticleImageFile",imageFileVO);
			}
		}
	
	/*상품분류별 목록조회 
    goods_status='bestseller' 또는 'steadyseller' 또는 'newbook' 등-->
 	<select id="selectGoodsList" 
 	파라미터  String goodsStatus : 상품분류
 	리턴유형  List<GoodsVO> : 상품정보목록     */
	@Override
	public List<GoodsVO> selectGoodsList(String goodsStatus) throws DataAccessException {
		List<GoodsVO> goodList = (ArrayList)sqlSession.selectList("mapper.goods.selectGoodsList", goodsStatus);
		return goodList;
	}


	//상품상세 조회 
	//파라미터 int goods_id: 상품id
	//리턴 GoodsVO : 상품상세
	@Override
	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException {
		return (GoodsVO)sqlSession.selectOne("mapper.goods.selectGoodsDetail", goods_id);
	}

	//상품이미지목록조회 
	//파라미터 int goods_id: 상품id
	//리턴 List : 상품이미지목록*/
	@Override
	public List selectGoodsDetailImage(int goods_id) throws DataAccessException {
		return (List)sqlSession.selectList("mapper.goods.selectGoodsDetailImage", goods_id);
	}


	//검색키워드에 따른 조회
	//파라미터 String keyword : 검색키워드
	//리턴      List<String> : 책이름 목록
	@Override
	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
		List<String> list= (ArrayList)sqlSession.selectList("mapper.goods.selectKeywordSearch",keyword);
		return list;
	}

	//특정글의 id 조회
	@Override
	public ImageFileVO selectimNo(String id) throws DataAccessException {
		return sqlSession.selectOne("mapper.goods.selectimNo",id);
	}

	
}












