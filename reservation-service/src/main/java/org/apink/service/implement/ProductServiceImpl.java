package org.apink.service.implement;

import org.apink.domain.vo.MainPageProductVo;
import org.apink.domain.vo.ProductPriceVo;
import org.apink.domain.vo.ReserveProductVo;
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
    public List<MainPageProductVo> getByCategoryId(int categoryId, PagingHandler pagingHandler) {
        if (pagingHandler == null) {

        }
        List<MainPageProductVo> products;
        if (categoryId == 0) {
            products = getAll(pagingHandler);
        } else {
            products = productMapper.selectByCategoryId(categoryId, pagingHandler);
        }
        return products;

    }

    @Override
    public List<MainPageProductVo> getAll( PagingHandler pagingHandler) {
        return productMapper.selectAll(pagingHandler);
    }

    @Override
    public int countAll() {
        return productMapper.countAll();
    }

    @Override
    public ReserveProductVo getSummaryByProductId(int productId) {
        return productMapper.selectSummaryByProductId(productId);
    }

    @Override
    public List<ProductPriceVo> getPriceByProductId(int productId) {
        return productMapper.selectPricesByProductId(productId);
    }
}
