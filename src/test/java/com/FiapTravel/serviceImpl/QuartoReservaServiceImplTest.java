package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.QuartoReserva;
import com.FiapTravel.model.QuartoReservaId;
import com.FiapTravel.repository.QuartoReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class QuartoReservaServiceImplTest {

    @Mock
    private QuartoReservaRepository quartoReservaRepository;

    @InjectMocks
    private QuartoReservaServiceImpl quartoReservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_QuartoReservaValido_SalvarComSucesso() {
        // Arrange
        QuartoReserva quartoReserva = new QuartoReserva();
        QuartoReservaId id = new QuartoReservaId();

        // Act
        when(quartoReservaRepository.save(quartoReserva)).thenReturn(quartoReserva);
        QuartoReserva savedQuartoReserva = quartoReservaService.save(quartoReserva);

        // Assert
        assertNotNull(savedQuartoReserva);
        assertEquals(quartoReserva, savedQuartoReserva);
    }

    @Test
    void save_QuartoReservaNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> quartoReservaService.save(null));
    }

    @Test
    void buscarTodasQuartoReservas_QuartoReservasPresentes_RetornarListaCorreta() {
        // Arrange
        List<QuartoReserva> quartoReservas = List.of(new QuartoReserva(), new QuartoReserva());

        // Act
        when(quartoReservaRepository.findAll()).thenReturn(quartoReservas);
        List<QuartoReserva> foundQuartoReservas = quartoReservaService.buscarTodasQuartoReservas();

        // Assert
        assertEquals(quartoReservas.size(), foundQuartoReservas.size());
    }

    // Outros métodos de teste para buscarTodasQuartoReservas() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarQuartoReserva e deletarQuartoReserva
}
