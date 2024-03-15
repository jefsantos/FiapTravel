package com.FiapTravel.controller;

import com.FiapTravel.model.Opcional;
import com.FiapTravel.service.OpcionalService;
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

class OpcionalControllerTest {

    @Mock
    private OpcionalService opcionalService;

    @InjectMocks
    private OpcionalController opcionalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarOpcional() {
        Opcional opcional = new Opcional();
        when(opcionalService.save(any())).thenReturn(opcional);

        ResponseEntity<Opcional> responseEntity = opcionalController.criarOpcional(opcional);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(opcional, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosOpcionais() {
        Opcional opcional1 = new Opcional();
        Opcional opcional2 = new Opcional();
        List<Opcional> opcionais = Arrays.asList(opcional1, opcional2);
        when(opcionalService.buscarTodosOpcionais()).thenReturn(opcionais);

        ResponseEntity<List<Opcional>> responseEntity = opcionalController.buscarTodosOpcionais();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionais, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        UUID id = UUID.randomUUID();
        Opcional opcional = new Opcional();
        when(opcionalService.buscarPorId(id)).thenReturn(Optional.of(opcional));

        ResponseEntity<Opcional> responseEntity = opcionalController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcional, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        UUID id = UUID.randomUUID();
        when(opcionalService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Opcional> responseEntity = opcionalController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarOpcionalExistente() {
        UUID id = UUID.randomUUID();
        Opcional opcional = new Opcional();
        when(opcionalService.atualizarOpcional(any(), any())).thenReturn(opcional);

        ResponseEntity<Opcional> responseEntity = opcionalController.atualizarOpcional(id, opcional);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcional, responseEntity.getBody());
    }

    @Test
    void testAtualizarOpcionalInexistente() {
        UUID id = UUID.randomUUID();
        Opcional opcional = new Opcional();
        when(opcionalService.atualizarOpcional(any(), any())).thenReturn(null);

        ResponseEntity<Opcional> responseEntity = opcionalController.atualizarOpcional(id, opcional);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarOpcional() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = opcionalController.deletarOpcional(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(opcionalService, times(1)).deletarOpcional(id);
    }
}
