package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_ClienteValido_SalvarComSucesso() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setId(UUID.randomUUID());

        // Act
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente savedCliente = clienteService.save(cliente);

        // Assert
        assertNotNull(savedCliente);
        assertEquals(cliente.getId(), savedCliente.getId());
    }

    @Test
    void save_ClienteNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> clienteService.save(null));
    }

    @Test
    void buscarTodosClientes_ClientesPresentes_RetornarListaCorreta() {
        // Arrange
        List<Cliente> clientes = List.of(new Cliente(), new Cliente());

        // Act
        when(clienteRepository.findAll()).thenReturn(clientes);
        List<Cliente> foundClientes = clienteService.buscarTodosClientes();

        // Assert
        assertEquals(clientes.size(), foundClientes.size());
    }

    // Outros métodos de teste para buscarTodosClientes() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarCliente e deletarCliente
}
