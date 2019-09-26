package com.common.common.dao.user;

import com.common.common.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.UUID;

public interface UserDao  extends JpaRepository<User, Serializable> {

    User findById(UUID userId);
    User findByPhone(String phone);
    User findByUsername(String username);
}
