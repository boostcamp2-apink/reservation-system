package org.apink.mapper.dao;

import org.apink.domain.Reservation;
import org.apink.domain.vo.ReservationTicketVo;
import org.apink.mapper.ReservationMapper;
import org.apink.mapper.dao.sql.ReservationSql;
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
public class ReservationDao implements ReservationMapper {

    public Logger logger = LoggerFactory.getLogger(ReservationDao.class);

    private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
    private SimpleJdbcInsert reservationInsertAction;
    private SimpleJdbcInsert reservationTicketInsertAction;
    private RowMapper<Reservation> rowMapper = BeanPropertyRowMapper.newInstance(Reservation.class); // 칼럼 이름을 보통 user_name 과 같이 '_'를 활용하는데 자바는 낙타표기법을 사용한다 이것을 자동 맵핑한다.


    public ReservationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.reservationInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservations").usingGeneratedKeyColumns("id");
        this.reservationTicketInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservations_tickets").usingGeneratedKeyColumns("id");
    }
    @Override
    public List<Reservation> selectByUserId(int userId, PagingHandler pagingHandler) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        params.put("offset", pagingHandler.getOffset());
        params.put("pagePerNum", pagingHandler.getPagePerNum());
        return jdbc.query(ReservationSql.SELECT_BY_USER_ID, params, rowMapper);
    }

    @Override
    public List<ReservationTicketVo> selectTicketsByReservationId(int reservationId) {
        return null;
    }
}
