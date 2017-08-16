package org.apink.mapper;

import org.apink.domain.Product;
import org.apink.domain.vo.DetailPageProductVo;
import org.apink.domain.vo.MainPageProductVo;
import org.apink.domain.ProductPrice;
import org.apink.domain.vo.ReservePageProductVo;
import org.apink.util.PagingHandler;

import java.util.List;


public interface ProductMapper {

    List<MainPageProductVo> selectByCategoryId(int categoryId, PagingHandler pagingHandler);

    List<MainPageProductVo> selectAll(PagingHandler pagingHandler);

    DetailPageProductVo selectById(int productId);

    int countAll();

    ReservePageProductVo selectSummaryByProductId(int productId);

    List<ProductPrice> selectPricesByProductId(int productId);

    Product selectByProductId(int productId);
}