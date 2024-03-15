package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Opcional;
import com.FiapTravel.repository.OpcionalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OpcionalServiceImplTest {

    @Mock
    private OpcionalRepository opcionalRepository;

    @InjectMocks
    private OpcionalServiceImpl opcionalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_OpcionalValido_SalvarComSucesso() {
        // Arrange
        Opcional opcional = new Opcional();
        opcional.setIdOpcional(UUID.randomUUID());

        // Act
        when(opcionalRepository.save(opcional)).thenReturn(opcional);
        Opcional savedOpcional = opcionalService.save(opcional);

        // Assert
        assertNotNull(savedOpcional);
        assertEquals(opcional.getIdOpcional(), savedOpcional.getIdOpcional());
    }

    @Test
    void save_OpcionalNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> opcionalService.save(null));
    }

    @Test
    void buscarTodosOpcionais_OpcionaisPresentes_RetornarListaCorreta() {
        // Arrange
        List<Opcional> opcionais = List.of(new Opcional(), new Opcional());

        // Act
        when(opcionalRepository.findAll()).thenReturn(opcionais);
        List<Opcional> foundOpcionais = opcionalService.buscarTodosOpcionais();

        // Assert
        assertEquals(opcionais.size(), foundOpcionais.size());
    }

    // Outros métodos de teste para buscarTodosOpcionais() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarOpcional e deletarOpcional
}
