package com.FiapTravel.controller;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@PostMapping("/cadastroCliente")
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente obj){
		Cliente novoItem = service.save(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
		
	}
	
	@GetMapping("/listarClientes")
	public ResponseEntity<?> findAll(){
		List<Cliente> ListaDeClientes = service.buscarTodosClientes();
		if(!ListaDeClientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(ListaDeClientes);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não há Clientes");
		}

	}
	
	@GetMapping("/buscarClientePorId/{id}")
	public ResponseEntity<?> findById(@PathVariable UUID id){
		Optional<Cliente> cliente = service.buscarPorId(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente);
		}else {
			return ResponseEntity.badRequest().body("Cliente não encontrado");
		}
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable UUID id) {
        try {
            service.deletarCliente(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir Cliente: " + e.getMessage());
        }
    }
	
	

}
