package org.apink.mapper.dao.sql;

public class CommentSql {

    public final static String SELECT_BY_PRODUCT_ID =
            "SELECT id, " +
                    "score, " +
                    "comment, " +
                    "product_id " +
                    "FROM comments " +
                    "WHERE product_id=:product_id " +
                    "LIMIT :pagePerNum OFFSET :offset;";

}
