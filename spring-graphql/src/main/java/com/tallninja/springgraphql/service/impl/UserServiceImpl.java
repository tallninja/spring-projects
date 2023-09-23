package com.tallninja.springgraphql.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tallninja.springgraphql.domain.User;
import com.tallninja.springgraphql.service.UserService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final File usersFile;
    private final ObjectMapper mapper;

    public UserServiceImpl(File usersFile, ObjectMapper mapper) {
        this.usersFile = usersFile;
        this.mapper = mapper;
    }

    @Override
    public List<User> findAll() throws Exception {
        return mapper.readValue(usersFile, new TypeReference<>() {
        });
    }

    @Override
    public User findById(Integer id) throws Exception {
        return findAll().stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .toList()
                .get(0);
    }
}
