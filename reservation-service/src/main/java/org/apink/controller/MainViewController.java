package org.apink.controller;

import org.apink.service.ProductService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainViewController {

    private ProductService productService;
//    private ModelResolver modelResolver;

    @Autowired
    public MainViewController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String mainView(Model model) {

        model.addAttribute("product", productService.getAll(new PagingHandler(1)));
        return "mainpage";
    }


}
