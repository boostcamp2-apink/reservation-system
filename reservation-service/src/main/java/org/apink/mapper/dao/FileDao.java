package org.apink.mapper.dao;

import org.apink.domain.CommentImage;
import org.apink.domain.File;
import org.apink.domain.vo.CommentImageVo;
import org.apink.mapper.FileMapper;
import org.apink.mapper.dao.sql.CommentSql;
import org.apink.mapper.dao.sql.FileSql;
import org.apink.util.NamedParameterJdbcTemplateHandlingNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FileDao implements FileMapper {
	private NamedParameterJdbcTemplateHandlingNull jdbc; // sql 을 실행하기 위해 사용되는 객체
	private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
	private SimpleJdbcInsert insertCommentAction;
	private RowMapper<File> rowMapper = BeanPropertyRowMapper.newInstance(File.class); // 칼럼 이름을 보통 user_name 과 같이
	private RowMapper<CommentImageVo> commentImageRowMapper = BeanPropertyRowMapper.newInstance(CommentImageVo.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.


	public FileDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplateHandlingNull(dataSource);
		this.insertCommentAction = new SimpleJdbcInsert(dataSource).withTableName("comments_images").usingGeneratedKeyColumns("id","create_date","modify_date");
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("files").usingGeneratedKeyColumns("id","create_date","modify_date");
	}

	//Create
	@Override
    public int insert(File file){
        SqlParameterSource params = new BeanPropertySqlParameterSource(file);
        return insertAction.executeAndReturnKey(params).intValue();
    }

	@Override
	public int[] insertComment(List<CommentImage> commentImages){
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(commentImages.toArray());
		return insertCommentAction.executeBatch(batch);
	}
    
    //Read
	@Override
    public File selectById(int id) {
    	Map<String, ?> params = Collections.singletonMap("id", id);
    	 return jdbc.queryForObject(FileSql.SELECT_BY_ID, params, rowMapper);
    }

	@Override
	public List<CommentImageVo> selectByCommentsId(List<Integer> comments) {
		Map<String, Object> params = new HashMap<>();
		params.put("comments", comments);
		return jdbc.query(FileSql.SELECT_BY_COMMENTS_ID,params,commentImageRowMapper);
	}

	@Override
	public int updateDeleteFlag(List<Integer> filesId) {
		Map<String, Object> params = new HashMap<>();
		params.put("files", filesId);
		return jdbc.update(FileSql.UPDATE_DELETE_FLAG_BY_IDS,params);
	}
}
