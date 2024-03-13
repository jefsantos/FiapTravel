package com.FiapTravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.services.LocalidadeService;

@RestController
public class LocalidadeController {
	
	@Autowired
	LocalidadeService service;
	
	@PostMapping("/cadastroLocalidade")
	public ResponseEntity<?> cadastrarLocalidade(@RequestBody Localidade obj){
		Localidade novoItem = service.save(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
		
	}
	
	
	
	
	@GetMapping("/test")
	public String retornaString() {
		return "FUNCIONANDO";
	}

}
