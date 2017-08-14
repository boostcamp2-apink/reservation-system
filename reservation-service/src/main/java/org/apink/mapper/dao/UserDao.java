package org.apink.mapper.dao;

import org.apink.domain.User;
import org.apink.domain.vo.MainPageProductVo;
import org.apink.domain.vo.ProductPriceVo;
import org.apink.domain.vo.ReserveProductVo;
import org.apink.mapper.UserMapper;
import org.apink.mapper.dao.sql.UserSqls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao implements UserMapper{

    private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체
    private RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public User selectByUserId(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        return jdbc.queryForObject(UserSqls.SELECT_BY_ID, params, userRowMapper);
    }
}
