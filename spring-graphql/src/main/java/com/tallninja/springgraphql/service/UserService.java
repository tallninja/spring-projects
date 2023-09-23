package com.tallninja.springgraphql.service;

import com.tallninja.springgraphql.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll() throws Exception;
    User findById(Integer id) throws Exception;
}
