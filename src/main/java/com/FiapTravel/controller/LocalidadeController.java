package com.FiapTravel.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.services.LocalidadeService;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
	
	@Autowired
	LocalidadeService service;
	
	@PostMapping("/cadastroLocalidade")
	public ResponseEntity<?> cadastrarLocalidade(@RequestBody Localidade obj){
		Localidade novoItem = service.save(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
		
	}
	
	@GetMapping("/listarLocalidades")
	public ResponseEntity<?> findAll(){
		List<Localidade> ListaDeLocalidades = service.buscarTodasLocalidades();
		if(!ListaDeLocalidades.isEmpty()) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(ListaDeLocalidades);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não há Localidades");
		}

	}
	
	@GetMapping("/buscarLocalidadePorId")
	public ResponseEntity<?> findById(@PathVariable UUID id){
		Optional<Localidade> localidade = service.buscarPorId(id);
		
		if(localidade.isPresent()) {
			return ResponseEntity.ok(localidade);
		}else {
			return ResponseEntity.badRequest().body("Localidade não encontrada");
		}
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocalidade(@PathVariable UUID id) {
        try {
            service.deletarLocalidade(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir localidade: " + e.getMessage());
        }
    }
	
	

}
