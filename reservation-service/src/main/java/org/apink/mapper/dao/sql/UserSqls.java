package org.apink.mapper.dao.sql;

public class UserSqls {

    public static final String SELECT_BY_ID =
            "SELECT username, tel, email " +
                    "FROM users " +
                    "WHERE id = :user_id";
}
