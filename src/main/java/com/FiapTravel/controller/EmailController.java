package com.FiapTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FiapTravel.record.Email;
import com.FiapTravel.service.EmailService;

@RestController
@RequestMapping
public class EmailController {

	@Autowired
	private  EmailService service;
	
	@PostMapping("/email")
	public void sendEmail (@RequestBody Email email) {
		service.sendEmail(email);
	}
	
}
