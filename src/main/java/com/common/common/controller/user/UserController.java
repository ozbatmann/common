package com.common.common.controller.user;

import com.common.common.dto.base.BaseDto;
import com.common.common.model.user.User;
import com.common.common.request.user.UserRequest;
import com.common.common.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public BaseDto get(@PathVariable String id) {
        return this.userService.getUser(id);
    }

    @RequestMapping(value = "/getUserDetails", method = RequestMethod.GET, produces = {"application/json"})
    public BaseDto getUserDetails(HttpServletRequest request) {
        return this.userService.getUserDetails(request);
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json"})
    public BaseDto register(@RequestBody UserRequest userRequest) {
        return this.userService.registerUser(userRequest);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public BaseDto delete(@PathVariable String id) {
        return this.userService.deleteUser(id);
    }
}
