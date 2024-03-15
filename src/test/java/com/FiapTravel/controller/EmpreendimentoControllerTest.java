package com.FiapTravel.controller;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.service.EmpreendimentoService;
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

class EmpreendimentoControllerTest {

    @Mock
    private EmpreendimentoService empreendimentoService;

    @InjectMocks
    private EmpreendimentoController empreendimentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarEmpreendimento() {
        Empreendimento empreendimento = new Empreendimento();
        when(empreendimentoService.save(any())).thenReturn(empreendimento);

        ResponseEntity<Empreendimento> responseEntity = empreendimentoController.criarEmpreendimento(empreendimento);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(empreendimento, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosEmpreendimentos() {
        Empreendimento empreendimento1 = new Empreendimento();
        Empreendimento empreendimento2 = new Empreendimento();
        List<Empreendimento> empreendimentos = Arrays.asList(empreendimento1, empreendimento2);
        when(empreendimentoService.buscarTodosEmpreendimentos()).thenReturn(empreendimentos);

        ResponseEntity<List<Empreendimento>> responseEntity = empreendimentoController.buscarTodosEmpreendimentos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(empreendimentos, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        UUID id = UUID.randomUUID();
        Empreendimento empreendimento = new Empreendimento();
        when(empreendimentoService.buscarPorId(id)).thenReturn(Optional.of(empreendimento));

        ResponseEntity<Empreendimento> responseEntity = empreendimentoController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(empreendimento, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        UUID id = UUID.randomUUID();
        when(empreendimentoService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Empreendimento> responseEntity = empreendimentoController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarEmpreendimentoExistente() {
        UUID id = UUID.randomUUID();
        Empreendimento empreendimento = new Empreendimento();
        when(empreendimentoService.atualizarEmpreendimento(any(), any())).thenReturn(empreendimento);

        ResponseEntity<Empreendimento> responseEntity = empreendimentoController.atualizarEmpreendimento(id, empreendimento);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(empreendimento, responseEntity.getBody());
    }

    @Test
    void testAtualizarEmpreendimentoInexistente() {
        UUID id = UUID.randomUUID();
        Empreendimento empreendimento = new Empreendimento();
        when(empreendimentoService.atualizarEmpreendimento(any(), any())).thenReturn(null);

        ResponseEntity<Empreendimento> responseEntity = empreendimentoController.atualizarEmpreendimento(id, empreendimento);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarEmpreendimento() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = empreendimentoController.deletarEmpreendimento(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(empreendimentoService, times(1)).deletarEmpreendimento(id);
    }
}
