package com.damoye.secondproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.damoye.secondproject.model.BoardVO;
import com.damoye.secondproject.model.ClubDTO;
import com.damoye.secondproject.model.ClubListPage;
import com.damoye.secondproject.model.ClubMemberDTO;
import com.damoye.secondproject.model.User;
import com.damoye.secondproject.service.ClubService;

@Controller
@RequestMapping("/club/")
public class ClubController {
	private static final Logger logger = LoggerFactory.getLogger(ClubController.class);

	@Autowired
	private ClubService clubService;

	//전체 카테고리의 모임 출력 
	@GetMapping("allClubList")
	public String getAllClub(Model model,HttpServletRequest req) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		ClubListPage clubList = clubService.getAllClubList(pageNo);
		model.addAttribute("clubList", clubList);		
		return "club/allClubList";		
	}
	
	//클럽리스트
	@GetMapping("clist")
	public String getSelClub(@RequestParam int categoryNo,HttpServletRequest req, Model model) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		//특정 카테고리명 조회 selCategoryName
		String cateogryName=clubService.getSelCategoryName(categoryNo);
		model.addAttribute("category", cateogryName);
		model.addAttribute("categoryNo", categoryNo);
	
		//클럽 조회
		ClubListPage clubList = clubService.getSelClubList(categoryNo,pageNo);
		logger.info(clubList.toString());//확인용
		model.addAttribute("clubList", clubList);		
		return "club/clubList";		
	}
	
	//클럽 검색 /club/searchClist
	@GetMapping("searchCName")
	public ModelAndView searchCName(@RequestParam int pageNo,@RequestParam int categoryNo,@RequestParam String searchCName, ModelAndView mv,HttpServletRequest req) throws Exception {
		
		ClubDTO clubDTO = new ClubDTO();
		clubDTO.setcName(searchCName);
		clubDTO.setCategoryNo(categoryNo);
		
		ClubListPage clubList = clubService.getSearchCName(clubDTO,pageNo);
		
		logger.info(clubList.toString());//확인용
		mv.addObject("clubList", clubList);
		mv.addObject("categoryNo", categoryNo);
		mv.setViewName("club/clubList");		
		return mv;
	}
	//클럽 검색 /club/searchClist
		@GetMapping("/allSearchCName")
		public ModelAndView allSearchCName(@RequestParam int pageNo,@RequestParam String searchCName, ModelAndView mv) throws Exception {
			
			ClubDTO clubDTO = new ClubDTO();
			clubDTO.setcName(searchCName);
			ClubListPage clubList = clubService.getAllSearchCName(clubDTO,pageNo);
			
			logger.info(clubList.toString());//확인용
			mv.addObject("clubList", clubList);
			mv.setViewName("club/allClubList");		
			return mv;
		}
	
	//클럽상세보기 
	@GetMapping("detail")
	public String getClubDetail(HttpSession session, int categoryNo,int cNo, Model model) throws Exception {
		User user = (User)session.getAttribute("loginUser");
		model.addAttribute("loginUser", user);
		//카테고리명
		String category=clubService.getSelCategoryName(categoryNo);
		model.addAttribute("category", category);
		model.addAttribute("categoryNo", categoryNo);
		//클럽 소개글-selClubDetail
		ClubDTO clubDTO = clubService.getSelClubDetail(cNo);
		model.addAttribute("clubDTO", clubDTO);
		//클럽 가입자 수 clubCount
		int clubSign=clubService.getClubCount(cNo);
		model.addAttribute("sPeople", clubSign);		
		//클럽 모임글 selBoardDetail
		List<BoardVO> boardList=clubService.getSelBDetail(cNo);
		model.addAttribute("boardVO", boardList);
		//클럽가입한 회원 정보 리스트
		ClubMemberDTO currentMember = null;
		List<ClubMemberDTO> signMemberList=clubService.getSignMember(cNo);
		model.addAttribute("signMemberList", signMemberList);	
		
		for(ClubMemberDTO clubmbmer : signMemberList) {
			if(user.getNo() == clubmbmer.getNo()) { //로그인한 회원번호 == 클럽에 가입한 기존 회원번호
				currentMember = clubmbmer;
			}else if(user.getGrade()== 999) {
				currentMember = clubmbmer;
			}
			break;
		}

		model.addAttribute("currentMember", currentMember); //클럽에 가입한 회원 상세정보
		return "club/clubDetail";
		
	}
	
	//클럽 가입하기-signClub
	@GetMapping("sign")
	public String getInSignClub(HttpServletRequest request, int cNo,ClubMemberDTO clubMemberDTO, Model model, int categoryNo) throws Exception {

		ClubDTO clubDTO = new ClubDTO();
		clubDTO.setcNo(cNo);
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("loginUser");
		model.addAttribute("cNo", cNo);
		model.addAttribute("loginUser",user);
		//-------------------------------------		
		clubDTO.setCategoryNo(categoryNo);
		model.addAttribute("categoryNo", categoryNo);

		return "club/clubSignForm";		
	}
	@PostMapping("sign")
	public String getInSignClubFrm(HttpServletRequest request,ClubMemberDTO clubMemberDTO, int cNo, Model model, int categoryNo) throws Exception {
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("loginUser");
		model.addAttribute("loginUser", user);
		ClubDTO club = new ClubDTO();
		club.setcNo(cNo);
		model.addAttribute("cNo", cNo);
		clubService.getSignClub(clubMemberDTO);	
		model.addAttribute("clubMemberDTO", clubMemberDTO);
		//---------------
		//카테고리명
		String category=clubService.getSelCategoryName(categoryNo);
		model.addAttribute("category", category);
		//클럽 소개글-selClubDetail
		ClubDTO clubDTO = clubService.getSelClubDetail(cNo);
		model.addAttribute("clubDTO", clubDTO);
		//클럽 가입자 수 clubCount
		int clubSign=clubService.getClubCount(cNo);
		model.addAttribute("sPeople", clubSign);		
		//클럽 모임글 selBoardDetail
		List<BoardVO> board=clubService.getSelBDetail(cNo);
		model.addAttribute("boardVO", board);
		//클럽가입한 회원 정보 리스트
		ClubMemberDTO currentMember = null;
		List<ClubMemberDTO> signMemberList=clubService.getSignMember(cNo);
		model.addAttribute("signMemberList", signMemberList);	
		
		for(ClubMemberDTO clubmbmer : signMemberList) {
			if(user.getNo() == clubmbmer.getNo()) { //로그인한 회원번호 == 클럽에 가입한 기존 회원번호
				currentMember = clubmbmer;
			}else if(user.getGrade()== 999) {
				currentMember = clubmbmer;
				break;
			}
		}
		
		model.addAttribute("currentMember", currentMember); //클럽에 가입한 회원 상세정보	

		return "club/clubDetail";
	}
	//클럽 생성하기-폼요청
	@GetMapping("clubCre")
	public String getInClub(HttpServletRequest request, Model model) throws Exception {
		ClubDTO clubDTO = new ClubDTO();
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("loginUser");
		model.addAttribute("loginUser",user);
		
		return "club/clubCreate";		
	}	
	//클럽 생성하기-처리요청
	@PostMapping("clubCre")
	public ModelAndView getInClubFrm(HttpSession session , ClubDTO clubDTO, ModelAndView mv) throws Exception {		
		logger.info(clubDTO.toString()); //확인용
		int cNo=clubService.getCreClub(clubDTO);
		User user = (User)session.getAttribute("loginUser");
		int userNo = user.getNo();
		ClubMemberDTO clubMemberDTO = new ClubMemberDTO();
		clubMemberDTO.setcNo(cNo);
		clubMemberDTO.setNo(userNo);
		clubService.getSignClub(clubMemberDTO);	
		
		if(cNo!=0) {
			ClubDTO club = clubService.getSelClubDetail(cNo);
			int categoryNo = club.getCategoryNo();
			
			System.out.println(categoryNo);
			
			mv.addObject("cNo", cNo);
			mv.addObject("categoryNo", categoryNo);
			mv.setViewName("redirect:detail");
		}else {
			return null;
		}
		return mv;	 
	}
	
	//클럽 수정하기-폼요청
	@GetMapping("clubUp")
	public String getUpClub(@RequestParam("cNo") int cNo, Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//클럽 상세보기
		ClubDTO clubDTO=clubService.getSelClubDetail(cNo);
		System.out.println("컨트롤러"+clubDTO);
		clubDTO.setcNo(cNo);	
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		if(!canModify(user, clubDTO)) {
			if(user.getGrade() == 999) {
				canModify(user, clubDTO);
			}else if(user.getId()==clubDTO.getMasterId()) {				
				canModify(user, clubDTO);
			}else {
				return "club/fail";
			}
		}
		
		model.addAttribute("cNo", cNo);
		model.addAttribute("loginUser",user);
		model.addAttribute("clubDTO", clubDTO);
		return "club/clubUpdate";		
	}
	
	private boolean canModify(User user, ClubDTO clubDTO) {
			//로그인한유저정보에서 id를 가져오기
			String id = user.getId();				
			//db에서 id를 가져오기
			String masterid = clubDTO.getMasterId();				
			
			return id.equals(masterid);		
	}

	//클럽 수정하기-처리요청 updateClub
	@PostMapping("clubUp")
	public ModelAndView getUpdateClubFrm(ModelAndView mv, ClubDTO clubDTO) throws Exception{
		//수정
		int cnt=clubService.getUpdateClub(clubDTO);	
		if(cnt==1) {
			int cNo = clubDTO.getcNo();
			int categoryNo =  clubDTO.getCategoryNo();
			mv.addObject("cNo",cNo);
			mv.addObject("categoryNo",categoryNo);
			mv.setViewName("redirect:/club/detail");
		}else {
			mv.setViewName("redirect:/club/clubUp?cNo="+clubDTO.getcNo());
		}

		return mv;
	}
	//----------------------------------------------------------------------------------------
	//클럽회원삭제(회원탈퇴)
	 @GetMapping("clubMemberDel") 
	 public ModelAndView delUp(HttpServletRequest request,ClubMemberDTO clubMemberDTO, ModelAndView mv) throws Exception {	
		int cMemberNo = Integer.parseInt(request.getParameter("cMemberNo"));
		clubMemberDTO.setcMemberNo(cMemberNo);	
		int cnt=clubService.getMemberDel(cMemberNo);
		
			mv.addObject("cnt", cnt);
		if(cnt==1) {
			mv.setViewName("club/clubDrop");
		}else {
			mv.setViewName("club/fail");
		}
		return mv;		
	 }	

	//클럽삭제-clubDel (관리자,클럽장)
	@GetMapping("clubADel")
	public ModelAndView DelClub(int cNo,ModelAndView mv,ClubDTO clubDTO,HttpServletRequest request) throws Exception {
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("loginUser");
		int cnt=clubService.getDel(cNo);
		
		if(!canAdminDel(user, clubDTO)) {
			if(user.getGrade() == 999) {
				canAdminDel(user, clubDTO);
			}else if(user.getId()==clubDTO.getMasterId()) {				
				canAdminDel(user, clubDTO);
			}
		}
		
		mv.addObject("cnt", cnt);
		
		if(cnt==1) {
			mv.setViewName("club/clubDrop");
		}else {
			mv.setViewName("club/fail");
		}
		return mv;		
	}

	private boolean canAdminDel(User user, ClubDTO clubDTO) {
		//로그인한유저정보에서 id를 가져오기
		String id = user.getId();				
		//db에서 id를 가져오기
		String masterid = clubDTO.getMasterId();				
		
		return id.equals(masterid);	
	}	
	
}
