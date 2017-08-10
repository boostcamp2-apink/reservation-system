package org.apink.controller.api;

import org.apink.domain.vo.MainPageProductVo;
import org.apink.service.ProductService;
import org.apink.util.PagingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    public Logger logger = LoggerFactory.getLogger(CategoryRestController.class);
    private ProductService productService;

    @Autowired
    public CategoryRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{categoryId}/products")
    public List<MainPageProductVo> getProductsByCategoryId(@PathVariable Integer categoryId,
                                                           @ModelAttribute PagingHandler pagingHandler) {
        logger.debug(pagingHandler.toString());
        return productService.getByCategoryId(categoryId, pagingHandler);
    }
}
