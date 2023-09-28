/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 10:10 AM
 */
package com.tallninja.todoapp.controller;

import com.tallninja.todoapp.domain.User;
import com.tallninja.todoapp.dto.user.CreateUserDto;
import com.tallninja.todoapp.dto.user.GetUserDto;
import com.tallninja.todoapp.dto.user.UpdateUserDto;
import com.tallninja.todoapp.mapper.UserMapper;
import com.tallninja.todoapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<GetUserDto>> findAll() {
        List<User> users = userService.findAll();
        List<GetUserDto> getUserDtos = users.stream()
                .map(userMapper::toGetUserDto)
                .toList();
        return ResponseEntity.ok(getUserDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> findOne(@PathVariable UUID id) throws Exception {
        User user = userService.findOneOrElseThrow(id);
        GetUserDto getUserDto = userMapper.toGetUserDto(user);
        return ResponseEntity.ok(getUserDto);
    }

    @PostMapping
    public ResponseEntity<GetUserDto> create(
            @RequestBody CreateUserDto createUserDto,
            HttpServletRequest request
    ) throws Exception {
        User user = userService.save(userMapper.toUser(createUserDto));
        GetUserDto getUserDto = userMapper.toGetUserDto(user);
        URI location = new URI(request.getRequestURI());
        return ResponseEntity.created(location).body(getUserDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetUserDto> update(
            @PathVariable UUID id,
            @RequestBody UpdateUserDto updateUserDto
    ) throws Exception {
        User user = userService.update(id, userMapper.toUser(updateUserDto));
        GetUserDto getUserDto = userMapper.toGetUserDto(user);
        return ResponseEntity.ok(getUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
