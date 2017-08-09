package org.apink.mapper;

import org.apink.domain.Product;

import java.util.List;

public interface ProductMapper {

    List<Product> selectByCategoryId(int categoryId);

}
