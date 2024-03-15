package com.FiapTravel.controller;

import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;
import com.FiapTravel.service.OpcionalLocalidadeService;
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

class OpcionalLocalidadeControllerTest {

    @Mock
    private OpcionalLocalidadeService opcionalLocalidadeService;

    @InjectMocks
    private OpcionalLocalidadeController opcionalLocalidadeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarOpcionalLocalidade() {
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        when(opcionalLocalidadeService.save(any())).thenReturn(opcionalLocalidade);

        ResponseEntity<OpcionalLocalidade> responseEntity = opcionalLocalidadeController.criarOpcionalLocalidade(opcionalLocalidade);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(opcionalLocalidade, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosOpcionaisLocalidades() {
        OpcionalLocalidade opcionalLocalidade1 = new OpcionalLocalidade();
        OpcionalLocalidade opcionalLocalidade2 = new OpcionalLocalidade();
        List<OpcionalLocalidade> opcionaisLocalidades = Arrays.asList(opcionalLocalidade1, opcionalLocalidade2);
        when(opcionalLocalidadeService.buscarTodosOpcionaisLocalidades()).thenReturn(opcionaisLocalidades);

        ResponseEntity<List<OpcionalLocalidade>> responseEntity = opcionalLocalidadeController.buscarTodosOpcionaisLocalidades();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionaisLocalidades, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        when(opcionalLocalidadeService.buscarPorId(id)).thenReturn(Optional.of(opcionalLocalidade));

        ResponseEntity<OpcionalLocalidade> responseEntity = opcionalLocalidadeController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionalLocalidade, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        when(opcionalLocalidadeService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<OpcionalLocalidade> responseEntity = opcionalLocalidadeController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarOpcionalLocalidadeExistente() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        when(opcionalLocalidadeService.atualizarOpcionalLocalidade(any(), any())).thenReturn(opcionalLocalidade);

        ResponseEntity<OpcionalLocalidade> responseEntity = opcionalLocalidadeController.atualizarOpcionalLocalidade(id, opcionalLocalidade);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(opcionalLocalidade, responseEntity.getBody());
    }

    @Test
    void testAtualizarOpcionalLocalidadeInexistente() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        when(opcionalLocalidadeService.atualizarOpcionalLocalidade(any(), any())).thenReturn(null);

        ResponseEntity<OpcionalLocalidade> responseEntity = opcionalLocalidadeController.atualizarOpcionalLocalidade(id, opcionalLocalidade);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarOpcionalLocalidade() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();

        ResponseEntity<Void> responseEntity = opcionalLocalidadeController.deletarOpcionalLocalidade(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(opcionalLocalidadeService, times(1)).deletarOpcionalLocalidade(id);
    }
}
