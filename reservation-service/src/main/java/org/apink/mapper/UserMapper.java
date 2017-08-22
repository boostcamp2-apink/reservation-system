package org.apink.mapper;

import org.apink.domain.User;

public interface UserMapper {

    User selectByUserId(int userId);
}
