package org.apink.mapper.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.apink.config.RootApplicationContextConfig;
import org.apink.controller.api.ProductRestController;
import org.apink.util.PagingHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductDaoTest {
	private ProductDao productDao;
	public Logger logger = LoggerFactory.getLogger(ProductDaoTest.class);


	@Autowired
	void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Test
	public void shoudSelectAll() {
		System.out.println(productDao.selectByCategoryId(1,new PagingHandler(1)).toString());
	}
	@Test
	public void shouldPriceSelect() {
	}

	@Test
	public void shouldSelect(){
		logger.info(productDao.selectById(3).toString());
	}
	

}
