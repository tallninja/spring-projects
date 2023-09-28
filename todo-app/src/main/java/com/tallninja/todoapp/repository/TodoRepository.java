/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 8:27 AM
 */
package com.tallninja.todoapp.repository;

import com.tallninja.todoapp.domain.Todo;
import com.tallninja.todoapp.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {

    List<Todo> findByUser(User user);
    Page<Todo> findByUser(User user, Pageable pageable);

}
