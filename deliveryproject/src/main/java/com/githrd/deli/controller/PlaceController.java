package com.githrd.deli.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.githrd.deli.dao.CategoryDao;
import com.githrd.deli.dao.PlaceDao;
import com.githrd.deli.vo.categoryVO;
import com.githrd.deli.vo.placeVO;

@Controller
@RequestMapping("/place")
public class PlaceController {
	@Autowired private PlaceDao mapper;
	@Autowired private CategoryDao dao;

	
	@GetMapping("/category.dlv")
	public String chooseCategory(Model model, @Param("name")String name) {
		List<categoryVO> category = dao.selectList();
		System.out.println(name);
		placeVO place = mapper.selectOne(name);
		model.addAttribute("place", place);
		model.addAttribute("category",category);
		return "/search/2.SelectPlace/chooseMenuCategory";
	}
	
	@GetMapping("/restaurant.dlv")
	public String chooseMenuCategory(Model model,@Param("category_name")String category_name,@Param("place_name")String place_name) {
		placeVO place = mapper.selectOne(place_name);
		categoryVO category = dao.selectOne(category_name);
		model.addAttribute("place",place);
		model.addAttribute("category",category);
		return "search/3.SelectRestaurant/restaurantChoose";
	}
	
	
	
	@GetMapping("/restaurant/selectfinish.dlv")
	public String restaurantChoose(Model model,@Param("category_name")String category_name,@Param("place_name")String place_name,@Param("restaurantName")String restaurantName) {
		placeVO place = mapper.selectOne(place_name);
		categoryVO category = dao.selectOne(category_name);
		model.addAttribute("place",place);
		model.addAttribute("category",category);
		model.addAttribute("restaurantName",restaurantName);
		return "search/3.SelectRestaurant/checkInfo";
		}
	
	
}
