package org.apink.mapper.dao;


import javafx.util.Pair;
import org.apink.domain.Comment;
import org.apink.domain.vo.CommentImageVo;
import org.apink.domain.vo.CommentVo;
import org.apink.mapper.CommentMapper;
import org.apink.mapper.dao.sql.CommentSql;
import org.apink.util.PagingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDao implements CommentMapper {

    public Logger logger = LoggerFactory.getLogger(CommentDao.class);

    private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
    private RowMapper<CommentVo> rowMapper = BeanPropertyRowMapper.newInstance(CommentVo.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.


    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("comments")
                .usingGeneratedKeyColumns("id","create_date","modify_date");
    }

    @Override
    public int insert(Comment comment) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    @Override
    public List<CommentVo> selectByProductId(int productId, PagingHandler pagingHandler) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        params.put("offset", pagingHandler.getOffset());
        params.put("pagePerNum", pagingHandler.getPagePerNum());
        return jdbc.query(CommentSql.SELECT_BY_PRODUCT_ID, params, rowMapper);
    }



}
