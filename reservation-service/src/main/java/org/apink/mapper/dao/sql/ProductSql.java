package org.apink.mapper.dao.sql;

public class ProductSql {
    public final static String SELECT_ALL =
            "SELECT products.id AS id, " +
                    "represent_file_id, " +
                    "name, " +
                    "description, " +
                    "place_name " +
                    "FROM products LEFT OUTER JOIN products_display " +
                    "ON products.id = products_display.product_id " +
                    "LIMIT :pagePerNum OFFSET :offset;";

    public final static String SELECT_BY_CATEGORY_ID =
            "SELECT products.id AS id, " +
                    "represent_file_id, " +
                    "name, " +
                    "description, " +
                    "place_name " +
                    "FROM products LEFT OUTER JOIN products_display " +
                    "ON products.id = products_display.product_id " +
                    "WHERE category_id=:category_id " +
                    "LIMIT :pagePerNum OFFSET :offset;";

    public final static String COUNT_ALL =
            "SELECT count(*) AS count " +
                    "FROM products";

    public final static String SELECT_BY_ID =
            "SELECT products.id AS id, " +
                    "represent_file_id, " +
                    "name, " +
                    "description, " +
                    "event, "+
                    "comment_count, "+
                    "total_score, "+
                    "place_name, " +
                    "place_lot, "+
                    "place_street, "+
                    "tel, "+
                    "homepage, "+
                    "email, "+
                    "content "+
                    "FROM products LEFT OUTER JOIN products_display " +
                    "ON products.id = products_display.product_id " +
                    "LEFT OUTER JOIN products_detail " +
                    "ON products.id = products_detail.product_id " +
                    "WHERE products.id=:product_id ";

    public static final String SELECT_SUMMARY_BY_PRODUCT_ID =
            "SELECT p.id, p.name, p.represent_file_id, p.description, p.sales_start, p.sales_end, " +
                    "pd.display_start, pd.display_end, pd.place_name, pd.place_lot, pd.place_street " +
                    "FROM products AS p LEFT OUTER JOIN products_display AS pd " +
                    "ON p.id = pd.product_id " +
                    "WHERE p.id = :product_id";

    public static final String SELECT_PRICES_BY_PRODUCT_ID =
            "SELECT pp.id, pp.price, pp.discount_rate, " +
                    "ppt.product_price_type, ppt.description " +
                    "FROM products_prices AS pp INNER JOIN products_prices_types AS ppt " +
                    "ON pp.product_price_type_id = ppt.id " +
                    "WHERE pp.product_id = :product_id ";

    public static final String SELECT_BY_PRODUCT_ID =
            "SELECT name, comment_count, total_score " +
                    "FROM products " +
                    "WHERE id= :id";
}