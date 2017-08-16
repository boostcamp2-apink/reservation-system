package org.apink.mapper.dao;

import org.apink.domain.Product;
import org.apink.domain.vo.DetailPageProductVo;
import org.apink.domain.vo.MainPageProductVo;
import org.apink.domain.ProductPrice;
import org.apink.domain.vo.ReservePageProductVo;
import org.apink.mapper.ProductMapper;
import org.apink.mapper.dao.sql.ProductSql;
import org.apink.util.NamedParameterJdbcTemplateHandlingNull;
import org.apink.util.PagingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDao implements ProductMapper {

    public Logger logger = LoggerFactory.getLogger(ProductDao.class);

    private NamedParameterJdbcTemplateHandlingNull jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체

    private RowMapper<MainPageProductVo> rowMapper = BeanPropertyRowMapper.newInstance(MainPageProductVo.class);
    private RowMapper<ProductPrice> productPriceVoRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
    private RowMapper<ReservePageProductVo> reserveProductVoRowMapper = BeanPropertyRowMapper.newInstance(ReservePageProductVo.class);
    private RowMapper<DetailPageProductVo> detailRowMapper = BeanPropertyRowMapper.newInstance(DetailPageProductVo.class);
    private RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplateHandlingNull(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<MainPageProductVo> selectByCategoryId(int categoryId, PagingHandler pagingHandler) {
        Map<String, Object> params = new HashMap<>();
        params.put("category_id", categoryId);
        params.put("offset", pagingHandler.getOffset());
        params.put("pagePerNum", pagingHandler.getPagePerNum());
        return jdbc.query(ProductSql.SELECT_BY_CATEGORY_ID, params, rowMapper);
    }

    @Override
    public List<MainPageProductVo> selectAll(PagingHandler pagingHandler) {
        Map<String, Object> params = new HashMap<>();
        logger.debug(String.valueOf(pagingHandler.getOffset()));
        logger.debug(String.valueOf(pagingHandler.getPagePerNum()));
        params.put("offset", pagingHandler.getOffset());
        params.put("pagePerNum", pagingHandler.getPagePerNum());
        return jdbc.query(ProductSql.SELECT_ALL, params, rowMapper);
    }

    @Override
    public DetailPageProductVo selectById(int productId) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        return jdbc.queryForObject(ProductSql.SELECT_BY_ID, params, detailRowMapper);
    }

    @Override
    public int countAll() {
        Map<String, ?> params = null;
        return jdbc.queryForObject(ProductSql.COUNT_ALL, params, Integer.class);
    }

    @Override
    public ReservePageProductVo selectSummaryByProductId(int productId) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        return jdbc.queryForObject(ProductSql.SELECT_SUMMARY_BY_PRODUCT_ID, params, reserveProductVoRowMapper);
    }

    @Override
    public List<ProductPrice> selectPricesByProductId(int productId) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        return jdbc.query(ProductSql.SELECT_PRICES_BY_PRODUCT_ID, params, productPriceVoRowMapper);
    }

    @Override
    public Product selectByProductId(int productId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", productId);
        return jdbc.queryForObject(ProductSql.SELECT_BY_PRODUCT_ID, params, productRowMapper);
    }

}