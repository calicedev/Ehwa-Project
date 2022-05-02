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
	
	/*ȸ������ ���� (ȸ���� DB�� ���� �ִ� ����)
	 * signup.jsp ������ form�� ����Ǿ� ����. post ���.
	 * */
	@RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
	public String signup(MemberDTO dto, Model model) {
			memberService.insertUser(dto);
			String result = "member/login";
		return result;
	}
	
	//ȸ�����Կ��� ������ư ������ �Ѿ. 
	@RequestMapping(value = "/nextUser", method = {RequestMethod.POST})
	public String nextUser(MemberDTO dto, Model model) {
		model.addAttribute("member",dto);
		 return "member/groupchk";
	}
	
	
	/*ȸ������ ���̵� �ߺ�Ȯ��
	 * signup.jsp ������ ajax�� ����Ǿ� ����. post ���.
	 * */
	@ResponseBody
	@RequestMapping(value="/idChk", method = RequestMethod.POST)
	public int idChk(MemberDTO dto) throws Exception {
		int result = memberService.idChk(dto);
		return result;
	}
	
	//�׷� Ȯ��
	@ResponseBody
	@RequestMapping(value="/gnumchk", method = RequestMethod.POST)
	public GroupDTO gnumchk(GroupDTO groupDTO) throws Exception {
		GroupDTO result = memberService.gnumchk(groupDTO);
		System.out.println(result);
		return result;
	}
	
	
	/*�α���
	 * �α��� ��ư ������ �������� �Ѿ�� ���� �˸�â �߳� �ϴ� �κ�
	 * login.jsp�� form�̶� ����Ǿ�����.
	 * */
	@RequestMapping(value = "/login", method ={RequestMethod.POST })
	public String login(MemberDTO dto, Model model, HttpSession session) {
		MemberDTO result=memberService.loginUser(dto);
		String re="";
	      if(null == result){
	    	  model.addAttribute("message","ID�� PW�� Ʋ���ϴ�.");
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
	
	/*���̵� ã��
	 * */
	@ResponseBody
	@RequestMapping(value="/idlosschk", method = RequestMethod.POST)
	public MemberDTO idlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.idlosschk(dto);
		return result;
	}
	
	/*��й�ȣ ã��
	 * */
	@ResponseBody
	@RequestMapping(value="/pswdlosschk", method = RequestMethod.POST)
	public MemberDTO pswdlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.pswdlosschk(dto);
		return result;
	}
	
	
	/*index ���������� �α��� ��ư ������ �α��� ȭ������ �̵�
	 * index.jsp�� login��ư�� ����Ǿ� ����.
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
	
	//¦�� ����
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
	
	//���̵� �н�
	@RequestMapping(value = "/loss", method = RequestMethod.GET)
	public String loss2(Model model,HttpServletRequest request) {
		String result = request.getParameter("userName");
		model.addAttribute("idloss",result);
		return "member/idlosschk";
	}
	
	/*index ���������� ȸ������ ��ư ������ ȸ������ ȭ������ �̵�
	 * index.jsp�� login��ư�� ����Ǿ� ����.
	 * */
	@RequestMapping(value = "/signupbtn", method = RequestMethod.GET)
	public String signupbtn() {
		return "member/signup";
	}
	

	/*index ���������� �α׾ƿ� ��ư ������ �α׾ƿ� ȭ������ �̵�
	 * index.jsp�� logout��ư�� ����Ǿ� ����.
	 * */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberDTO dto, Model model, HttpSession session) {
		session.invalidate();		
		model.addAttribute("memberDTO",null);
		System.out.println(session);
		return "redirect:/";
	}
	//�α��� ���������� ���̵�ã�� ������ �Ѿ
	//	@ResponseBody
	//	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	//	public String idlosschkbtn(String pswdloss,String idloss,Model model,HttpServletRequest request) {
	//		String result = request.getParameter("userName");
	//		
	//		return result;
	//	}

	
	
	//	/*ȸ������ ���� (���� �𸣰���)
	//	 * */
	//	@ResponseBody
	//	@RequestMapping(value = "/account/register", method = {RequestMethod.POST})
	//	public String registercheck(UserDTO dto, Model model) {
	//		memberService.loginUser( dto);
	//		return "1";
	//	}
		//�α��� ���������� ���̵�ã�� ������ �Ѿ
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