package com.FiapTravel.controller;

import com.FiapTravel.model.OpcionalReserva;
import com.FiapTravel.model.OpcionalReservaId;
import com.FiapTravel.service.OpcionalReservaService;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OpcionalReservaControllerTest {

    @Mock
    private OpcionalReservaService opcionalReservaService;

    @InjectMocks
    private OpcionalReservaController opcionalReservaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarOpcionalReserva() {
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        when(opcionalReservaService.save(any())).thenReturn(opcionalReserva);

        ResponseEntity<OpcionalReserva> responseEntity = opcionalReservaController.criarOpcionalReserva(opcionalReserva);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(opcionalReserva, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosOpcionaisReserva() {
        OpcionalReserva opcionalReserva1 = new OpcionalReserva();
        OpcionalReserva opcionalReserva2 = new OpcionalReserva();
        List<OpcionalReserva> opcionaisReserva = Arrays.asList(opcionalReserva1, opcionalReserva2);
        when(opcionalReservaService.buscarTodosOpcionaisReserva()).thenReturn(opcionaisReserva);

        ResponseEntity<List<OpcionalReserva>> responseEntity = opcionalReservaController.buscarTodosOpcionaisReserva();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionaisReserva, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        OpcionalReservaId id = new OpcionalReservaId();
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        when(opcionalReservaService.buscarPorId(id)).thenReturn(Optional.of(opcionalReserva));

        ResponseEntity<OpcionalReserva> responseEntity = opcionalReservaController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionalReserva, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        OpcionalReservaId id = new OpcionalReservaId();
        when(opcionalReservaService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<OpcionalReserva> responseEntity = opcionalReservaController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarOpcionalReservaExistente() {
        OpcionalReservaId id = new OpcionalReservaId();
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        when(opcionalReservaService.atualizarOpcionalReserva(any(), any())).thenReturn(opcionalReserva);

        ResponseEntity<OpcionalReserva> responseEntity = opcionalReservaController.atualizarOpcionalReserva(id, opcionalReserva);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionalReserva, responseEntity.getBody());
    }

    @Test
    void testAtualizarOpcionalReservaInexistente() {
        OpcionalReservaId id = new OpcionalReservaId();
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        when(opcionalReservaService.atualizarOpcionalReserva(any(), any())).thenReturn(null);

        ResponseEntity<OpcionalReserva> responseEntity = opcionalReservaController.atualizarOpcionalReserva(id, opcionalReserva);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarOpcionalReserva() {
        OpcionalReservaId id = new OpcionalReservaId();

        ResponseEntity<Void> responseEntity = opcionalReservaController.deletarOpcionalReserva(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(opcionalReservaService, times(1)).deletarOpcionalReserva(id);
    }
}
