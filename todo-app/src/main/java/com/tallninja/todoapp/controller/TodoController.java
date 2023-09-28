/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 12:36 PM
 */
package com.tallninja.todoapp.controller;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.dto.todo.CreateTodoDto;
import com.tallninja.todoapp.dto.todo.GetTodoDto;
import com.tallninja.todoapp.dto.todo.UpdateTodoDto;
import com.tallninja.todoapp.mapper.TodoMapper;
import com.tallninja.todoapp.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    public ResponseEntity<List<GetTodoDto>> findApp() {
        List<Todo> todos = todoService.findAll();
        List<GetTodoDto> getTodoDtos = todos.stream()
                .map(todoMapper::toGetTodoDto)
                .toList();
        return ResponseEntity.ok(getTodoDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTodoDto> findOne(@PathVariable UUID id) throws Exception {
        Todo todo = todoService.findOneOrElseThrow(id);
        GetTodoDto getTodoDto = todoMapper.toGetTodoDto(todo);
        return ResponseEntity.ok(getTodoDto);
    }

    @PostMapping
    public ResponseEntity<GetTodoDto> create(
            @RequestBody CreateTodoDto createTodoDto,
            HttpServletRequest request
    ) throws Exception {
        Todo todo = todoService.save(todoMapper.toTodo(createTodoDto));
        GetTodoDto getTodoDto = todoMapper.toGetTodoDto(todo);
        URI location = new URI(request.getRequestURI());
        return ResponseEntity.created(location).body(getTodoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetTodoDto> update(
            @PathVariable UUID id,
            @RequestBody UpdateTodoDto updateTodoDto
    ) throws Exception {
        Todo todo = todoService.update(id, todoMapper.toTodo(updateTodoDto));
        GetTodoDto getTodoDto = todoMapper.toGetTodoDto(todo);
        return ResponseEntity.ok(getTodoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
