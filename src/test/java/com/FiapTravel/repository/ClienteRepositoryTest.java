package com.FiapTravel.repository;

import com.FiapTravel.model.Cliente;
import com.FiapTravel.model.User;
import com.FiapTravel.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService; // Supondo que existe uma classe de serviço para Cliente

    @Test
    public void testFindById() {
        // Cria um cliente simulado
        User user = new User();
        Cliente cliente = new Cliente(UUID.randomUUID(), user, "Brasil", "12345678901", "AB123456", "João", "1990-01-01",
                "Rua A", "12345-678", "São Paulo", "Centro", "SP");

        // Configura o comportamento simulado do repositório
        when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));

        // Chama o método da classe de serviço que usa o repositório
        Optional<Cliente> result = clienteService.buscarPorId(cliente.getId());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao cliente simulado
        verify(clienteRepository, times(1)).findById(cliente.getId());
        assertEquals(cliente.getNomeCliente(), result.get().getNomeCliente());
    }

    // Adicione outros casos de teste conforme necessário
}
