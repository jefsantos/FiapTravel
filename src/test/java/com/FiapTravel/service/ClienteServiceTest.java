package com.FiapTravel.service;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.repository.ClienteRepository;
import com.FiapTravel.serviceImpl.ClienteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente();
        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente savedCliente = clienteService.save(cliente);

        Assertions.assertEquals(cliente, savedCliente);
    }

    @Test
    public void testBuscarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.buscarTodosClientes();

        Assertions.assertEquals(clientes, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Cliente> optional = Optional.of(new Cliente());
        Mockito.when(clienteRepository.findById(id)).thenReturn(optional);

        Optional<Cliente> result = clienteService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarCliente() {
        UUID id = UUID.randomUUID();
        clienteService.deletarCliente(id);
        Mockito.verify(clienteRepository, Mockito.times(1)).deleteById(id);
    }
}
