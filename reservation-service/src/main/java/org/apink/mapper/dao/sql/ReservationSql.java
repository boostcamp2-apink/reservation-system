package org.apink.mapper.dao.sql;

public class ReservationSql {

    public static final String SELECT_BY_USER_ID =
            "SELECT Reservations.id, " +
                    "Reservations.product_id, " +
                    "Reservations.user_id, " +
                    "Reservations.reservation_name, " +
                    "Reservations.reservation_tel, " +
                    "Reservations.reservation_email, " +
                    "Reservations.reservation_date, " +
                    "Reservations.reservation_type, " +
                    "Reservations.total_price, " +
                    "Products.name " +
            "FROM reservations AS Reservations JOIN products AS Products ON Reservations.product_id = Products.id " +
            "WHERE user_id = :user_id " +
            "ORDER BY Reservations.reservation_type asc, Reservations.modify_date desc " +
            "LIMIT :pagePerNum OFFSET :offset;";

    public static final String SELECT_BY_RESERVATION_ID_LIST =
            "SELECT Tickets.reservation_id, " +
                    "Tickets.count, " +
                    "Prices.price, " +
                    "Prices.discount_rate " +
            "FROM reservations_tickets AS Tickets INNER JOIN products_prices AS Prices " +
            "ON Tickets.product_price_id = Prices.id " +
            "WHERE Tickets.reservation_id in (:reservationIds)";

    public static final String SELECT_BY_RESERVATION_ID =
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
                    "WHERE id= :id";
    public static final String UPDATE_RESERVATION_TYPE =
            "UPDATE reservations " +
            "SET reservation_type = :reservationType " +
            "WHERE id = :id ";

    public static final String DELETE_RESERVATION =
            "DELETE FROM reservations " +
                    "WHERE id = :id";

    public static final String DELETE_RESERVATION_TICKETS_BY_RESERVATION_ID =
            "DELETE FROM reservations_tickets " +
                    "WHERE reservation_id = :reservation_id";

}
