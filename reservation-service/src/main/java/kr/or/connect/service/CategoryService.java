package kr.or.connect.service;

import java.util.*;

import kr.or.connect.domain.*;

public interface CategoryService {
    public List<Category> getAll();
    public Category selectById(Long id);
    public Category insertCategory(Category category);
    public int delete(Long id);
}