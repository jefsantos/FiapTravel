package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Predio;
import com.FiapTravel.repository.PredioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PredioServiceImplTest {

    @Mock
    private PredioRepository predioRepository;

    @InjectMocks
    private PredioServiceImpl predioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_PredioValido_SalvarComSucesso() {
        // Arrange
        Predio predio = new Predio();
        UUID id = UUID.randomUUID();

        // Act
        when(predioRepository.save(predio)).thenReturn(predio);
        Predio savedPredio = predioService.save(predio);

        // Assert
        assertNotNull(savedPredio);
        assertEquals(predio, savedPredio);
    }

    @Test
    void save_PredioNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> predioService.save(null));
    }

    @Test
    void buscarTodosPredios_PrediosPresentes_RetornarListaCorreta() {
        // Arrange
        List<Predio> predios = List.of(new Predio(), new Predio());

        // Act
        when(predioRepository.findAll()).thenReturn(predios);
        List<Predio> foundPredios = predioService.buscarTodosPredios();

        // Assert
        assertEquals(predios.size(), foundPredios.size());
    }

    // Outros métodos de teste para buscarTodosPredios() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarPredio e deletarPredio
}
