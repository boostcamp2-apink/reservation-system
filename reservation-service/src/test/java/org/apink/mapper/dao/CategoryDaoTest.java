package org.apink.mapper.dao;

import org.apink.config.RootApplicationContextConfig;
import org.apink.util.PagingHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class CategoryDaoTest {
    private CategoryDao categoryDao;

    @Autowired
    void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Test
    public void shoudSelectAll() {
        System.out.println(categoryDao.selectAll());
    }
}
