package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.OpcionalReserva;
import com.FiapTravel.model.OpcionalReservaId;
import com.FiapTravel.repository.OpcionalReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OpcionalReservaServiceImplTest {

    @Mock
    private OpcionalReservaRepository opcionalReservaRepository;

    @InjectMocks
    private OpcionalReservaServiceImpl opcionalReservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_OpcionalReservaValido_SalvarComSucesso() {
        // Arrange
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        OpcionalReservaId opcionalReservaId = new OpcionalReservaId();

        // Act
        when(opcionalReservaRepository.save(opcionalReserva)).thenReturn(opcionalReserva);
        OpcionalReserva savedOpcionalReserva = opcionalReservaService.save(opcionalReserva);

        // Assert
        assertNotNull(savedOpcionalReserva);
        assertEquals(opcionalReserva, savedOpcionalReserva);
    }

    @Test
    void save_OpcionalReservaNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> opcionalReservaService.save(null));
    }

    @Test
    void buscarTodosOpcionaisReserva_OpcionaisReservaPresentes_RetornarListaCorreta() {
        // Arrange
        List<OpcionalReserva> opcionaisReserva = List.of(new OpcionalReserva(), new OpcionalReserva());

        // Act
        when(opcionalReservaRepository.findAll()).thenReturn(opcionaisReserva);
        List<OpcionalReserva> foundOpcionaisReserva = opcionalReservaService.buscarTodosOpcionaisReserva();

        // Assert
        assertEquals(opcionaisReserva.size(), foundOpcionaisReserva.size());
    }

    // Outros métodos de teste para buscarTodosOpcionaisReserva() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarOpcionalReserva e deletarOpcionalReserva
}
