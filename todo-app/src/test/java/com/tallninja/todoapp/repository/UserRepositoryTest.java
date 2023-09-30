/**
 * Author: Ernest Wambua
 * Email: ernestwambua2@gmail.com
 * Date: 9/28/23 : 5:32 PM
 */
package com.tallninja.todoapp.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    private void initializeUsers() {
        
    }

    @Test
    public void findUserByEmailShouldReturnUser() {
        final String email = "ernestwambua2@gmail.com";

    }

}