package com.humintec.poc.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.GroupDTO;
import com.humintec.poc.dto.MemberDTO;
import com.humintec.poc.service.MemberService;


@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	/*회원가입 로직 (회원을 DB에 집어 넣는 로직)
	 * signup.jsp 파일의 form과 연결되어 있음. post 방식.
	 * */
	@RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
	public String signup(MemberDTO dto, Model model) {
			memberService.insertUser(dto);
			String result = "member/login";
		return result;
	}
	
	//회원가입에서 다음버튼 누르면 넘어감. 
	@RequestMapping(value = "/nextUser", method = {RequestMethod.POST})
	public String nextUser(MemberDTO dto, Model model) {
		model.addAttribute("member",dto);
		 return "member/groupchk";
	}
	
	
	/*회원가입 아이디 중복확인
	 * signup.jsp 파일의 ajax와 연결되어 있음. post 방식.
	 * */
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int idChk(MemberDTO dto) throws Exception {
		int result = memberService.idChk(dto);
		return result;
	}
	
	//그룹 확인
	@ResponseBody
	@RequestMapping(value="/gnumchk", method = RequestMethod.POST)
	public GroupDTO gnumchk(GroupDTO groupDTO) throws Exception {
		GroupDTO result = memberService.gnumchk(groupDTO);
		System.out.println(result);
		return result;
	}
	
	
	/*로그인
	 * 로그인 버튼 누르면 다음으로 넘어가냐 오류 알림창 뜨냐 하는 부분
	 * login.jsp의 form이랑 연결되어있음.
	 * */
	@RequestMapping(value = "/login", method ={RequestMethod.POST })
	public String login(MemberDTO dto, Model model, HttpSession session) {
		MemberDTO result=memberService.loginUser(dto);
		String re="";
	      if(null == result){
	    	  model.addAttribute("message","ID나 PW가 틀립니다.");
	    	  model.addAttribute("memberDTO",null);
	         re= "member/login";
	      }else{
	    	  session.setAttribute("loginId", result.getUsername());
	    	  session.setAttribute("memberDTO", result);
	    	  System.out.println(session);
	    	  model.addAttribute("memberDTO",result);
	    	  re= "redirect:/";
	    	  }
	      return re;
	}
	
	/*아이디 찾기
	 * */
	@ResponseBody
	@RequestMapping(value="/idlosschk", method = RequestMethod.POST)
	public MemberDTO idlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.idlosschk(dto);
		return result;
	}
	
	/*비밀번호 찾기
	 * */
	@ResponseBody
	@RequestMapping(value="/pswdlosschk", method = RequestMethod.POST)
	public MemberDTO pswdlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.pswdlosschk(dto);
		return result;
	}
	
	
	/*index 페이지에서 로그인 버튼 누르면 로그인 화면으로 이동
	 * index.jsp의 login버튼과 연결되어 있음.
	 * */
	@RequestMapping(value = "/loginbtn", method = RequestMethod.GET)
	public String loginbtn() {
		return "member/login";
	}
	@RequestMapping(value = "/loginbtn", method = RequestMethod.POST)
	public String loginbtn2() {
		return "member/login";
	}

	
	@RequestMapping(value = "/groupchk", method = RequestMethod.GET)
	public String groupchk() {
		return "member/groupchk";
	}
	
	//짝꿍 연결
	@RequestMapping(value = "/codechk", method = RequestMethod.GET)
	public String codechk() {
		return "member/codechk";
	}

	@RequestMapping(value = "/codechk2", method = RequestMethod.GET)
	public String codechk2() {
		return "member/codechk2";
	}
	@RequestMapping(value = "/codechk3", method = RequestMethod.GET)
	public String codechk3() {
		return "member/codechk3";
	}
	
	//아이디 분실
	@RequestMapping(value = "/loss", method = RequestMethod.GET)
	public String loss2(Model model,HttpServletRequest request) {
		String result = request.getParameter("userName");
		model.addAttribute("idloss",result);
		return "member/idlosschk";
	}
	
	/*index 페이지에서 회원가입 버튼 누르면 회원가입 화면으로 이동
	 * index.jsp의 login버튼과 연결되어 있음.
	 * */
	@RequestMapping(value = "/signupbtn", method = RequestMethod.GET)
	public String signupbtn() {
		return "member/signup";
	}
	

	/*index 페이지에서 로그아웃 버튼 누르면 로그아웃 화면으로 이동
	 * index.jsp의 logout버튼과 연결되어 있음.
	 * */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberDTO dto, Model model, HttpSession session) {
		session.invalidate();		
		model.addAttribute("memberDTO",null);
		System.out.println(session);
		return "redirect:/";
	}
	//로그인 페이지에서 아이디찾기 누르렴 넘어감
	//	@ResponseBody
	//	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	//	public String idlosschkbtn(String pswdloss,String idloss,Model model,HttpServletRequest request) {
	//		String result = request.getParameter("userName");
	//		
	//		return result;
	//	}

	
	
	//	/*회원가입 로직 (뭔지 모르겠음)
	//	 * */
	//	@ResponseBody
	//	@RequestMapping(value = "/account/register", method = {RequestMethod.POST})
	//	public String registercheck(UserDTO dto, Model model) {
	//		memberService.loginUser( dto);
	//		return "1";
	//	}
		//로그인 페이지에서 아이디찾기 누르렴 넘어감
	//	@ResponseBody
	//	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	//	public String idlosschkbtn(String pswdloss,String idloss,Model model,HttpServletRequest request) {
	//		String result = request.getParameter("userName");
	//		
	//		return result;
	//	}

	/*
	 * @RequestMapping(value = "/groupsave", method = {RequestMethod.POST}) public
	 * String groupsave(GroupDTO groupDTO, Model model,HttpSession session,MemberDTO
	 * memberDTO) { String userName
	 * =((MemberDTO)session.getAttribute("memberDTO")).getUsername();
	 * memberDTO.setUsername(userName); String result = "redirect:/"; return result;
	 * }
	 */
	
}
