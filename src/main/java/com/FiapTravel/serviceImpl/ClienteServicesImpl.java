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
public class ClienteServicesImpl implements ClienteService{

    @Autowired
    ClienteRepository repo;


    @Override
    public Cliente save(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return repo.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return repo.findById(id);
    }

    @Override
    public void deletarCliente(UUID id) {
        repo.deleteById(id);
    }
}
