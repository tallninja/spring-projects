/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 11:33 AM
 */
package com.tallninja.todoapp.mapper;

import com.tallninja.todoapp.domain.User;
import com.tallninja.todoapp.dto.user.CreateUserDto;
import com.tallninja.todoapp.dto.user.GetUserDto;
import com.tallninja.todoapp.dto.user.UpdateUserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public GetUserDto toGetUserDto(User user) {
        return GetUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .displayPicture(user.getDisplayPicture())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User toUser(CreateUserDto createUserDto) {
        return User.builder()
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .build();
    }

    public User toUser(UpdateUserDto updateUserDto) {
        return User.builder()
                .firstName(updateUserDto.getFirstName())
                .lastName(updateUserDto.getLastName())
                .email(updateUserDto.getEmail())
                .password(updateUserDto.getPassword())
                .build();
    }

}
