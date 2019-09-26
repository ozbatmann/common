package com.common.common.dao.auth;

import com.common.common.model.auth.Auth;
import com.common.common.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AuthDao extends JpaRepository<Auth, Serializable> {

    Auth findByAuthUser(User user);
    Auth findByToken(String token);
}
