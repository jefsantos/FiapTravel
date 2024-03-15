package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.repository.AmenidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AmenidadeServiceImplTest {

    @Mock
    private AmenidadeRepository amenidadeRepository;

    @InjectMocks
    private AmenidadeServiceImpl amenidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_ValidAmenidade_ShouldReturnSavedAmenidade() {
        // Arrange
        Amenidade amenidade = new Amenidade();
        amenidade.setIdAmenidade(UUID.randomUUID());

        when(amenidadeRepository.save(amenidade)).thenReturn(amenidade);

        // Act
        Amenidade savedAmenidade = amenidadeService.save(amenidade);

        // Assert
        assertEquals(amenidade, savedAmenidade);
    }

    @Test
    void buscarTodasAmenidades_ShouldReturnAllAmenidades() {
        // Arrange
        Amenidade amenidade1 = new Amenidade();
        Amenidade amenidade2 = new Amenidade();
        List<Amenidade> expectedAmenidades = Arrays.asList(amenidade1, amenidade2);

        when(amenidadeRepository.findAll()).thenReturn(expectedAmenidades);

        // Act
        List<Amenidade> actualAmenidades = amenidadeService.buscarTodasAmenidades();

        // Assert
        assertEquals(expectedAmenidades, actualAmenidades);
    }

    @Test
    void buscarPorId_ExistingId_ShouldReturnAmenidade() {
        // Arrange
        Amenidade amenidade = new Amenidade();
        UUID id = UUID.randomUUID();

        when(amenidadeRepository.findById(id)).thenReturn(Optional.of(amenidade));

        // Act
        Optional<Amenidade> result = amenidadeService.buscarPorId(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(amenidade, result.get());
    }

    @Test
    void buscarPorId_NonExistingId_ShouldReturnEmptyOptional() {
        // Arrange
        UUID id = UUID.randomUUID();

        when(amenidadeRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<Amenidade> result = amenidadeService.buscarPorId(id);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void atualizarAmenidade_ExistingId_ShouldReturnUpdatedAmenidade() {
        // Arrange
        Amenidade existingAmenidade = new Amenidade();
        UUID id = UUID.randomUUID();

        when(amenidadeRepository.findById(id)).thenReturn(Optional.of(existingAmenidade));
        when(amenidadeRepository.save(existingAmenidade)).thenReturn(existingAmenidade);

        // Act
        Amenidade updatedAmenidade = amenidadeService.atualizarAmenidade(id, existingAmenidade);

        // Assert
        assertEquals(existingAmenidade, updatedAmenidade);
    }

    @Test
    void atualizarAmenidade_NonExistingId_ShouldThrowIllegalArgumentException() {
        // Arrange
        UUID id = UUID.randomUUID();

        when(amenidadeRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> amenidadeService.atualizarAmenidade(id, new Amenidade()));
    }

    @Test
    void deletarAmenidade_ExistingId_ShouldDeleteAmenidade() {
        // Arrange
        UUID id = UUID.randomUUID();

        // Act
        amenidadeService.deletarAmenidade(id);

        // Assert
        verify(amenidadeRepository, times(1)).deleteById(id);
    }


}
