package com.common.common.service.user;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.common.common.dao.user.UserDao;
import com.common.common.model.user.User;
import com.common.common.util.auth.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);

    }
    public void validatePassword(String username, String password) throws Exception {
        User user = userDao.findByUsername(username);
        byte[] pw = BCrypt.withDefaults().hash(6, user.getSalt(), password.getBytes(StandardCharsets.UTF_8));

        if(!Arrays.equals(user.getPassword(),pw)){
            throw new Exception("Wrong Password");
        }

    }
}