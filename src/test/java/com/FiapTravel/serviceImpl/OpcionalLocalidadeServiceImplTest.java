package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;
import com.FiapTravel.repository.OpcionalLocalidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OpcionalLocalidadeServiceImplTest {

    @Mock
    private OpcionalLocalidadeRepository opcionalLocalidadeRepository;

    @InjectMocks
    private OpcionalLocalidadeServiceImpl opcionalLocalidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_OpcionalLocalidadeValido_SalvarComSucesso() {
        // Arrange
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        OpcionalLocalidadeId opcionalLocalidadeId = new OpcionalLocalidadeId();

        // Act
        when(opcionalLocalidadeRepository.save(opcionalLocalidade)).thenReturn(opcionalLocalidade);
        OpcionalLocalidade savedOpcionalLocalidade = opcionalLocalidadeService.save(opcionalLocalidade);

        // Assert
        assertNotNull(savedOpcionalLocalidade);
        assertEquals(opcionalLocalidade, savedOpcionalLocalidade);
    }

    @Test
    void save_OpcionalLocalidadeNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> opcionalLocalidadeService.save(null));
    }

    @Test
    void buscarTodosOpcionaisLocalidades_OpcionaisLocalidadesPresentes_RetornarListaCorreta() {
        // Arrange
        List<OpcionalLocalidade> opcionaisLocalidade = List.of(new OpcionalLocalidade(), new OpcionalLocalidade());

        // Act
        when(opcionalLocalidadeRepository.findAll()).thenReturn(opcionaisLocalidade);
        List<OpcionalLocalidade> foundOpcionaisLocalidade = opcionalLocalidadeService.buscarTodosOpcionaisLocalidades();

        // Assert
        assertEquals(opcionaisLocalidade.size(), foundOpcionaisLocalidade.size());
    }

    // Outros métodos de teste para buscarTodosOpcionaisLocalidades() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarOpcionalLocalidade e deletarOpcionalLocalidade
}
