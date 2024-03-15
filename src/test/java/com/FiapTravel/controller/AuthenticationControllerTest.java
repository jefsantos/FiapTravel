package com.FiapTravel.controller;

import com.FiapTravel.model.User;
import com.FiapTravel.repository.UserRepository;
import com.FiapTravel.user.request.UserAuthRequest;
import com.FiapTravel.user.request.UserRequest;
import com.FiapTravel.user.security.TokenService;
import com.FiapTravel.user.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testLogin() {
        UserAuthRequest userAuthRequest = new UserAuthRequest("username", "password");
        User user = new User("username", "password", "ROLE_USER");

        when(authenticationManager.authenticate(any())).thenReturn(new UsernamePasswordAuthenticationToken(user, null));
        when(tokenService.generateToken(any())).thenReturn("generatedToken");

        ResponseEntity responseEntity = authenticationController.login(userAuthRequest);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals("generatedToken", ((UserResponse)responseEntity.getBody()).getToken());
    }

    @Test
    void testRegister() {
        UserRequest userRequest = new UserRequest("username", "password", "ROLE_USER");

        when(userRepository.findByLogin(any())).thenReturn(null);

        ResponseEntity responseEntity = authenticationController.register(userRequest);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void testRegisterUserAlreadyExists() {
        UserRequest userRequest = new UserRequest("username", "password", "ROLE_USER");
        User existingUser = new User("username", "password", "ROLE_USER");

        when(userRepository.findByLogin(any())).thenReturn(existingUser);

        ResponseEntity responseEntity = authenticationController.register(userRequest);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
