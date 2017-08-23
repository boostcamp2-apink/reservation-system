package org.apink.controller;

import org.apink.service.CategoryService;
import org.apink.service.ProductService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainViewController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public MainViewController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String mainView(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("productCount", productService.countAll());
        model.addAttribute("products", productService.getAll(new PagingHandler(1)));
        return "mainpage";
    }

}
