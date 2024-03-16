package com.FiapTravel.repository;

import com.FiapTravel.model.Quarto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuartoRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Quarto> expectedQuartos = Arrays.asList(
                new Quarto(UUID.randomUUID(), "Nome do Quarto 1", 2, 10, BigDecimal.valueOf(100.00), null, null),
                new Quarto(UUID.randomUUID(), "Nome do Quarto 2", 3, 15, BigDecimal.valueOf(150.00), null, null)
        );
        QuartoRepository quartoRepositoryMock = Mockito.mock(QuartoRepository.class);
        when(quartoRepositoryMock.findAll()).thenReturn(expectedQuartos);

        // Act
        List<Quarto> actualQuartos = quartoRepositoryMock.findAll();

        // Assert
        assertEquals(expectedQuartos, actualQuartos);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Quarto expectedQuarto = new Quarto(id, "Nome do Quarto", 2, 10, BigDecimal.valueOf(100.00), null, null);
        QuartoRepository quartoRepositoryMock = Mockito.mock(QuartoRepository.class);
        when(quartoRepositoryMock.findById(id)).thenReturn(Optional.of(expectedQuarto));

        // Act
        Optional<Quarto> actualQuartoOptional = quartoRepositoryMock.findById(id);

        // Assert
        assertTrue(actualQuartoOptional.isPresent());
        assertEquals(expectedQuarto, actualQuartoOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Quarto quartoToSave = new Quarto(id, "Nome do Quarto", 2, 10, BigDecimal.ONE, null, null);
        QuartoRepository quartoRepositoryMock = Mockito.mock(QuartoRepository.class);
        when(quartoRepositoryMock.save(quartoToSave)).thenReturn(quartoToSave);

        // Act
        Quarto savedQuarto = quartoRepositoryMock.save(quartoToSave);

        // Assert
        assertEquals(quartoToSave, savedQuarto);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        QuartoRepository quartoRepositoryMock = Mockito.mock(QuartoRepository.class);

        // Act
        quartoRepositoryMock.deleteById(id);

        // Assert
        verify(quartoRepositoryMock, times(1)).deleteById(id);
    }
}
