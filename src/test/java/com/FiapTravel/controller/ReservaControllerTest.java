package com.FiapTravel.controller;

import com.FiapTravel.model.Reserva;
import com.FiapTravel.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ReservaControllerTest {

    @Mock
    private ReservaService reservaService;

    @InjectMocks
    private ReservaController reservaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarReserva() {
        Reserva reserva = new Reserva(); // Seu objeto reserva para teste
        when(reservaService.save(reserva)).thenReturn(reserva);

        ResponseEntity<Reserva> response = reservaController.criarReserva(reserva);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(reserva, response.getBody());
    }

    @Test
    void testBuscarTodasReservas() {
        List<Reserva> reservas = new ArrayList<>(); // Sua lista de reservas para teste
        when(reservaService.buscarTodasReservas()).thenReturn(reservas);

        ResponseEntity<List<Reserva>> response = reservaController.buscarTodasReservas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservas, response.getBody());
    }

    @Test
    void testBuscarPorId() {
        UUID id = UUID.randomUUID(); // Seu UUID para teste
        Reserva reserva = new Reserva(); // Seu objeto reserva para teste
        when(reservaService.buscarPorId(id)).thenReturn(Optional.of(reserva));

        ResponseEntity<Reserva> response = reservaController.buscarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reserva, response.getBody());
    }

    @Test
    void testAtualizarReserva() {
        UUID id = UUID.randomUUID(); // Seu UUID para teste
        Reserva reserva = new Reserva(); // Seu objeto reserva para teste
        when(reservaService.atualizarReserva(id, reserva)).thenReturn(reserva);

        ResponseEntity<Reserva> response = reservaController.atualizarReserva(id, reserva);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reserva, response.getBody());
    }

    @Test
    void testDeletarReserva() {
        UUID id = UUID.randomUUID(); // Seu UUID para teste
        doNothing().when(reservaService).deletarReserva(id);

        ResponseEntity<Void> response = reservaController.deletarReserva(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
