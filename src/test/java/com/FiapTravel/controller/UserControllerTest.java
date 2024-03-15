package com.FiapTravel.controller;

import com.FiapTravel.model.User;
import com.FiapTravel.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Test
    public void testGetAllUsers() throws Exception {
        // Mocking repository data
        List<User> userList = new ArrayList<>();
        userList.add(new User("user1", "password1", null));
        userList.add(new User("user2", "password2", null));

        // Mocking repository behavior
        when(userRepository.findAll()).thenReturn(userList);

        // Setting up mockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // Performing GET request
        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].login").value("user1"))
                .andExpect(jsonPath("$[0].password").value("password1"))
                .andExpect(jsonPath("$[1].login").value("user2"))
                .andExpect(jsonPath("$[1].password").value("password2"));

        // Verifying that the userRepository's findAll method was called
        verify(userRepository, times(1)).findAll();
    }
}
