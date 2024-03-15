package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Item;
import com.FiapTravel.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepositoryMock;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item itemToSave = new Item(id, "Descrição do item");
        when(itemRepositoryMock.save(itemToSave)).thenReturn(itemToSave);

        // Act
        Item savedItem = itemService.save(itemToSave);

        // Assert
        assertEquals(itemToSave, savedItem);
    }

    @Test
    void testBuscarTodosItens() {
        // Arrange
        List<Item> expectedItems = Arrays.asList(
                new Item(UUID.randomUUID(), "Descrição 1"),
                new Item(UUID.randomUUID(), "Descrição 2")
        );
        when(itemRepositoryMock.findAll()).thenReturn(expectedItems);

        // Act
        List<Item> actualItems = itemService.buscarTodosItens();

        // Assert
        assertEquals(expectedItems, actualItems);
    }

    @Test
    void testBuscarPorId_Encontrado() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item expectedItem = new Item(id, "Descrição do item");
        when(itemRepositoryMock.findById(id)).thenReturn(Optional.of(expectedItem));

        // Act
        Optional<Item> actualItemOptional = itemService.buscarPorId(id);

        // Assert
        assertTrue(actualItemOptional.isPresent());
        assertEquals(expectedItem, actualItemOptional.get());
    }

    @Test
    void testBuscarPorId_NaoEncontrado() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(itemRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<Item> actualItemOptional = itemService.buscarPorId(id);

        // Assert
        assertFalse(actualItemOptional.isPresent());
    }

    @Test
    void testAtualizarItem() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item existingItem = new Item(id, "Descrição existente");
        Item updatedItem = new Item(id, "Descrição atualizada");
        when(itemRepositoryMock.findById(id)).thenReturn(Optional.of(existingItem));
        when(itemRepositoryMock.save(updatedItem)).thenReturn(updatedItem);

        // Act
        Item returnedItem = itemService.atualizarItem(id, updatedItem);

        // Assert
        assertEquals(updatedItem, returnedItem);
    }

    @Test
    void testAtualizarItem_ItemNaoEncontrado() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item updatedItem = new Item(id, "Descrição atualizada");
        when(itemRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> itemService.atualizarItem(id, updatedItem));
    }

    @Test
    void testDeletarItem() {
        // Arrange
        UUID id = UUID.randomUUID();

        // Act
        itemService.deletarItem(id);

        // Assert
        verify(itemRepositoryMock, times(1)).deleteById(id);
    }
}
