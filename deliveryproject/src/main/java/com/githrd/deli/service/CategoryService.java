package com.githrd.deli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.deli.dao.CategoryDao;
import com.githrd.deli.vo.categoryVO;

public class CategoryService {
	@Autowired private CategoryDao dao;
//	
//	public categoryVO selCategory(int category_no) {
//		categoryVO category = dao.selectNum(category_no);
//		
//		
//	}
//	
	

	public int selNum(String name) {
			if(name.contains("·")) {
				return 0;
			}
		return 1;
	}

	
	
	
	public String reviseCategoryName(String name) {
		if(name.contains("·")) {
			String[] temp = name.split("·");
			name = temp[0];
		}
		return name;
		
	}
	
}
