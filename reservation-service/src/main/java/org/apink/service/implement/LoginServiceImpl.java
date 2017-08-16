package org.apink.service.implement;

import org.apink.domain.User;
import org.apink.mapper.dao.UserDao;
import org.apink.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    private UserDao userDao;


    @Autowired
    public LoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User LogIn(User user) {
        User alreadyUser = selectUser(user.getSnsId(), user.getSnsType());
        if (alreadyUser == null) {
            Integer newUserId = userDao.insert(user);
            return userDao.selectUser(newUserId, user.getSnsType());
        } else {
            return alreadyUser;
        }
    }

    private User selectUser(Integer snsId, String snsType) {
        return userDao.selectUser(snsId, snsType);
    }

}

