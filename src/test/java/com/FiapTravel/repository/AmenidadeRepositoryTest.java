package com.FiapTravel.repository;

import com.FiapTravel.model.Amenidade;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AmenidadeRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Amenidade> expectedAmenidades = Arrays.asList(
                new Amenidade(UUID.randomUUID(), "Descrição 1"),
                new Amenidade(UUID.randomUUID(), "Descrição 2")
        );
        AmenidadeRepository amenidadeRepositoryMock = Mockito.mock(AmenidadeRepository.class);
        when(amenidadeRepositoryMock.findAll()).thenReturn(expectedAmenidades);

        // Act
        List<Amenidade> actualAmenidades = amenidadeRepositoryMock.findAll();

        // Assert
        assertEquals(expectedAmenidades, actualAmenidades);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Amenidade expectedAmenidade = new Amenidade(id, "Descrição da amenidade");
        AmenidadeRepository amenidadeRepositoryMock = Mockito.mock(AmenidadeRepository.class);
        when(amenidadeRepositoryMock.findById(id)).thenReturn(Optional.of(expectedAmenidade));

        // Act
        Optional<Amenidade> actualAmenidadeOptional = amenidadeRepositoryMock.findById(id);

        // Assert
        assertTrue(actualAmenidadeOptional.isPresent());
        assertEquals(expectedAmenidade, actualAmenidadeOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Amenidade amenidadeToSave = new Amenidade(id, "Descrição da amenidade");
        AmenidadeRepository amenidadeRepositoryMock = Mockito.mock(AmenidadeRepository.class);
        when(amenidadeRepositoryMock.save(amenidadeToSave)).thenReturn(amenidadeToSave);

        // Act
        Amenidade savedAmenidade = amenidadeRepositoryMock.save(amenidadeToSave);

        // Assert
        assertEquals(amenidadeToSave, savedAmenidade);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        AmenidadeRepository amenidadeRepositoryMock = Mockito.mock(AmenidadeRepository.class);

        // Act
        amenidadeRepositoryMock.deleteById(id);

        // Assert
        verify(amenidadeRepositoryMock, times(1)).deleteById(id);
    }
}
