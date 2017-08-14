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
@RequestMapping("/api/products")
public class ProductRestController {

    public Logger logger = LoggerFactory.getLogger(ProductRestController.class);
    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{productId}")
    public List<MainPageProductVo> getProductById(@PathVariable Integer productId) {

        return null;
    }
}
