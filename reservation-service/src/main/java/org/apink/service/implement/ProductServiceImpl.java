package org.apink.service.implement;

import org.apink.domain.Product;
import org.apink.mapper.ProductMapper;
import org.apink.service.ProductService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getByCategoryId(int categoryId, PagingHandler pagingHandler) {
        if (pagingHandler == null) {

        }
        List<Product> products;
        if (categoryId == 0) {
            products = getAll(pagingHandler);
        } else {
            products = productMapper.selectByCategoryId(categoryId, pagingHandler);
        }
        return products;

    }

    @Override
    public List<Product> getAll( PagingHandler pagingHandler) {
        return productMapper.selectAll(pagingHandler);
    }
}
