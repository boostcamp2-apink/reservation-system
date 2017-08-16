package org.apink.mapper.dao.sql;

public class UserSqls {

    public static final String SELECT_BY_ID =
            "SELECT username, tel, email " +
                    "FROM users " +
                    "WHERE id = :user_id";

    public final static String SELECT_USER_BY_SNS_ID =
            "SELECT  "
                    + "id, "
                    + "username username,"
                    + "email,"
                    + "nickname,"
                    + "sns_id,"
                    + "sns_profile profileImage "
                    + "FROM users "
                    + "WHERE sns_id=:sns_id AND sns_type = :sns_type ";


}
