package org.apink.mapper.dao.sql;

public class CommentSql {

    public final static String SELECT_BY_PRODUCT_ID =

            "SELECT c.id, "+
                    "c.score, "+
                    "c.comment, "+
                    "c.product_id, " +
                    "c.create_date, " +
                    "u.username "+
                    "FROM comments AS c JOIN Users AS u " +
                    "ON c.user_id = u.id "+
                    "WHERE c.product_id= :product_id "+
                    "LIMIT :pagePerNum OFFSET :offset;";

}
