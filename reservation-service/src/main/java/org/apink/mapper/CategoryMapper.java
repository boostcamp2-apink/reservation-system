package org.apink.mapper;

import org.apink.domain.Category;

import java.util.List;

public interface CategoryMapper {

    int insert(Category category);

    Category selectById(int id);

    List<Category> selectAll();

    int update(Category category);

    int delete(int id);

}
