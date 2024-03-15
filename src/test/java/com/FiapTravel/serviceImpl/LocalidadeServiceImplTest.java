package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.repository.LocalidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocalidadeServiceImplTest {

    @Mock
    private LocalidadeRepository localidadeRepository;

    @InjectMocks
    private LocalidadeServiceImpl localidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_LocalidadeValida_SalvarComSucesso() {
        // Arrange
        Localidade localidade = new Localidade();
        localidade.setIdLocalidade(UUID.randomUUID());

        // Act
        when(localidadeRepository.save(localidade)).thenReturn(localidade);
        Localidade savedLocalidade = localidadeService.save(localidade);

        // Assert
        assertNotNull(savedLocalidade);
        assertEquals(localidade.getIdLocalidade(), savedLocalidade.getIdLocalidade());
    }

    @Test
    void save_LocalidadeNula_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> localidadeService.save(null));
    }

    @Test
    void buscarTodasLocalidades_LocalidadesPresentes_RetornarListaCorreta() {
        // Arrange
        List<Localidade> localidades = List.of(new Localidade(), new Localidade());

        // Act
        when(localidadeRepository.findAll()).thenReturn(localidades);
        List<Localidade> foundLocalidades = localidadeService.buscarTodasLocalidades();

        // Assert
        assertEquals(localidades.size(), foundLocalidades.size());
    }

    // Outros métodos de teste para buscarTodasLocalidades() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarLocalidade e deletarLocalidade
}
