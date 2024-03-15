package com.FiapTravel.service;

import com.FiapTravel.record.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.verify;

class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        emailService = new EmailService(mailSender);
    }

    @Test
    void sendEmail_ShouldSendEmailSuccessfully() {
        // Arrange
        Email email = new Email("recipient@example.com", "Test Subject", "Test Body");

        // Act
        emailService.sendEmail(email);

        // Assert
        verify(mailSender).send(createExpectedMailMessage(email));
    }

    private SimpleMailMessage createExpectedMailMessage(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreplay@email.com");
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        return message;
    }
}
