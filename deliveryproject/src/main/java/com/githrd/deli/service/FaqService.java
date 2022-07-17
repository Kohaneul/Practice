package com.githrd.deli.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.deli.dao.FaqDao;
import com.githrd.deli.vo.faqVO;


public class FaqService {
	
	@Autowired private FaqDao fdao;
	public Map<String,String> controllerMap = new HashMap<>();

	public FaqService() {
		controllerMap.put("/deli/faq/board.dlv", "/faq/faqList");
		controllerMap.put("/deli/faq/admin/board/login.dlv", "/faq/board.dlv");
		controllerMap.put("/deli/faq/board/detail.dlv", "/faq/faqDetail");
		controllerMap.put("/deli/faq/admin/board/insert.dlv", "/faq/admin/faqInsert");
		controllerMap.put("/deli/faq/admin/board/delete.dlv", "redirect:/faq/board.dlv");
		controllerMap.put("/deli/faq/admin/board/update.dlv", "/faq/admin/faqUpdate");
		controllerMap.put("/deli/faq/admin/board/update2.dlv", "redirect:/faq/board.dlv");

	}
	public String findViewPage(String uri) {
		System.out.println("faqService : "+uri);
		String viewPage = controllerMap.get(uri);
		viewPage = cutUri(viewPage);
		System.out.println("viewPage : "+viewPage);
		return viewPage;
	}
	
	public String cutUri(String uri) {
		if(uri.contains(";jsessionid")) {
			System.out.println(uri.indexOf(";"));
			int idx = uri.indexOf(";")-1;
			int len = uri.length()-1;
			if(len>idx) {
				uri = uri.substring(idx, len);
				System.out.println("cut : "+uri);
			}
			}
		return uri;
	}
	
	
	public faqVO selectNum(int no) {
		return fdao.selectNum(no);
	}
	
	public List<faqVO> selectList(){
		if(fdao.selectList().size()<1) {
			return null;
		}
		return fdao.selectList();
	}
	
	public faqVO login(int no,String pw) {
		faqVO faq = selectNum(no);
		if(faq.getPw().equals(pw)) {
			faq.setMessage(null);
		}
		else {
			faq.setMessage("비밀번호가 틀렸습니다.");
		}
		
		return faq;
	}
	
	public int insert(faqVO vo) {
		 int no = fdao.insert(vo);
		if(no!=1) {
			vo.setMessage("입력 실패");
			return 0;
		}
		else {
			vo.setMessage(null);
			return no;
		}
	}
	
	public int update(int no,String title,String content) {
		faqVO vo=selectNum(no);
		vo.setTitle(title);
		vo.setContent(content);
		return fdao.update(vo);
	}
	
	public int delete(int no) {
		return fdao.delete(no);
	}
	
	
}
