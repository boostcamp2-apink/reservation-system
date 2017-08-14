package org.apink.mapper;

import org.apink.domain.vo.MainPageProductVo;
import org.apink.domain.vo.ProductPriceVo;
import org.apink.domain.vo.ReserveProductVo;
import org.apink.util.PagingHandler;

import java.util.List;


public interface ProductMapper {

    List<MainPageProductVo> selectByCategoryId(int categoryId, PagingHandler pagingHandler);

    List<MainPageProductVo> selectAll(PagingHandler pagingHandler);

    int countAll();

    ReserveProductVo selectSummaryByProductId(int productId);

    List<ProductPriceVo> selectPricesByProductId(int productId);
}