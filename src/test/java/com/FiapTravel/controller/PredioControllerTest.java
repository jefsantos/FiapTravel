package com.FiapTravel.controller;

import com.FiapTravel.model.Predio;
import com.FiapTravel.service.PredioService;
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
import static org.mockito.Mockito.*;

class PredioControllerTest {

    @Mock
    private PredioService predioService;

    @InjectMocks
    private PredioController predioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarPredio() {
        Predio predio = new Predio(UUID.randomUUID(), "Nome do Predio", null);
        when(predioService.save(any(Predio.class))).thenReturn(predio);

        ResponseEntity<Predio> responseEntity = predioController.criarPredio(predio);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(predio, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosPredios() {
        List<Predio> predios = new ArrayList<>();
        predios.add(new Predio(UUID.randomUUID(), "Nome do Predio 1", null));
        predios.add(new Predio(UUID.randomUUID(), "Nome do Predio 2", null));
        when(predioService.buscarTodosPredios()).thenReturn(predios);

        ResponseEntity<List<Predio>> responseEntity = predioController.buscarTodosPredios();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(predios, responseEntity.getBody());
    }

    @Test
    void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Predio predio = new Predio(id, "Nome do Predio", null);
        when(predioService.buscarPorId(id)).thenReturn(Optional.of(predio));

        ResponseEntity<Predio> responseEntity = predioController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(predio, responseEntity.getBody());
    }

    @Test
    void testAtualizarPredio() {
        UUID id = UUID.randomUUID();
        Predio predio = new Predio(id, "Nome do Predio", null);
        when(predioService.atualizarPredio(id, predio)).thenReturn(predio);

        ResponseEntity<Predio> responseEntity = predioController.atualizarPredio(id, predio);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(predio, responseEntity.getBody());
    }

    @Test
    void testDeletarPredio() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = predioController.deletarPredio(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(predioService, times(1)).deletarPredio(id);
    }
}