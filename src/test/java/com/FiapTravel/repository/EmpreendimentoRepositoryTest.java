package com.FiapTravel.repository;

import com.FiapTravel.model.Empreendimento;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmpreendimentoRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Empreendimento> expectedEmpreendimentos = Arrays.asList(
                new Empreendimento(UUID.randomUUID(), "Empreendimento 1", null),
                new Empreendimento(UUID.randomUUID(), "Empreendimento 2", null)
        );
        EmpreendimentoRepository empreendimentoRepositoryMock = Mockito.mock(EmpreendimentoRepository.class);
        when(empreendimentoRepositoryMock.findAll()).thenReturn(expectedEmpreendimentos);

        // Act
        List<Empreendimento> actualEmpreendimentos = empreendimentoRepositoryMock.findAll();

        // Assert
        assertEquals(expectedEmpreendimentos, actualEmpreendimentos);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Empreendimento expectedEmpreendimento = new Empreendimento(id, "Empreendimento", null);
        EmpreendimentoRepository empreendimentoRepositoryMock = Mockito.mock(EmpreendimentoRepository.class);
        when(empreendimentoRepositoryMock.findById(id)).thenReturn(Optional.of(expectedEmpreendimento));

        // Act
        Optional<Empreendimento> actualEmpreendimentoOptional = empreendimentoRepositoryMock.findById(id);

        // Assert
        assertTrue(actualEmpreendimentoOptional.isPresent());
        assertEquals(expectedEmpreendimento, actualEmpreendimentoOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Empreendimento empreendimentoToSave = new Empreendimento(id, "Empreendimento", null);
        EmpreendimentoRepository empreendimentoRepositoryMock = Mockito.mock(EmpreendimentoRepository.class);
        when(empreendimentoRepositoryMock.save(empreendimentoToSave)).thenReturn(empreendimentoToSave);

        // Act
        Empreendimento savedEmpreendimento = empreendimentoRepositoryMock.save(empreendimentoToSave);

        // Assert
        assertEquals(empreendimentoToSave, savedEmpreendimento);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        EmpreendimentoRepository empreendimentoRepositoryMock = Mockito.mock(EmpreendimentoRepository.class);

        // Act
        empreendimentoRepositoryMock.deleteById(id);

        // Assert
        verify(empreendimentoRepositoryMock, times(1)).deleteById(id);
    }
}
