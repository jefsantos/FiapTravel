package com.FiapTravel.controller;

import com.FiapTravel.record.Email;
import com.FiapTravel.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EmailControllerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailController emailController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSendEmail() {
        Email email = new Email(null, null, null);

        assertDoesNotThrow(() -> emailController.sendEmail(email));
    }
}
