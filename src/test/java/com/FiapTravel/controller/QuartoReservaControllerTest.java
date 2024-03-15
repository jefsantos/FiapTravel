package com.FiapTravel.controller;

import com.FiapTravel.model.QuartoReserva;
import com.FiapTravel.model.QuartoReservaId;
import com.FiapTravel.service.QuartoReservaService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class QuartoReservaControllerTest {

    @Mock
    private QuartoReservaService quartoReservaService;

    @InjectMocks
    private QuartoReservaController quartoReservaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarQuartoReserva() {
        QuartoReserva quartoReserva = new QuartoReserva(); // Defina os dados para teste
        when(quartoReservaService.save(quartoReserva)).thenReturn(quartoReserva);

        ResponseEntity<QuartoReserva> response = quartoReservaController.criarQuartoReserva(quartoReserva);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(quartoReserva, response.getBody());
    }

    @Test
    void testBuscarTodasQuartoReservas() {
        List<QuartoReserva> quartosReservas = new ArrayList<>(); // Defina os dados para teste
        when(quartoReservaService.buscarTodasQuartoReservas()).thenReturn(quartosReservas);

        ResponseEntity<List<QuartoReserva>> response = quartoReservaController.buscarTodasQuartoReservas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(quartosReservas, response.getBody());
    }

    @Test
    void testBuscarPorId() {
        QuartoReservaId id = new QuartoReservaId(); // Defina o ID para teste
        QuartoReserva quartoReserva = new QuartoReserva(); // Defina os dados para teste
        when(quartoReservaService.buscarPorId(id)).thenReturn(Optional.of(quartoReserva));

        ResponseEntity<QuartoReserva> response = quartoReservaController.buscarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(quartoReserva, response.getBody());
    }

    @Test
    void testAtualizarQuartoReserva() {
        QuartoReservaId id = new QuartoReservaId(); // Defina o ID para teste
        QuartoReserva quartoReserva = new QuartoReserva(); // Defina os dados para teste
        when(quartoReservaService.atualizarQuartoReserva(id, quartoReserva)).thenReturn(quartoReserva);

        ResponseEntity<QuartoReserva> response = quartoReservaController.atualizarQuartoReserva(id, quartoReserva);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(quartoReserva, response.getBody());
    }

    @Test
    void testDeletarQuartoReserva() {
        QuartoReservaId id = new QuartoReservaId(); // Defina o ID para teste
        doNothing().when(quartoReservaService).deletarQuartoReserva(id);

        ResponseEntity<Void> response = quartoReservaController.deletarQuartoReserva(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
