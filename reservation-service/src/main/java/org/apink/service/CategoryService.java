package org.apink.service;

import org.apink.domain.Category;

import java.util.List;


public interface CategoryService {

    Category register(Category category);

    Category getById(int id);

    List<Category> getAll();

    boolean modify(Category category);

    boolean removeById(int id);
}
