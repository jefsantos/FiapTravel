package com.FiapTravel.controller;

import com.FiapTravel.model.Quarto;
import com.FiapTravel.service.QuartoService;
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

class QuartoControllerTest {

    @Mock
    private QuartoService quartoService;

    @InjectMocks
    private QuartoController quartoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarQuarto() {
        Quarto quarto = new Quarto();
        when(quartoService.save(any())).thenReturn(quarto);

        ResponseEntity<Quarto> responseEntity = quartoController.criarQuarto(quarto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(quarto, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosQuartos() {
        Quarto quarto1 = new Quarto();
        Quarto quarto2 = new Quarto();
        List<Quarto> quartos = Arrays.asList(quarto1, quarto2);
        when(quartoService.buscarTodosQuartos()).thenReturn(quartos);

        ResponseEntity<List<Quarto>> responseEntity = quartoController.buscarTodosQuartos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(quartos, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        UUID id = UUID.randomUUID();
        Quarto quarto = new Quarto();
        when(quartoService.buscarPorId(id)).thenReturn(Optional.of(quarto));

        ResponseEntity<Quarto> responseEntity = quartoController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(quarto, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        UUID id = UUID.randomUUID();
        when(quartoService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Quarto> responseEntity = quartoController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarQuartoExistente() {
        UUID id = UUID.randomUUID();
        Quarto quarto = new Quarto();
        when(quartoService.atualizarQuarto(any(), any())).thenReturn(quarto);

        ResponseEntity<Quarto> responseEntity = quartoController.atualizarQuarto(id, quarto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(quarto, responseEntity.getBody());
    }

    @Test
    void testAtualizarQuartoInexistente() {
        UUID id = UUID.randomUUID();
        Quarto quarto = new Quarto();
        when(quartoService.atualizarQuarto(any(), any())).thenReturn(null);

        ResponseEntity<Quarto> responseEntity = quartoController.atualizarQuarto(id, quarto);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarQuarto() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = quartoController.deletarQuarto(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(quartoService, times(1)).deletarQuarto(id);
    }
}
