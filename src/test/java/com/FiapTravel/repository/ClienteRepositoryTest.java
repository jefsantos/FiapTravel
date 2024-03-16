package com.FiapTravel.repository;

import com.FiapTravel.model.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Cliente> expectedClientes = Arrays.asList(
                new Cliente(UUID.randomUUID(), null, "Brasil", "12345678901", null, "João", "1990-01-01",
                        "Rua A", "12345-678", "São Paulo", "Centro", "SP"),
                new Cliente(UUID.randomUUID(), null, "EUA", "98765432109", null, "John", "1985-05-10",
                        "Street B", "54321-987", "New York", "Downtown", "NY")
        );
        ClienteRepository clienteRepositoryMock = Mockito.mock(ClienteRepository.class);
        when(clienteRepositoryMock.findAll()).thenReturn(expectedClientes);

        // Act
        List<Cliente> actualClientes = clienteRepositoryMock.findAll();

        // Assert
        assertEquals(expectedClientes, actualClientes);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Cliente expectedCliente = new Cliente(id, null, "Brasil", "12345678901", null, "João", "1990-01-01",
                "Rua A", "12345-678", "São Paulo", "Centro", "SP");
        ClienteRepository clienteRepositoryMock = Mockito.mock(ClienteRepository.class);
        when(clienteRepositoryMock.findById(id)).thenReturn(Optional.of(expectedCliente));

        // Act
        Optional<Cliente> actualClienteOptional = clienteRepositoryMock.findById(id);

        // Assert
        assertTrue(actualClienteOptional.isPresent());
        assertEquals(expectedCliente, actualClienteOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Cliente clienteToSave = new Cliente(id, null, "Brasil", "12345678901", null, "João", "1990-01-01",
                "Rua A", "12345-678", "São Paulo", "Centro", "SP");
        ClienteRepository clienteRepositoryMock = Mockito.mock(ClienteRepository.class);
        when(clienteRepositoryMock.save(clienteToSave)).thenReturn(clienteToSave);

        // Act
        Cliente savedCliente = clienteRepositoryMock.save(clienteToSave);

        // Assert
        assertEquals(clienteToSave, savedCliente);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        ClienteRepository clienteRepositoryMock = Mockito.mock(ClienteRepository.class);

        // Act
        clienteRepositoryMock.deleteById(id);

        // Assert
        verify(clienteRepositoryMock, times(1)).deleteById(id);
    }
}