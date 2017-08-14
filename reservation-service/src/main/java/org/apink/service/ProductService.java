package org.apink.service;

import org.apink.domain.vo.MainPageProductVo;
import org.apink.domain.ProductPrice;
import org.apink.domain.vo.ReserveProductVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ProductService {

    List<MainPageProductVo> getByCategoryId(int categoryId, PagingHandler pagingHandler);

    List<MainPageProductVo> getAll(PagingHandler pagingHandler);

    int countAll();

    ReserveProductVo getSummaryByProductId(int productId);

    List<ProductPrice> getPriceByProductId(int productId);



}
