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

    public static final String SELECT_BY_RESERVATAION_ID_LIST =
            "SELECT Tickets.reservation_id, " +
                    "Tickets.count, " +
                    "Prices.price, " +
                    "Prices.discount_rate " +
            "FROM reservations_tickets AS Tickets INNER JOIN products_prices AS Prices " +
            "ON Tickets.product_price_id = Prices.id " +
            "WHERE Tickets.reservation_id in (:reservationIds)";
}
