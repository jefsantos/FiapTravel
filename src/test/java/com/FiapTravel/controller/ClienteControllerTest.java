package com.FiapTravel.controller;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarCliente() {
        Cliente cliente = new Cliente();
        when(clienteService.save(any())).thenReturn(cliente);

        ResponseEntity<Cliente> responseEntity = clienteController.criarCliente(cliente);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosClientes() {
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);
        when(clienteService.buscarTodosClientes()).thenReturn(clientes);

        ResponseEntity<List<Cliente>> responseEntity = clienteController.buscarTodosClientes();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clientes, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        UUID id = UUID.randomUUID();
        Cliente cliente = new Cliente();
        when(clienteService.buscarPorId(id)).thenReturn(Optional.of(cliente));

        ResponseEntity<Cliente> responseEntity = clienteController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        UUID id = UUID.randomUUID();
        when(clienteService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Cliente> responseEntity = clienteController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarClienteExistente() {
        UUID id = UUID.randomUUID();
        Cliente cliente = new Cliente();
        when(clienteService.atualizarCliente(any(), any())).thenReturn(cliente);

        ResponseEntity<Cliente> responseEntity = clienteController.atualizarCliente(id, cliente);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(cliente, responseEntity.getBody());
    }

    @Test
    void testAtualizarClienteInexistente() {
        UUID id = UUID.randomUUID();
        Cliente cliente = new Cliente();
        when(clienteService.atualizarCliente(any(), any())).thenReturn(null);

        ResponseEntity<Cliente> responseEntity = clienteController.atualizarCliente(id, cliente);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarCliente() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = clienteController.deletarCliente(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(clienteService, times(1)).deletarCliente(id);
    }
}
