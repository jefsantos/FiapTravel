package com.FiapTravel.repository;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AmenidadeLocalidadeRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<AmenidadeLocalidade> expectedAmenidadesLocalidades = Arrays.asList(
                new AmenidadeLocalidade(new AmenidadeLocalidadeId(), null, null, 0),
                new AmenidadeLocalidade(new AmenidadeLocalidadeId(), null, null, 0)
        );
        AmenidadeLocalidadeRepository amenidadeLocalidadeRepositoryMock = Mockito.mock(AmenidadeLocalidadeRepository.class);
        when(amenidadeLocalidadeRepositoryMock.findAll()).thenReturn(expectedAmenidadesLocalidades);

        // Act
        List<AmenidadeLocalidade> actualAmenidadesLocalidades = amenidadeLocalidadeRepositoryMock.findAll();

        // Assert
        assertEquals(expectedAmenidadesLocalidades, actualAmenidadesLocalidades);
    }

    @Test
    void testFindById() {
        // Arrange
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        AmenidadeLocalidade expectedAmenidadeLocalidade = new AmenidadeLocalidade(id, null, null, 0);
        AmenidadeLocalidadeRepository amenidadeLocalidadeRepositoryMock = Mockito.mock(AmenidadeLocalidadeRepository.class);
        when(amenidadeLocalidadeRepositoryMock.findById(id)).thenReturn(Optional.of(expectedAmenidadeLocalidade));

        // Act
        Optional<AmenidadeLocalidade> actualAmenidadeLocalidadeOptional = amenidadeLocalidadeRepositoryMock.findById(id);

        // Assert
        assertTrue(actualAmenidadeLocalidadeOptional.isPresent());
        assertEquals(expectedAmenidadeLocalidade, actualAmenidadeLocalidadeOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        AmenidadeLocalidade amenidadeLocalidadeToSave = new AmenidadeLocalidade(id, null, null, 0);
        AmenidadeLocalidadeRepository amenidadeLocalidadeRepositoryMock = Mockito.mock(AmenidadeLocalidadeRepository.class);
        when(amenidadeLocalidadeRepositoryMock.save(amenidadeLocalidadeToSave)).thenReturn(amenidadeLocalidadeToSave);

        // Act
        AmenidadeLocalidade savedAmenidadeLocalidade = amenidadeLocalidadeRepositoryMock.save(amenidadeLocalidadeToSave);

        // Assert
        assertEquals(amenidadeLocalidadeToSave, savedAmenidadeLocalidade);
    }

    @Test
    void testDeleteById() {
        // Arrange
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        AmenidadeLocalidadeRepository amenidadeLocalidadeRepositoryMock = Mockito.mock(AmenidadeLocalidadeRepository.class);

        // Act
        amenidadeLocalidadeRepositoryMock.deleteById(id);

        // Assert
        verify(amenidadeLocalidadeRepositoryMock, times(1)).deleteById(id);
    }
}
