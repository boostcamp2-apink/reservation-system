package org.apink.service;

import org.apink.domain.Product;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ProductService {

    List<Product> getByCategoryId(int categoryId, PagingHandler pagingHandler);

    List<Product> getAll(PagingHandler pagingHandler);
}
