/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 11:40 AM
 */
package com.tallninja.todoapp.mapper;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.dto.todo.CreateTodoDto;
import com.tallninja.todoapp.dto.todo.GetTodoDto;
import com.tallninja.todoapp.dto.todo.UpdateTodoDto;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public GetTodoDto toGetTodoDto(Todo todo) {
        return GetTodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .done(todo.getDone())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }

    public Todo toTodo(CreateTodoDto createTodoDto) {
        return Todo.builder()
                .title(createTodoDto.getTitle())
                .description(createTodoDto.getDescription())
                .user(createTodoDto.getUser())
                .done(false)
                .build();
    }

    public Todo toTodo(UpdateTodoDto updateTodoDto) {
        return Todo.builder()
                .title(updateTodoDto.getTitle())
                .description(updateTodoDto.getDescription())
                .done(updateTodoDto.getDone())
                .build();
    }

}
