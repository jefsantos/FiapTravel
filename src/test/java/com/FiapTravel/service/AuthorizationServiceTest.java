package com.FiapTravel.service;

import com.FiapTravel.model.User;
import com.FiapTravel.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorizationServiceTest {

    private UserRepository userRepository;
    private AuthorizationService authorizationService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        authorizationService = new AuthorizationService();
    }

    @Test
    void testLoadUserByUsername_ExistingUser() {
        // Arrange
        String username = "testUser";
        User user = new User();
        when(userRepository.findByLogin(username)).thenReturn(user);

        // Act
        UserDetails userDetails = authorizationService.loadUserByUsername(username);

        // Assert
        assertEquals(username, userDetails.getUsername());
        verify(userRepository, times(1)).findByLogin(username);
    }

    @Test
    void testLoadUserByUsername_NonExistingUser() {
        // Arrange
        String username = "nonExistingUser";
        when(userRepository.findByLogin(username)).thenReturn(null);

        // Act & Assert
        try {
            authorizationService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            assertEquals("User not found with username: " + username, e.getMessage());
        }
        verify(userRepository, times(1)).findByLogin(username);
    }
}