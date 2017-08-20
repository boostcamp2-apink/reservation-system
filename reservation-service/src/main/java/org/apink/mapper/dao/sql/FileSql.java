package org.apink.mapper.dao.sql;

public class FileSql {

	public final static String SELECT_BY_ID =
			"SELECT id, content_type, create_date, delete_flag, file_length, file_name, modify_date, save_file_name, user_id "+
			"FROM files "+
			"WHERE id=:id ;";
	public final static String SELECT_BY_COMMENTS_ID =
			"SELECT comment_id,file_id "
					+ "FROM comments_images "
					+ "WHERE comment_id IN (:comments); ";
	public final static String UPDATE_DELETE_FLAG_BY_IDS =
			"UPDATE files " +
					"SET delete_flag=0 "+
					"WHERE id IN (:files); ";

	
}

