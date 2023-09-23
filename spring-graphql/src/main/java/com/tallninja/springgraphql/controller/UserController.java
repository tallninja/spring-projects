package com.tallninja.springgraphql.controller;

import com.tallninja.springgraphql.domain.User;
import com.tallninja.springgraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> users() throws Exception {
        return userService.findAll();
    }

    @QueryMapping
    public User user(@Argument Integer id) throws Exception {
        return userService.findById(id);
    }

}
