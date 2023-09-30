/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 8:06 AM
 */
package com.tallninja.todoapp.controller.graphql;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.domain.User;
import com.tallninja.todoapp.dto.user.CreateUserDto;
import com.tallninja.todoapp.dto.user.UpdateUserDto;
import com.tallninja.todoapp.mapper.UserMapper;
import com.tallninja.todoapp.service.TodoService;
import com.tallninja.todoapp.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller("graphqlUserController")
public class UserController {

    private final UserService userService;
    private final TodoService todoService;
    private final UserMapper userMapper;

    public UserController(UserService userService, TodoService todoService, UserMapper userMapper) {
        this.userService = userService;
        this.todoService = todoService;
        this.userMapper = userMapper;
    }

    @QueryMapping
    public List<User> users() {
        return userService.findAll();
    }

    @QueryMapping
    public User userById(@Argument UUID id) throws Exception {
        return userService.findOneOrElseThrow(id);
    }

    @QueryMapping
    public User userByEmail(@Argument String email) throws Exception {
        return userService.findOneOrElseThrow(email);
    }

    @MutationMapping
    public User createUser(@Argument CreateUserDto createUserInput) throws Exception {
        User user = userMapper.toUser(createUserInput);
        return userService.save(user);
    }

    @MutationMapping
    public User updateUser(@Argument UUID id, @Argument UpdateUserDto updateUserInput) throws Exception {
        User user = userMapper.toUser(updateUserInput);
        return userService.update(id, user);
    }

    @MutationMapping
    public Optional<User> deleteUser(@Argument UUID id) {
        return userService.delete(id);
    }

    @SchemaMapping
    public List<Todo> todos(User user) {
        return todoService.findAll(user);
    }

}
