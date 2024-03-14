package com.FiapTravel.servicesImpl;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.repositories.ClienteRepository;
import com.FiapTravel.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
