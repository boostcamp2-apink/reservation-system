package org.apink.service;

import org.apink.domain.vo.DetailPageProductVo;
import org.apink.domain.vo.MainPageProductVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ProductService {

    List<MainPageProductVo> getByCategoryId(int categoryId, PagingHandler pagingHandler);

    List<MainPageProductVo> getAll(PagingHandler pagingHandler);

    DetailPageProductVo getById(int productId);

    int countAll();
}
