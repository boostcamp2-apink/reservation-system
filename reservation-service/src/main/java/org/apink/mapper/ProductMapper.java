package org.apink.mapper;

import org.apink.domain.Product;
import org.apink.util.PagingHandler;

import java.util.List;


public interface ProductMapper {

    List<Product> selectByCategoryId(int categoryId, PagingHandler pagingHandler);
    List<Product> selectAll(PagingHandler pagingHandler);
}
