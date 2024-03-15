package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.repository.ClienteRepository;
import com.FiapTravel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
        }
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente atualizarCliente(UUID id, Cliente cliente) {
        if (id == null || cliente == null) {
            throw new IllegalArgumentException("O ID e o cliente não podem ser nulos.");
        }
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarCliente(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
        }
        clienteRepository.deleteById(id);
    }
}
