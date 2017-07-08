package com.soomin.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soomin.reservation.domain.Category;
import com.soomin.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping
	public String category(Model model) {
		List<Category> categories = categoryService.viewCategory();
		model.addAttribute("categoryList", categories);
		
		return "category";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam(name="name") String name) {
		Category category = new Category(name);
		Category result = categoryService.addCategory(category);
		
		return "redirect:/";
	}
}
