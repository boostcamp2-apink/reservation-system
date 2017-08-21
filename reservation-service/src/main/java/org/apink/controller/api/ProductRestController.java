package org.apink.controller.api;

import org.apink.domain.Comment;
import org.apink.domain.vo.CommentVo;
import org.apink.domain.vo.MainPageProductVo;
import org.apink.service.CommentService;
import org.apink.service.ProductService;
import org.apink.util.PagingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private ProductService productService;
    private CommentService commentService;


    @Autowired
    public ProductRestController(ProductService productService, CommentService commentService) {
        this.productService = productService;
        this.commentService = commentService;
    }


    @GetMapping("/{productId}")
    public List<MainPageProductVo> getProductById(@PathVariable Integer productId) {

        return null;
    }

    @GetMapping("/{productId}/comments")
    public List<CommentVo> getCommentsByProductId(@PathVariable int productId,
                                                  @RequestParam int page, @RequestParam int pagePerNum){
        return commentService.getByProductId(productId, new PagingHandler(page, pagePerNum));
    }

    @PostMapping("/{productId}/comments")
    public int postCommentsByProductId(@ModelAttribute("comment") CommentVo comment){
        return commentService.addComment(comment);
    }
}
