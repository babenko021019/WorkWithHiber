package com.mainacad.dao;

import com.mainacad.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    List<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();

        User user = new User("babenko021019", "12345", "Alex",
                "Babenko", "test@email.com", "0501234567");

        users.add(user);
    }

//    @AfterEach
//    void tearDown() {
//        users.forEach(it -> UserDAO.delete(it));
//    }

    @Test
    void saveAndGetAndDelete() {

        User savedUser = UserDAO.save(users.get(0));
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());

        User retrievedUser = UserDAO.findOne(savedUser.getId());
        assertNotNull(retrievedUser);
        assertEquals("babenko021019", retrievedUser.getLogin());

        UserDAO.delete(retrievedUser);

        User deletedUser = UserDAO.findOne(savedUser.getId());
        assertNull(deletedUser);
    }
}