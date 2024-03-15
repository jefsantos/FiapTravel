package com.FiapTravel.controller;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.service.AmenidadeService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AmenidadeControllerTest {

    @Mock
    private AmenidadeService amenidadeService;

    @InjectMocks
    private AmenidadeController amenidadeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarAmenidade_DeveRetornarStatusCreated() {
        Amenidade amenidade = new Amenidade();
        when(amenidadeService.save(amenidade)).thenReturn(amenidade);

        ResponseEntity<Amenidade> response = amenidadeController.criarAmenidade(amenidade);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void buscarTodasAmenidades_DeveRetornarListaDeAmenidades() {
        List<Amenidade> amenidades = new ArrayList<>();
        when(amenidadeService.buscarTodasAmenidades()).thenReturn(amenidades);

        ResponseEntity<List<Amenidade>> response = amenidadeController.buscarTodasAmenidades();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void buscarPorId_DeveRetornarAmenidadeExistente() {
        UUID id = UUID.randomUUID();
        Amenidade amenidade = new Amenidade();
        when(amenidadeService.buscarPorId(id)).thenReturn(Optional.of(amenidade));

        ResponseEntity<Amenidade> response = amenidadeController.buscarPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void buscarPorId_DeveRetornarNotFoundQuandoAmenidadeNaoExiste() {
        UUID id = UUID.randomUUID();
        when(amenidadeService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Amenidade> response = amenidadeController.buscarPorId(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void atualizarAmenidade_DeveRetornarAmenidadeAtualizada() {
        UUID id = UUID.randomUUID();
        Amenidade amenidade = new Amenidade();
        when(amenidadeService.atualizarAmenidade(id, amenidade)).thenReturn(amenidade);

        ResponseEntity<Amenidade> response = amenidadeController.atualizarAmenidade(id, amenidade);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void atualizarAmenidade_DeveRetornarNotFoundQuandoAmenidadeNaoExiste() {
        UUID id = UUID.randomUUID();
        Amenidade amenidade = new Amenidade();
        when(amenidadeService.atualizarAmenidade(id, amenidade)).thenReturn(null);

        ResponseEntity<Amenidade> response = amenidadeController.atualizarAmenidade(id, amenidade);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deletarAmenidade_DeveRetornarNoContent() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> response = amenidadeController.deletarAmenidade(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());

        verify(amenidadeService, times(1)).deletarAmenidade(id);
    }
}
