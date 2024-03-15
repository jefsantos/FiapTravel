package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;
import com.FiapTravel.repository.AmenidadeLocalidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AmenidadeLocalidadeServiceImplTest {

    @Mock
    private AmenidadeLocalidadeRepository amenidadeLocalidadeRepository;

    @InjectMocks
    private AmenidadeLocalidadeServiceImpl amenidadeLocalidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_ValidAmenidadeLocalidade_ShouldSaveSuccessfully() {
        // Arrange
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade();
        when(amenidadeLocalidadeRepository.save(amenidadeLocalidade)).thenReturn(amenidadeLocalidade);

        // Act
        AmenidadeLocalidade savedAmenidadeLocalidade = amenidadeLocalidadeService.save(amenidadeLocalidade);

        // Assert
        assertNotNull(savedAmenidadeLocalidade);
        assertEquals(amenidadeLocalidade, savedAmenidadeLocalidade);
    }

    @Test
    void buscarTodasAmenidadesLocalidades_ShouldReturnListOfAmenidadeLocalidades() {
        // Arrange
        AmenidadeLocalidade amenidade1 = new AmenidadeLocalidade();
        AmenidadeLocalidade amenidade2 = new AmenidadeLocalidade();
        List<AmenidadeLocalidade> expectedAmenidades = Arrays.asList(amenidade1, amenidade2);
        when(amenidadeLocalidadeRepository.findAll()).thenReturn(expectedAmenidades);

        // Act
        List<AmenidadeLocalidade> amenidades = amenidadeLocalidadeService.buscarTodasAmenidadesLocalidades();

        // Assert
        assertEquals(expectedAmenidades, amenidades);
    }

    @Test
    void buscarPorId_ExistingId_ShouldReturnAmenidadeLocalidade() {
        // Arrange
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        AmenidadeLocalidade expectedAmenidade = new AmenidadeLocalidade();
        when(amenidadeLocalidadeRepository.findById(id)).thenReturn(Optional.of(expectedAmenidade));

        // Act
        Optional<AmenidadeLocalidade> amenidade = amenidadeLocalidadeService.buscarPorId(id);

        // Assert
        assertTrue(amenidade.isPresent());
        assertEquals(expectedAmenidade, amenidade.get());
    }

    // Adicione testes semelhantes para os métodos atualizarAmenidadeLocalidade e deletarAmenidadeLocalidade
}
