package org.apink.service;

import org.apink.domain.User;

public interface UserService {

    User getByUserId(int userId);
}
