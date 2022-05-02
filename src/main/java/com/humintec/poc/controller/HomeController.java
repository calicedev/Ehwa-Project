package com.humintec.poc.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.MemberDTO;
import com.humintec.poc.service.BoardService;
import com.humintec.poc.service.MemberService;

@Controller
public class HomeController {

	@Autowired
	MemberService memberService;
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(MemberDTO dto, Model model, HttpSession session, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		
		model.addAttribute("list", boardService.list());

		
		MemberDTO result=(MemberDTO)session.getAttribute("memberDTO");
		if(null == result){
			model.addAttribute("memberDTO",null);
		}else{
			model.addAttribute("memberDTO",result);
		}
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String index3(MemberDTO dto, Model model, HttpSession session) throws Exception{
		
		String value = (String)session.getAttribute("email");
		model.addAttribute("memberDTO",value);
		System.out.println(value);
		
		
		return "index";
	}

	// index2 °Ô½ÃÆÇ 
		@RequestMapping(value = "/index2", method = RequestMethod.GET)
		public String index2(Model model,HttpSession session,BoardDTO boardDTO) throws Exception{
			
			model.addAttribute("list", boardService.list());
			return "index2";
			
		}
	
}
