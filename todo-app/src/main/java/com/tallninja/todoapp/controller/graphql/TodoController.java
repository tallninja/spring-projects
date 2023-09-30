/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/30/23 : 8:20 AM
 */
package com.tallninja.todoapp.controller.graphql;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.domain.User;
import com.tallninja.todoapp.dto.todo.CreateTodoDto;
import com.tallninja.todoapp.dto.todo.UpdateTodoDto;
import com.tallninja.todoapp.mapper.TodoMapper;
import com.tallninja.todoapp.service.TodoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller("graphqlTodoController")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @QueryMapping
    public List<Todo> todos() {
        return todoService.findAll();
    }

    @QueryMapping
    public Todo todoById(@Argument UUID id) throws Exception {
        return todoService.findOneOrElseThrow(id);
    }

    @MutationMapping
    public Todo createTodo(@Argument CreateTodoDto createTodoInput) throws Exception {
        Todo todo = todoMapper.toTodo(createTodoInput);
        return todoService.save(todo);
    }

    @MutationMapping
    public Todo updateTodo(@Argument UUID id, @Argument UpdateTodoDto updateTodoInput) throws Exception {
        Todo todo = todoMapper.toTodo(updateTodoInput);
        return todoService.update(id, todo);
    }

    @MutationMapping
    public Optional<Todo> deleteTodo(@Argument UUID id) {
        return todoService.delete(id);
    }

    @SchemaMapping
    public User user(Todo todo) throws Exception {
        return todoService.findOneOrElseThrow(todo.getId()).getUser();
    }

}
