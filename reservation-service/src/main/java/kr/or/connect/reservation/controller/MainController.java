package kr.or.connect.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
//@RequestMapping({"/","/reservation-service"})
public class MainController {
	@Autowired
    private CategoryService categoryService;
	
	@GetMapping
    public ModelAndView index(HttpServletRequest request){
    	
    	List<Category> categories = categoryService.getAll();
    	ModelAndView mv = new ModelAndView("index", "categories", categories);
        return mv;
    }
	
	
	
}