/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 9:50 AM
 */
package com.tallninja.todoapp.service.implementation;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.domain.User;
import com.tallninja.todoapp.repository.TodoRepository;
import com.tallninja.todoapp.service.TodoService;
import com.tallninja.todoapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;

    public TodoServiceImpl(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Page<Todo> findAll(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    @Override
    public List<Todo> findAll(User user) {
        return todoRepository.findByUser(user);
    }

    @Override
    public Page<Todo> findAll(User user, Pageable pageable) {
        return todoRepository.findByUser(user, pageable);
    }

    @Override
    public Optional<Todo> findOne(UUID id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo findOneOrElseThrow(UUID id) throws Exception {
        return todoRepository.findById(id).orElseThrow(() -> {
            String message = "Todo %s not found".formatted(id);
            log.error(message);
            return new Exception(message);
        });
    }

    @Override
    public Todo save(Todo todo) throws Exception {
        User user = userService.findOneOrElseThrow(todo.getUser().getId());
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(UUID id, Todo todoData) throws Exception {
        Todo todo = findOneOrElseThrow(id);
        todo.setTitle(todoData.getTitle());
        todo.setDescription(todoData.getDescription());
        todo.setDone(todoData.getDone());
        return todoRepository.save(todo);
    }

    @Override
    public void delete(UUID id) {
        todoRepository.deleteById(id);
    }
}
