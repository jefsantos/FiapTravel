package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Reserva;
import com.FiapTravel.repository.ReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ReservaServiceImplTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_ReservaValida_SalvarComSucesso() {
        // Arrange
        Reserva reserva = new Reserva();
        UUID id = UUID.randomUUID();

        // Act
        when(reservaRepository.save(reserva)).thenReturn(reserva);
        Reserva savedReserva = reservaService.save(reserva);

        // Assert
        assertNotNull(savedReserva);
        assertEquals(reserva, savedReserva);
    }

    @Test
    void save_ReservaNula_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> reservaService.save(null));
    }

    @Test
    void buscarTodasReservas_ReservasPresentes_RetornarListaCorreta() {
        // Arrange
        List<Reserva> reservas = List.of(new Reserva(), new Reserva());

        // Act
        when(reservaRepository.findAll()).thenReturn(reservas);
        List<Reserva> foundReservas = reservaService.buscarTodasReservas();

        // Assert
        assertEquals(reservas.size(), foundReservas.size());
    }

    // Outros métodos de teste para buscarTodasReservas() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarReserva e deletarReserva
}
