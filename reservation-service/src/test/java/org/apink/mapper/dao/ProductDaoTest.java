package org.apink.mapper.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.apink.config.RootApplicationContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class ProductDaoTest {
	private ProductDao productDao;

	@Autowired
	void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Test
	public void shoudSelectAll() {
		
//		System.out.println(productDao.selectPlaceNameByProductId(13));
	}
	@Test
	public void shouldPriceSelect() {
	}
	

}
