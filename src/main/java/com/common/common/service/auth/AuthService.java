package com.common.common.service.auth;

import com.common.common.dao.auth.AuthDao;
import com.common.common.dao.user.UserDao;
import com.common.common.model.auth.Auth;
import com.common.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthDao authDao;
    @Autowired
    UserDao userDao;

    public void saveAuthInfo(String token, String username){

        User user = userDao.findByUsername(username);
        if(authDao.findByAuthUser(user) == null) {
            Auth authInfo = new Auth();
            authInfo.setToken(token);
            authInfo.setAuthUser(user);
            authDao.save(authInfo);
        }
        authDao.delete(authDao.findByAuthUser(user));
        Auth authInfo = new Auth();
        authInfo.setToken(token);
        authInfo.setAuthUser(user);
        authDao.save(authInfo);

    }
    public User getUserByToken(String token){
        User user = authDao.findByToken(token).getAuthUser();
        return user;
    }
}

