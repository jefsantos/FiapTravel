package com.FiapTravel.repository;

import com.FiapTravel.model.Predio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PredioRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Predio> expectedPredios = Arrays.asList(
                new Predio(UUID.randomUUID(), "Nome do Predio 1", null),
                new Predio(UUID.randomUUID(), "Nome do Predio 2", null)
        );
        PredioRepository predioRepositoryMock = Mockito.mock(PredioRepository.class);
        when(predioRepositoryMock.findAll()).thenReturn(expectedPredios);

        // Act
        List<Predio> actualPredios = predioRepositoryMock.findAll();

        // Assert
        assertEquals(expectedPredios, actualPredios);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Predio expectedPredio = new Predio(id, "Nome do Predio", null);
        PredioRepository predioRepositoryMock = Mockito.mock(PredioRepository.class);
        when(predioRepositoryMock.findById(id)).thenReturn(Optional.of(expectedPredio));

        // Act
        Optional<Predio> actualPredioOptional = predioRepositoryMock.findById(id);

        // Assert
        assertTrue(actualPredioOptional.isPresent());
        assertEquals(expectedPredio, actualPredioOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Predio predioToSave = new Predio(id, "Nome do Predio", null);
        PredioRepository predioRepositoryMock = Mockito.mock(PredioRepository.class);
        when(predioRepositoryMock.save(predioToSave)).thenReturn(predioToSave);

        // Act
        Predio savedPredio = predioRepositoryMock.save(predioToSave);

        // Assert
        assertEquals(predioToSave, savedPredio);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        PredioRepository predioRepositoryMock = Mockito.mock(PredioRepository.class);

        // Act
        predioRepositoryMock.deleteById(id);

        // Assert
        verify(predioRepositoryMock, times(1)).deleteById(id);
    }
}