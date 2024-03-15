package com.FiapTravel.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.FiapTravel.record.Email;

@Service
public class EmailService {

	private final JavaMailSender mailSender;

	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendEmail(Email email) {
		
		var message = new SimpleMailMessage();
		
		message.setFrom("noreplay@email.com");
		message.setTo(email.to());
		message.setSubject(email.subject());
		message.setText(email.body());
		mailSender.send(message);
		
		
	}
	
	
	
}
