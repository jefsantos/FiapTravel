package com.FiapTravel.controller;

import com.FiapTravel.model.Item;
import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;
import com.FiapTravel.model.Quarto;
import com.FiapTravel.service.ItemQuartoService;
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
import static org.mockito.Mockito.*;

class ItemQuartoControllerTest {

    @Mock
    private ItemQuartoService itemQuartoService;

    @InjectMocks
    private ItemQuartoController itemQuartoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarItemQuarto() {
        ItemQuarto itemQuarto = new ItemQuarto(new ItemQuartoId(), new Quarto(), new Item(), 5);
        when(itemQuartoService.save(any(ItemQuarto.class))).thenReturn(itemQuarto);

        ResponseEntity<ItemQuarto> responseEntity = itemQuartoController.criarItemQuarto(itemQuarto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(itemQuarto, responseEntity.getBody());
    }

    @Test
    void testBuscarTodosItensQuartos() {
        List<ItemQuarto> itensQuartos = new ArrayList<>();
        itensQuartos.add(new ItemQuarto(new ItemQuartoId(), new Quarto(), new Item(), 3));
        itensQuartos.add(new ItemQuarto(new ItemQuartoId(), new Quarto(), new Item(), 7));
        when(itemQuartoService.buscarTodosItensQuartos()).thenReturn(itensQuartos);

        ResponseEntity<List<ItemQuarto>> responseEntity = itemQuartoController.buscarTodosItensQuartos();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(itensQuartos, responseEntity.getBody());
    }

    @Test
    void testBuscarPorId() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();
        ItemQuarto itemQuarto = new ItemQuarto(itemQuartoId, new Quarto(), new Item(), 2);
        when(itemQuartoService.buscarPorId(itemQuartoId)).thenReturn(Optional.of(itemQuarto));

        ResponseEntity<ItemQuarto> responseEntity = itemQuartoController.buscarPorId(itemQuartoId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(itemQuarto, responseEntity.getBody());
    }

    @Test
    void testAtualizarItemQuarto() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();
        ItemQuarto itemQuarto = new ItemQuarto(itemQuartoId, new Quarto(), new Item(), 4);
        when(itemQuartoService.atualizarItemQuarto(itemQuartoId, itemQuarto)).thenReturn(itemQuarto);

        ResponseEntity<ItemQuarto> responseEntity = itemQuartoController.atualizarItemQuarto(itemQuartoId, itemQuarto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(itemQuarto, responseEntity.getBody());
    }

    @Test
    void testDeletarItemQuarto() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();

        ResponseEntity<Void> responseEntity = itemQuartoController.deletarItemQuarto(itemQuartoId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(itemQuartoService, times(1)).deletarItemQuarto(itemQuartoId);
    }
}