package com.FiapTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FiapTravel.model.Endereco;
import com.FiapTravel.model.Localidade;
import com.FiapTravel.services.EnderecoService;
import com.FiapTravel.services.LocalidadeService;

@RestController
public class EnderecoController {
	
	@Autowired
	EnderecoService service;
	
	@PostMapping("/cadastroEndereco")
	public ResponseEntity<?> cadastrarEndereco(@RequestBody Endereco obj){
		Endereco novoItem = service.save(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
		
		
	}
	
}
