package com.example.clothes;

import com.example.clothes.security.User;
import com.example.clothes.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

@SpringBootTest
@Transactional
public class UserAuthTests {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Test
    @DisplayName("Testing signup with mock user")
    void signupDefault() {
        User testUser = User.builder()
                .username("Test")
                .password("pass")
                .firstName("samer")
                .lastName("el abassi")
                .active(true)
                .build();
        User user = userDetailsService.add(testUser);
        assertEquals(testUser.getUsername(), user.getUsername());
    }

    @Test
    @DisplayName("Testing signup with already used username")
    void signupAlreadyUsed() {
        User testUser = User.builder()
                .username("admin")
                .password("pass")
                .firstName("samer")
                .lastName("el abassi")
                .active(true)
                .build();
        Throwable thrown = assertThrows(DataIntegrityViolationException.class, () -> {
            userDetailsService.add(testUser);
        });
        assertTrue(thrown.getMessage().contains("constraint"));
    }

}
