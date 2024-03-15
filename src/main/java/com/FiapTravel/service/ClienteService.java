package com.FiapTravel.service;

import com.FiapTravel.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteService {
	
	Cliente save (Cliente cliente);
	List<Cliente> buscarTodosClientes();
	Optional<Cliente> buscarPorId(UUID id);
	void deletarCliente (UUID id);
	

}