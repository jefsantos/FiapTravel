package com.FiapTravel.controller;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.service.LocalidadeService;
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

class LocalidadeControllerTest {

    @Mock
    private LocalidadeService localidadeService;

    @InjectMocks
    private LocalidadeController localidadeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCriarLocalidade() {
        Localidade localidade = new Localidade();
        when(localidadeService.save(any())).thenReturn(localidade);

        ResponseEntity<Localidade> responseEntity = localidadeController.criarLocalidade(localidade);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(localidade, responseEntity.getBody());
    }

    @Test
    void testBuscarTodasLocalidades() {
        Localidade localidade1 = new Localidade();
        Localidade localidade2 = new Localidade();
        List<Localidade> localidades = Arrays.asList(localidade1, localidade2);
        when(localidadeService.buscarTodasLocalidades()).thenReturn(localidades);

        ResponseEntity<List<Localidade>> responseEntity = localidadeController.buscarTodasLocalidades();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(localidades, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdExistente() {
        UUID id = UUID.randomUUID();
        Localidade localidade = new Localidade();
        when(localidadeService.buscarPorId(id)).thenReturn(Optional.of(localidade));

        ResponseEntity<Localidade> responseEntity = localidadeController.buscarPorId(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(localidade, responseEntity.getBody());
    }

    @Test
    void testBuscarPorIdInexistente() {
        UUID id = UUID.randomUUID();
        when(localidadeService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Localidade> responseEntity = localidadeController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAtualizarLocalidadeExistente() {
        UUID id = UUID.randomUUID();
        Localidade localidade = new Localidade();
        when(localidadeService.atualizarLocalidade(any(), any())).thenReturn(localidade);

        ResponseEntity<Localidade> responseEntity = localidadeController.atualizarLocalidade(id, localidade);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(localidade, responseEntity.getBody());
    }

    @Test
    void testAtualizarLocalidadeInexistente() {
        UUID id = UUID.randomUUID();
        Localidade localidade = new Localidade();
        when(localidadeService.atualizarLocalidade(any(), any())).thenReturn(null);

        ResponseEntity<Localidade> responseEntity = localidadeController.atualizarLocalidade(id, localidade);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeletarLocalidade() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> responseEntity = localidadeController.deletarLocalidade(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(localidadeService, times(1)).deletarLocalidade(id);
    }
}
