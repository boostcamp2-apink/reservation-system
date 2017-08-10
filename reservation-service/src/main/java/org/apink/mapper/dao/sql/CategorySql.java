package org.apink.mapper.dao.sql;

public class CategorySql {

	public final static String SELECT_BY_ID =
			"SELECT id, name, product_count " +
				"FROM categories " +
				"WHERE id = :id";
	public final static String UPDATE_BY_ID =
			"UPDATE categories " +
					"SET name = :name" +
					"WHERE id = :id";
	public final static String DELETE_BY_ID =
			"DELETE " +
					"FROM categories" +
					"WHERE id = :id";
	public final static String SELECT_ALL =
			"SELECT id, name, product_count " +
					"FROM categories";
}
