package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Quarto;
import com.FiapTravel.repository.QuartoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class QuartoServiceImplTest {

    @Mock
    private QuartoRepository quartoRepository;

    @InjectMocks
    private QuartoServiceImpl quartoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_QuartoValido_SalvarComSucesso() {
        // Arrange
        Quarto quarto = new Quarto();
        UUID id = UUID.randomUUID();

        // Act
        when(quartoRepository.save(quarto)).thenReturn(quarto);
        Quarto savedQuarto = quartoService.save(quarto);

        // Assert
        assertNotNull(savedQuarto);
        assertEquals(quarto, savedQuarto);
    }

    @Test
    void save_QuartoNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> quartoService.save(null));
    }

    @Test
    void buscarTodosQuartos_QuartosPresentes_RetornarListaCorreta() {
        // Arrange
        List<Quarto> quartos = List.of(new Quarto(), new Quarto());

        // Act
        when(quartoRepository.findAll()).thenReturn(quartos);
        List<Quarto> foundQuartos = quartoService.buscarTodosQuartos();

        // Assert
        assertEquals(quartos.size(), foundQuartos.size());
    }

    // Outros métodos de teste para buscarTodosQuartos() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarQuarto e deletarQuarto
}
