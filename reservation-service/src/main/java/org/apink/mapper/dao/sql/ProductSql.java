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
    public final static String COUNT_ALL = "SELECT count(*) count  FROM product";
    public final static String COUNT_BY_CATEGORY = "SELECT count(*) count  FROM product WHERE category_id=:id";

    public final static String SELECT_PRODUCT_NAME_BY_PRODUCT_ID =
            "SELECT name "
                    + "FROM product "
                    + "WHERE id = :productId";
    public final static String SELECT_PLACE_NAME_BY_PRODUCT_ID =
            "SELECT place_name "
                    + "FROM display_info "
                    + "WHERE product_id = :productId";
    public static final String SELECT_BY_PRODUCT_ID =
            "SELECT * "
                    + "FROM  (display_info A right outer join product_detail B on A.product_id = B.product_id ) right outer join product C on B.product_id= C.id "
                    + "WHERE C.id = :id ";
    public static final String SELECT_REPRSENT_IMG_BY_PRODUCT_ID =
            "SELECT file_id "
                    + "FROM product_image "
                    + "WHERE product_id=:id and type = 1 ;";
    public static final String SELECT_IMAGES_BY_PRODUCT_ID =
            "SELECT file_id "
                    + "FROM product_image "
                    + "WHERE product_id = :productId "
                    + "order by type DESC ;";
    public static final String SELECT_PRICES_BY_PRODUCT_ID =
            "SELECT * "
                    + "FROM product_price "
                    + "WHERE product_id = :productId ";
    public static final String SELECT_PLACE_NAME_BY_PRODUCT_ID_LIST =
            "SELECT product_id, place_name "
                    + "FROM display_info "
                    + "WHERE product_id in (:productIdList)";
}
