package org.apink.service.implement;

import org.apink.domain.User;
import org.apink.mapper.dao.UserDao;
import org.apink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User getByUserId(int userId) {
        return userDao.selectByUserId(userId);

    }
}
