package com.githrd.deli.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.deli.dao.FaqDao;
import com.githrd.deli.vo.faqVO;


public class FaqService {
	
	@Autowired private FaqDao fdao;
	
	public faqVO selectNum(int no) {
		return fdao.selectNum(no);
	}
	
	public List<faqVO> selectList(){
		if(fdao.selectList().size()<1) {
			return null;
		}
		return fdao.selectList();
	}
	
	
	public int insert(Map<Integer,faqVO> faqMap, faqVO vo) {
		 int no = fdao.insert(vo);
		if(no!=1) {
			vo.setMessage("입력 실패");
			return 0;
		}
		else {
			vo.setMessage(null);
			System.out.println("insert");
			faqMap.put(vo.getNo(), vo);
			return no;
		}
	}
	
	public int update(Map<Integer,faqVO> faqMap,int no,String title,String content) {
		faqVO vo=faqMap.get(no);
		vo.setContent(content);
		vo.setTitle(title);
		faqMap.replace(no,vo);
		return fdao.update(vo);
	}
	
	public int delete(Map<Integer,faqVO> faqMap,int no) {
		faqVO vo = faqMap.get(no);
		faqMap.remove(vo);
		return fdao.delete(no);
	}
	
	
	
	
	
}
