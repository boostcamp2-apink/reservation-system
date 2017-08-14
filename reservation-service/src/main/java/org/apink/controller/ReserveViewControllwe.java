package org.apink.controller;

import org.apink.service.ProductService;
import org.apink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ReserveViewControllwe {

    private ProductService productService;
    private UserService userService;

    @Autowired
    public ReserveViewControllwe(ProductService productService, UserService userService){
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/{id}/reserve")
    public String reserveView(@PathVariable int id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("product", productService.getSummaryByProductId(id));
        model.addAttribute("prices", productService.getPriceByProductId(id));

        //TODO Get userId from a session || argumentResolver
        int userId = 1;
        model.addAttribute("user", userService.getByUserId(userId));
        return "reserve";
    }
}
