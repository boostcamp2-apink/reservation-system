package won.reservation.service;

import java.util.List;

import won.reservation.domain.Category;

public interface CategoryService {
	public List<Category> readCategory();
	public Category readCategoryById(int id);
	public int addCategory(String name);
	public int update(Category category);
	public int delete(int id);
}