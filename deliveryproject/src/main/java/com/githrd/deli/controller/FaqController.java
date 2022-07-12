package com.githrd.deli.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.githrd.deli.service.FaqService;
import com.githrd.deli.vo.faqVO;

@Controller
@RequestMapping("/faq")
public class FaqController {
	
	@Autowired private FaqService service;
	
	private Map<Integer,faqVO> faqMap = new HashMap<>();	//no, faqvo
	
	
	//faq 메인페이지 보기
	@GetMapping("/board.dlv")
	public String faqMain(Model model) {
		List<faqVO> list = service.selectList();
		if(list!=null) {
			model.addAttribute("list", list);
			System.out.println("list");
		}
		else {
			String str = "조회된 데이터가 없습니다.";
			model.addAttribute("str",str);
		}
		return "/faq/faqList";
	}
	
	//faq 페이지 상세내용 보기
	@GetMapping("/board/detail.dlv")
	public String faqDetail(Model model,@Param("no")int no) {
		faqVO faq = service.selectNum(no);
		model.addAttribute("faq",faq);
		return "/faq/faqDetail";
	}
	
	//faq 입력
	@GetMapping("/board/insert.dlv")
	public String faqInsert() {
		return"/faq/faqInsert";
	}

	
	//faq 입력
	@PostMapping("/board/insert.dlv")
	public String faqInsert(@Param("id")String id,@Param("pw")String pw,@Param("title")String title, @Param("content")String content){
		//no,id,pw,title,content
		faqVO vo = new faqVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setTitle(title);
		vo.setContent(content);
		System.out.println(vo);
		service.insert(faqMap, vo);
		return "redirect:/faq/board.dlv";
	}
	//faq 페이지 수정페이지
	@GetMapping("/board/update.dlv")
	public String faqUpdate(Model model,@Param("no")int no) {
		faqVO faq = faqMap.get(no);
		model.addAttribute("no",no);
		model.addAttribute("faq",faq);
		return"/faq/faqUpdate";
	}
	//faq 페이지 
	@PostMapping("/board/update.dlv")
	public String faqUpdate2(Model model,@Param("no")int no,@Param("title")String title, @Param("content")String content) {
		service.update(faqMap, no,title, content);
		return "redirect:/faq/board.dlv";
	}
	
	@GetMapping("/board/delete.dlv")
	public String faqDelete(@Param("no")int no) {
		service.delete(faqMap,no);
		return"redirect:/faq/board.dlv";
	}
	
}
