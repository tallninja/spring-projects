/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 8:36 AM
 */
package com.tallninja.todoapp.service;

import com.tallninja.todoapp.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    Optional<User> findOne(UUID id);
    User findOneOrElseThrow(UUID id) throws Exception;
    Optional<User> findOne(String email);
    User findOneOrElseThrow(String email) throws Exception;
    User save(User user) throws Exception;
    User update(UUID id, User userData) throws Exception;
    Optional<User> delete(UUID id);
}
