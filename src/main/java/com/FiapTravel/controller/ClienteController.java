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
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteService clienteService;
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
		Cliente novoCliente = clienteService.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodosClientes() {
		List<Cliente> clientes = clienteService.buscarTodosClientes();
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable UUID id) {
		Optional<Cliente> clienteOptional = clienteService.buscarPorId(id);
		return clienteOptional.map(cliente -> ResponseEntity.ok().body(cliente))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable UUID id, @RequestBody Cliente cliente) {
		Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
		if (clienteAtualizado != null) {
			return ResponseEntity.ok(clienteAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable UUID id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
}