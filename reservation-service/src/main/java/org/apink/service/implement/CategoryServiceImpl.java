package org.apink.service.implement;

import java.util.List;

import org.apink.domain.Category;
import org.apink.mapper.dao.CategoryDao;
import org.apink.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao dao;

	@Override
	public Category register(Category category) {
		int id;
		id = dao.insert(category);
		
		if(id<=0) {
			return null;
		}
		else
			return dao.selectById(id);
	}

	@Override
	public Category getById(int id) {
		
		if(id<=0) {
			return null;
		}
		else { 
			return dao.selectById(id);
		}
	}

	@Override
	public List<Category> getAll() {
		return dao.selectAll();
	}

	@Override
	public boolean modify(Category category) {
		if (dao.update(category) != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean removeById(int id) {
		if (dao.delete(id) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
