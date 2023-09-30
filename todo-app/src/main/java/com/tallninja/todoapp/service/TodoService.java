/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 8:55 AM
 */
package com.tallninja.todoapp.service;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoService {
    List<Todo> findAll();
    Page<Todo> findAll(Pageable pageable);
    List<Todo> findAll(User user);
    Page<Todo> findAll(User user, Pageable pageable);
    Optional<Todo> findOne(UUID id);
    Todo findOneOrElseThrow(UUID id) throws Exception;
    Todo save(Todo todo) throws Exception;
    Todo update(UUID id, Todo todoData) throws Exception;
    Optional<Todo> delete(UUID id);
}
