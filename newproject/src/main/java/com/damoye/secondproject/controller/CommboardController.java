package com.damoye.secondproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.CommBoardVO;
import com.damoye.secondproject.service.CommboardService;

@Controller
public class CommboardController {
	
	@Autowired
	public CommboardService commboardServiceImpl;
	
	//댓글등록
	@PostMapping("/comm")
	public String insertCommBoard(Model model, int cNo, int num, int boardNo, @ModelAttribute CommBoardVO commBoardVO, HttpServletRequest request) throws Exception{
		commboardServiceImpl.insertCommBoard(commBoardVO);
		model.addAttribute("cNo", cNo);
		model.addAttribute("num", num);
		model.addAttribute("boardNo", boardNo);
		return "redirect:/board/detail";
		
	}
	
	//댓글수정
	//댓글수정폼
	@GetMapping("/comm/updateComm")
	public String updateComm(Model model,int boardNo, int commNo,CommBoardVO commBoardVO) throws Exception{
		//commBoardVO.setBoardNo(boardNo);
		//commBoardVO.setCommNo(commNo);
		CommBoardVO comm = commboardServiceImpl.selectComm(commBoardVO);
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("comm", comm);
		return "comm/updateComm";
	}
	
	//수정입력
	@PostMapping("/comm/updateComm")
	public String updateSubmitComm(Model model,int boardNo, int commNo,CommBoardVO commBoardVO,BoardVO boardVO) throws Exception{
		System.out.println("댓글수정");
		commBoardVO.setBoardNo(boardNo);
		commBoardVO.setCommNo(commNo);
		commboardServiceImpl.updateSubmitComm(commBoardVO);
		return "redirect:/board/detail?cNo="+boardVO.getcNo()+"&boardNo="+boardVO.getBoardNo()+"&num=1";
	}
	
	//댓글삭제
	@GetMapping(value="/comm/deleteComm")
	public ModelAndView deleteComm(int commNo, ModelAndView mv,CommBoardVO commBoardVO,BoardVO boardVO) throws Exception {
		System.out.println(boardVO);
		commBoardVO.setCommNo(commNo);
		//commBoardVO.setBoardNo(boardNo);
		commboardServiceImpl.deleteComm(commNo);
		
		mv.setViewName("redirect:/board/detail?cNo="+boardVO.getcNo()+"&boardNo="+boardVO.getBoardNo()+"&num=1");
		return mv;
		
	}
}
