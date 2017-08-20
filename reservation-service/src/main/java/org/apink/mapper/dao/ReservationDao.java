package org.apink.mapper.dao;

import org.apink.domain.Reservation;
import org.apink.domain.ReservationTicket;
import org.apink.mapper.ReservationMapper;
import org.apink.mapper.dao.sql.ReservationSql;
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
import java.util.Date;
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
    private RowMapper<ReservationTicket> ticketRowMapper = BeanPropertyRowMapper.newInstance(ReservationTicket.class);

    public ReservationDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.reservationInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservations").usingGeneratedKeyColumns("id", "create_date", "modify_date");
//                .usingGeneratedKeyColumns("reservation_date")

        this.reservationTicketInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservations_tickets")
                .usingGeneratedKeyColumns("create_date", "modify_date");
    }

    @Override
    public int insertReservation(Reservation reservation) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
        return reservationInsertAction.executeAndReturnKey(params).intValue();
    }

    @Override
    public void insertReservationTicket(ReservationTicket reservationTicket) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationTicket);
        reservationTicketInsertAction.execute(params);
    }

    @Override
    public Reservation selectByReservationId(int reservationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", reservationId);
        return jdbc.queryForObject(ReservationSql.SELECT_BY_RESERVATION_ID, params, rowMapper);
    }

    @Override
    public int updateReservationType(int reservationId, int reservationType) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", reservationId);
        params.put("reservationType",reservationType);
        params.put("modifyDate", new Date());
        return jdbc.update(ReservationSql.UPDATE_RESERVATION_TYPE, params);
    }

    @Override
    public int deleteReservation(int reservationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", reservationId);
        return jdbc.update(ReservationSql.DELETE_RESERVATION, params);
    }

    @Override
    public int deleteReservationTicketsByReservationId(int reservationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("reservation_id", reservationId);
        return jdbc.update(ReservationSql.DELETE_RESERVATION_TICKETS_BY_RESERVATION_ID, params);
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
    public List<ReservationTicket> selectTicketsByReservationIds(List<Integer> reservationIds) {
        Map<String, Object> params = new HashMap<>();
        params.put("reservationIds", reservationIds);
        return jdbc.query(ReservationSql.SELECT_BY_RESERVATION_ID_LIST, params, ticketRowMapper);
    }
}
