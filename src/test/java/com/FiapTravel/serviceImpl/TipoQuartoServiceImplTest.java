package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.repository.TipoQuartoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TipoQuartoServiceImplTest {

    @Mock
    private TipoQuartoRepository tipoQuartoRepository;

    @InjectMocks
    private TipoQuartoServiceImpl tipoQuartoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_TipoQuartoValido_SalvarComSucesso() {
        // Arrange
        TipoQuarto tipoQuarto = new TipoQuarto();
        UUID id = UUID.randomUUID();

        // Act
        when(tipoQuartoRepository.save(tipoQuarto)).thenReturn(tipoQuarto);
        TipoQuarto savedTipoQuarto = tipoQuartoService.save(tipoQuarto);

        // Assert
        assertNotNull(savedTipoQuarto);
        assertEquals(tipoQuarto, savedTipoQuarto);
    }

    @Test
    void save_TipoQuartoNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> tipoQuartoService.save(null));
    }

    @Test
    void buscarTodosTiposQuartos_TiposQuartosPresentes_RetornarListaCorreta() {
        // Arrange
        List<TipoQuarto> tiposQuartos = List.of(new TipoQuarto(), new TipoQuarto());

        // Act
        when(tipoQuartoRepository.findAll()).thenReturn(tiposQuartos);
        List<TipoQuarto> foundTiposQuartos = tipoQuartoService.buscarTodosTiposQuartos();

        // Assert
        assertEquals(tiposQuartos.size(), foundTiposQuartos.size());
    }

    // Outros métodos de teste para buscarTodosTiposQuartos() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarTipoQuarto e deletarTipoQuarto
}
