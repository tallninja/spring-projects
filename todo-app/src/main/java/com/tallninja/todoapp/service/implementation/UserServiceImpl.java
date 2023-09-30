/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 9:14 AM
 */
package com.tallninja.todoapp.service.implementation;

import com.tallninja.todoapp.domain.User;
import com.tallninja.todoapp.repository.UserRepository;
import com.tallninja.todoapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findOne(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User findOneOrElseThrow(UUID id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    String message = "User %s not found".formatted(id);
                    log.error(message);
                    return new Exception(message);
                });
    }

    @Override
    public Optional<User> findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findOneOrElseThrow(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    String message = "User %s not found".formatted(email);
                    log.error(message);
                    return new Exception(message);
                });
    }

    @Override
    public User save(User user) throws Exception {
        boolean userExists = findOne(user.getEmail()).isPresent();
        if (userExists) {
            String message = "User %s exist".formatted(user.getEmail());
            log.error(message);
            throw new Exception(message);
        }
        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, User userData) throws Exception {
        User user = findOneOrElseThrow(id);
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setEmail(userData.getEmail());
        user.setDisplayPicture(userData.getDisplayPicture());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> delete(UUID id) {
        Optional<User> user = findOne(id);
        user.ifPresent(userRepository::delete);
        return user;
    }
}
