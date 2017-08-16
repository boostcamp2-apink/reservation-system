package org.apink.mapper.dao.sql;

public class ReservationSql {

    public static final String SELECT_BY_USER_ID =
            "SELECT id, " +
                    "product_id, " +
                    "user_id, " +
                    "reservation_name, " +
                    "reservation_tel, " +
                    "reservation_email, " +
                    "reservation_date, " +
                    "reservation_type, " +
                    "total_price " +
            "FROM reservations " +
            "WHERE user_id = :user_id " +
            "ORDER BY reservation_type asc, modify_date desc " +
            "LIMIT :pagePerNum OFFSET :offset;";
}
