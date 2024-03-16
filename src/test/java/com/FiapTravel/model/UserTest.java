package com.FiapTravel.model;

import com.FiapTravel.model.enums.UserRole;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String login = "user123";
        String password = "password123";
        UserRole role = UserRole.ADMIN;

        // Act
        User user = new User(login, password, role);

        // Assert
        assertNotNull(user.getId());
        assertEquals(login, user.getLogin());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
    }

    @Test
    public void testToString() {
        // Arrange
        String login = "user123";
        String password = "password123";
        UserRole role = UserRole.ADMIN;
        String expectedToString = "User(id=null, login=user123, password=password123, role=ADMIN)";

        // Act
        User user = new User(login, password, role);
        String actualToString = user.toString();

        // Assert
        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void testSetterAndGetters() {
        // Arrange
        User user = new User();
        UUID id = UUID.fromString("123456");
        String login = "user123";
        String password = "password123";
        UserRole role = UserRole.ADMIN;

        // Act
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        // Assert
        assertEquals(id, user.getId());
        assertEquals(login, user.getLogin());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
    }
}