package com.githrd.deli.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.githrd.deli.service.AdminService;
import com.githrd.deli.service.FaqService;
import com.githrd.deli.vo.adminVO;
import com.githrd.deli.vo.faqVO;

@Controller
@RequestMapping("/faq")
public class FaqController {
	
	@Autowired	private AdminService adminService;
	@Autowired 	private FaqService faqService;
	
	private static adminVO admin;
	
	// faq 메인페이지 보기
	@GetMapping("/board.dlv")
	public String boardView(HttpServletRequest request,Model model) {
		String uri = request.getRequestURI();
		List<faqVO> list = faqService.selectList();
		model.addAttribute("list", list);
		model.addAttribute("admin",admin);
		return faqService.findViewPage(uri);
	}
	
	
	//로그인페이지
	@GetMapping("/admin/board/login.dlv")
	public String login() {
		return	"/faq/admin/adminLogin";
	}
	
	
	@PostMapping("/admin/board/login.dlv")
	public String login(Model model, @Param("id")String id, @Param("pw")String pw) {
		String uri ="/deli/faq/board.dlv";
		String msg = adminService.LoginMsg(id, pw);
		if(msg==null) {
			admin = adminService.selectId(id);
			List<faqVO> list = faqService.selectList();
			model.addAttribute("list", list);
			model.addAttribute("admin",admin);
		}
		else {
			uri="/deli/faq/admin/board/login.dlv";

		}
		return faqService.findViewPage(uri);
	}
	
	
	
	
	
	
	@GetMapping("/admin/board/insert.dlv")
	public String beforeInsert(HttpServletRequest request,Model model) {
		String uri = request.getRequestURI();
		model.addAttribute("admin", admin);
		return faqService.findViewPage(uri);
	}
	
	
	
	@PostMapping("/admin/board/insert.dlv")
	public String afterInsert(Model model, @Param("id")String id, @Param("title")String title,@Param("content")String content) {
		String uri ="/deli/faq/board.dlv";
		faqVO faq = new faqVO(id,title,content);
		faqService.insert(faq);
		List<faqVO> list = faqService.selectList();
		model.addAttribute("list", list);
		return faqService.findViewPage(uri);
	}
	
	
	@RequestMapping(value = {"/board/detail.dlv", "/admin/board/delete.dlv","/admin/board/update.dlv","/admin/board/update2.dlv"})
	public String detailView(HttpServletRequest request, @Param("no")int no,Model model) {
		faqVO faq = faqService.selectNum(no);
		String uri = request.getRequestURI();
		model.addAttribute("admin",admin);
		if(uri.equals("/deli/faq/admin/board/update2.dlv"))
		{
			faqService.update(no, request.getParameter("title"), request.getParameter("content"));
			
		}		
		if(uri.equals("/deli/faq/admin/board/delete.dlv"))
		{
			faqService.delete(no);
		}
		model.addAttribute("faq", faq);
		return faqService.findViewPage(uri);
	}
	
}
