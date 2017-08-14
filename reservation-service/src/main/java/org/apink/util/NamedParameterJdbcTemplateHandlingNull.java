package org.apink.util;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.Map;

public class NamedParameterJdbcTemplateHandlingNull extends NamedParameterJdbcTemplate {

	public NamedParameterJdbcTemplateHandlingNull(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public <T> T queryForObject(String sql, SqlParameterSource paramSource, RowMapper<T> rowMapper)
			throws DataAccessException {
		try {
			return super.queryForObject(sql, paramSource, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
	}

	@Override
	public <T> T queryForObject(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper)
			throws DataAccessException {
		try {
			return super.queryForObject(sql, paramMap, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
	}

	@Override
	public <T> T queryForObject(String sql, SqlParameterSource paramSource, Class<T> requiredType)
			throws DataAccessException {
		try {
			return super.queryForObject(sql, paramSource, requiredType);
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
		
	}

	@Override
	public <T> T queryForObject(String sql, Map<String, ?> paramMap, Class<T> requiredType) throws DataAccessException {
		try {
			return super.queryForObject(sql, paramMap, requiredType);
		} catch(EmptyResultDataAccessException e) {
			return null;
		} 
		
	}

	
}
