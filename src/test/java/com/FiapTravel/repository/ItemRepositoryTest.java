package com.FiapTravel.repository;

import com.FiapTravel.model.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Item> expectedItems = Arrays.asList(
                new Item(UUID.randomUUID(), "Descrição 1"),
                new Item(UUID.randomUUID(), "Descrição 2")
        );
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);
        when(itemRepositoryMock.findAll()).thenReturn(expectedItems);

        // Act
        List<Item> actualItems = itemRepositoryMock.findAll();

        // Assert
        assertEquals(expectedItems, actualItems);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item expectedItem = new Item(id, "Descrição do item");
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);
        when(itemRepositoryMock.findById(id)).thenReturn(Optional.of(expectedItem));

        // Act
        Optional<Item> actualItemOptional = itemRepositoryMock.findById(id);

        // Assert
        assertTrue(actualItemOptional.isPresent());
        assertEquals(expectedItem, actualItemOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Item itemToSave = new Item(id, "Descrição do item");
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);
        when(itemRepositoryMock.save(itemToSave)).thenReturn(itemToSave);

        // Act
        Item savedItem = itemRepositoryMock.save(itemToSave);

        // Assert
        assertEquals(itemToSave, savedItem);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);

        // Act
        itemRepositoryMock.deleteById(id);

        // Assert
        verify(itemRepositoryMock, times(1)).deleteById(id);
    }
}
