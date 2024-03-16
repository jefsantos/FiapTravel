package com.FiapTravel.repository;

import com.FiapTravel.model.*;
import com.FiapTravel.service.OpcionalReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class OpcionalReservaRepositoryTest {

    @Mock
    private OpcionalReservaRepository opcionalReservaRepository;

    @InjectMocks
    private OpcionalReservaService opcionalReservaService; // Supondo que existe uma classe de serviço para OpcionalReserva

    private OpcionalReserva opcionalReserva;

    @BeforeEach
    public void setup() {
        // Configura um opcionalReserva simulado antes de cada teste
        Localidade localidade = new Localidade(/* dados da localidade */);
        Reserva reserva = new Reserva(/* dados da reserva */);
        Opcional opcional = new Opcional(/* dados do opcional */);
        OpcionalReservaId id = new OpcionalReservaId();
        opcionalReserva = new OpcionalReserva(id, localidade, reserva, opcional, 2);
    }

    @Test
    public void testSaveOpcionalReserva() {
        // Configura o comportamento simulado do repositório para salvar a opcionalReserva
        when(opcionalReservaRepository.save(opcionalReserva)).thenReturn(opcionalReserva);

        // Chama o método da classe de serviço que salva a opcionalReserva
        OpcionalReserva savedOpcionalReserva = opcionalReservaService.save(opcionalReserva);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à opcionalReserva simulada
        verify(opcionalReservaRepository, times(1)).save(opcionalReserva);
        assertEquals(opcionalReserva, savedOpcionalReserva);
    }

    @Test
    public void testFindById() {
        // Configura o comportamento simulado do repositório para encontrar a opcionalReserva por ID
        when(opcionalReservaRepository.findById(opcionalReserva.getId())).thenReturn(Optional.of(opcionalReserva));

        // Chama o método da classe de serviço que encontra a opcionalReserva por ID
        Optional<OpcionalReserva> foundOpcionalReserva = opcionalReservaService.buscarPorId(opcionalReserva.getId());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à opcionalReserva simulada
        verify(opcionalReservaRepository, times(1)).findById(opcionalReserva.getId());
        assertEquals(opcionalReserva, foundOpcionalReserva.get());
    }

    // Adicione outros casos de teste conforme necessário
}
