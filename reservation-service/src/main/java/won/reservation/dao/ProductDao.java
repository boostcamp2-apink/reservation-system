package won.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import won.reservation.domain.Product;
import won.reservation.dto.ProductInfo;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductInfo> productInfoRowMapper = BeanPropertyRowMapper.newInstance(ProductInfo.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product")
				.usingGeneratedKeyColumns("id");
	}
	
	public int insert(Product product) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	// 전체보기
	public List<Product> select() {
		return jdbc.query(ProductSqls.SELECT_ALL, rowMapper);
	}
	
	// 카테고리별전체보기
	public List<Product> select(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryid", categoryId);
		return jdbc.query(ProductSqls.SELECT_BY_CATEGORYID, params, rowMapper);
	}
	
	public int getCount() {
		Map<String, Integer> params = new HashMap<>();
		return jdbc.queryForObject(ProductSqls.COUNT_ALL, params, Integer.class);
	}
	
	public int getCount(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryid", categoryId);
		return jdbc.queryForObject(ProductSqls.COUNT_BY_CATEGORYID, params, Integer.class);
	}
	
	public int update(Product product) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(product);
		return jdbc.update(ProductSqls.UPDATE_BY_ID, params);
	}
	
	public int delete(int id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.update(ProductSqls.DELETE_BY_ID, params);
	}
	
	public List<ProductInfo> selectInfo(Integer start){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("displaynum", 3);
		return jdbc.query(ProductSqls.SELECT_INFO_ALL, params, productInfoRowMapper);
	}
	
	public List<ProductInfo> selectInfo(Integer categoryId, Integer start){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryid", categoryId);
		params.put("start", start);
		params.put("displaynum", 3);
		return jdbc.query(ProductSqls.SELECT_INFO_CATEGORY, params, productInfoRowMapper);
	}
}
