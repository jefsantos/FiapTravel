package com.FiapTravel.controller;

import com.FiapTravel.model.Item;
import com.FiapTravel.service.ItemService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarItem() {
        // Arrange
        Item item = new Item(UUID.randomUUID(), "Descrição do item");
        when(itemService.save(item)).thenReturn(item);

        // Act
        ResponseEntity<Item> response = itemController.criarItem(item);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(item, response.getBody());
    }

    @Test
    void testBuscarTodosItens() {
        // Arrange
        Item item1 = new Item(UUID.randomUUID(), "Descrição 1");
        Item item2 = new Item(UUID.randomUUID(), "Descrição 2");
        List<Item> expectedItems = Arrays.asList(item1, item2);
        when(itemService.buscarTodosItens()).thenReturn(expectedItems);

        // Act
        ResponseEntity<List<Item>> response = itemController.buscarTodosItens();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedItems, response.getBody());
    }

    @Test
    void testBuscarPorId_ItemEncontrado() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item item = new Item(id, "Descrição do item");
        when(itemService.buscarPorId(id)).thenReturn(Optional.of(item));

        // Act
        ResponseEntity<Item> response = itemController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(item, response.getBody());
    }

    @Test
    void testBuscarPorId_ItemNaoEncontrado() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(itemService.buscarPorId(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Item> response = itemController.buscarPorId(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testAtualizarItem() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item item = new Item(id, "Descrição do item");
        when(itemService.atualizarItem(id, item)).thenReturn(item);

        // Act
        ResponseEntity<Item> response = itemController.atualizarItem(id, item);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(item, response.getBody());
    }

    @Test
    void testDeletarItem() {
        // Arrange
        UUID id = UUID.randomUUID();

        // Act
        ResponseEntity<Void> response = itemController.deletarItem(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(itemService, times(1)).deletarItem(id);
    }
}
