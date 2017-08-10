package org.apink.service;

import org.apink.domain.Category;

import java.util.List;


public interface CategoryService {

    Category insert(Category category);

    Category selectById(int id);

    List<Category> selectAll();

    boolean update(Category category);

    boolean delete(int id);
}
