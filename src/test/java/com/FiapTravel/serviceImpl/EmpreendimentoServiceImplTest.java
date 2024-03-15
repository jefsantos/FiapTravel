package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.repository.EmpreendimentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmpreendimentoServiceImplTest {

    @Mock
    private EmpreendimentoRepository empreendimentoRepository;

    @InjectMocks
    private EmpreendimentoServiceImpl empreendimentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_EmpreendimentoValido_SalvarComSucesso() {
        // Arrange
        Empreendimento empreendimento = new Empreendimento();
        empreendimento.setIdEmpreendimento(UUID.randomUUID());

        // Act
        when(empreendimentoRepository.save(empreendimento)).thenReturn(empreendimento);
        Empreendimento savedEmpreendimento = empreendimentoService.save(empreendimento);

        // Assert
        assertNotNull(savedEmpreendimento);
        assertEquals(empreendimento.getIdEmpreendimento(), savedEmpreendimento.getIdEmpreendimento());
    }

    @Test
    void save_EmpreendimentoNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> empreendimentoService.save(null));
    }

    @Test
    void buscarTodosEmpreendimentos_EmpreendimentosPresentes_RetornarListaCorreta() {
        // Arrange
        List<Empreendimento> empreendimentos = List.of(new Empreendimento(), new Empreendimento());

        // Act
        when(empreendimentoRepository.findAll()).thenReturn(empreendimentos);
        List<Empreendimento> foundEmpreendimentos = empreendimentoService.buscarTodosEmpreendimentos();

        // Assert
        assertEquals(empreendimentos.size(), foundEmpreendimentos.size());
    }

    // Outros métodos de teste para buscarTodosEmpreendimentos() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarEmpreendimento e deletarEmpreendimento
}
