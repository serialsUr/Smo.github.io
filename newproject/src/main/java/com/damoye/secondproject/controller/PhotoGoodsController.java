package com.damoye.secondproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.damoye.secondproject.service.PhotoGoodsService;


@Controller("goodsController")
public class PhotoGoodsController extends PhotoBaseController {

	//필드
	@Autowired   
	PhotoGoodsService goodsService;
	
	/*여기에서는 main.jsp에서 <a href="${conPath}/goods/goodsDetail?goods_id=${item.goods_id}">*/
	//상품상세조회
	//파라미터 goods_id : 상품id
	//리턴      Map goodsMap : 상품상세+상품이미지목록
	/*Map goodsMap : 상품상세+상품이미지목록 
	Map-GoodsVO : 상품상세
	   -List : 상품이미지목록
	goodsMap.put("goodsVO", goodsVO);
	List<ImageFileVO> imageList = goodsRepository.selectGoodsDetailImage(goods_id);
	goodsMap.put("imageList",imageList); */
	@GetMapping("/photo/goodsDetail")
	public String goodsDetail(int goods_id,Model model) throws Exception {
		//1.파라미터받기
		//2.비즈니스로직(핵심관심사항+공통관심사항)
		Map goodsMap = goodsService.goodsDetail(goods_id);
		System.out.println("goodsMap.get('goodsVO')="+goodsMap.get("goodsVO"));
		System.out.println("goodsMap.get('imageList')="+(ArrayList)goodsMap.get("imageList"));
		
		model.addAttribute("goodsMap", goodsMap);  //3.Model 
		return "/photo/goodsDetail";//4.view
		
	}
	
	//검색키워드에 따른 조회
/* 여기에서는  header.jsp문서에서
 * $.ajax({})이용하여 요청 
   url:"${conPath}/goods/keywordSearch",//요청url. 예) /board/boardList.do
	data:{keyword:value},//서버로 전송할 데이터. 예){name:"홍GD"}
	success:function(data,status,xhr){//정상응답후 호출되는 함수
		//data: 서버로부터 응답받은 내용
		//status: 응답코드 , /xhr: xhr헤더
		//서버로부터 응답받은 내용인 data변수값을  JSON으로 변환
	 let jsonInfo = JSON.parse(data);*/
	/*
	 * @RequestMapping(value="/goods/keywordSearch", method=RequestMethod.GET,
	 * produces="application/text;charset=utf8") public @ResponseBody String
	 * keywordSearch(@RequestParam("keyword") String keyword) throws Exception {
	 * 
	 * if(keyword==null || keyword.equals("")) return null;
	 * 
	 * //리턴 List<String> : 책이름 목록 List<String> keywordList =
	 * goodsService.keywordSearch(keyword);
	 * 
	 * //JSONObject객체생성 JSONObject jsonObject = new JSONObject();
	 * jsonObject.put("keyword",keywordList);
	 * 
	 * //JSONObject객체를 문자열로 변환 String jsonInfo = jsonObject.toString();
	 * 
	 * return jsonInfo; //클라이언트에게 응답 }
	 */
	
}//class끝





















