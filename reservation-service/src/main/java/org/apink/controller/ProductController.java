package org.apink.controller;


import org.apink.service.CommentService;
import org.apink.service.ProductService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private CommentService commentService;

    @Autowired
    public ProductController(ProductService productService, CommentService commentService) {

        this.productService = productService;
        this.commentService = commentService;
    }


    @GetMapping("/{productId}")
    public String detailView(Model model, @PathVariable int productId) {
        model.addAttribute("product",productService.getById(productId));
        model.addAttribute("comments",commentService.getByProductId(productId,new PagingHandler(1,3)));
        return "detail";
    }

    @GetMapping("/{productId}/comments")
    public String conmmentsView(Model model, @PathVariable int productId){
        model.addAttribute("id", productId);
        model.addAttribute("product", productService.getByProductId(productId));
        model.addAttribute("comments", commentService.getByProductId(productId, new PagingHandler(1,10)));
        return "review";
    }


    @GetMapping("/{productId}/commentWrite")
    public String conmmentWriteView(Model model, @PathVariable int productId){
        model.addAttribute("id", productId);
        model.addAttribute("product", productService.getByProductId(productId));
        return "reviewWrite";
    }

}
