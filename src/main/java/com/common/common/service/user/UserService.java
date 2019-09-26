package com.common.common.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.common.common.dao.user.UserDao;
import com.common.common.dto.base.BaseDto;
import com.common.common.dto.base.ErrorDto;
import com.common.common.dto.base.ObjectDto;
import com.common.common.dto.base.SuccessDto;
import com.common.common.dto.user.UserDto;
import com.common.common.model.user.User;
import com.common.common.request.user.UserRequest;
import com.common.common.service.auth.AuthService;
import com.common.common.util.user.register.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthService authService;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public BaseDto getUser(String userId) {
        BaseDto baseDto;

        try {
            User user = this.userDao.findById(UUID.fromString(userId));
            baseDto = new ObjectDto<>(user);
            baseDto.setMessage("User successfully found");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto getUserDetails(HttpServletRequest request) {
        BaseDto baseDto;

        try {
            String token = request.getHeader("Authorization").substring(7);
            User user = authService.getUserByToken(token);
            UserDto userDto = new UserDto();
            userDto.setId(user.getId().toString());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setUsername(user.getUsername());
            userDto.setAge(user.getAge());
            userDto.setWeight(user.getWeight());
            userDto.setBio(user.getBio());
            userDto.setBloodType(user.getBloodType());
            userDto.setPhone(user.getPhone());
            userDto.setPicture(user.getPicture());
            baseDto = new ObjectDto<>(userDto);
            baseDto.setMessage("User successfully found");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto registerUser(UserRequest userRequest) {
        BaseDto baseDto;

        try {

            byte[] salt = SaltGenerator.generateSalt();
            byte[] password = BCrypt.withDefaults().hash(6, salt, userRequest.getPassword().getBytes(StandardCharsets.UTF_8));

            User user = new User();

            user.setName(userRequest.getName());
            user.setSurname(userRequest.getSurname());
            user.setAge(userRequest.getAge());
            user.setBio(userRequest.getBio());
            user.setWeight(userRequest.getWeight());
            user.setBloodType(userRequest.getBloodType());
            user.setBirthDate(formatter.parse(userRequest.getBirthDate()));
            user.setPhone(userRequest.getPhone());
            user.setSalt(salt);
            user.setPassword(password);
            user.setUsername(userRequest.getUsername());

            this.userDao.save(user);
            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully registered");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

    public BaseDto deleteUser(String userId) {
        BaseDto baseDto;

        try {
            User user = this.userDao.findById(UUID.fromString(userId));
            this.userDao.delete(user);
            baseDto = new SuccessDto();
            baseDto.setMessage("User successfully deleted");
            baseDto.setStatus(200);

        } catch (Exception ex) {
            baseDto = new ErrorDto();
            baseDto.setMessage(ex.getMessage());
            baseDto.setStatus(500);
        }

        return baseDto;
    }

}

