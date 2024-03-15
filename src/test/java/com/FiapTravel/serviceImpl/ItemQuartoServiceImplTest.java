package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;
import com.FiapTravel.repository.ItemQuartoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ItemQuartoServiceImplTest {

    @Mock
    private ItemQuartoRepository itemQuartoRepository;

    @InjectMocks
    private ItemQuartoServiceImpl itemQuartoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_ItemQuartoValido_SalvarComSucesso() {
        // Arrange
        ItemQuarto itemQuarto = new ItemQuarto();
        ItemQuartoId itemQuartoId = new ItemQuartoId();

        // Act
        when(itemQuartoRepository.save(itemQuarto)).thenReturn(itemQuarto);
        ItemQuarto savedItemQuarto = itemQuartoService.save(itemQuarto);

        // Assert
        assertNotNull(savedItemQuarto);
        assertEquals(itemQuarto, savedItemQuarto);
    }

    @Test
    void save_ItemQuartoNulo_LancarExcecao() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class, () -> itemQuartoService.save(null));
    }

    @Test
    void buscarTodosItensQuartos_ItensQuartosPresentes_RetornarListaCorreta() {
        // Arrange
        List<ItemQuarto> itensQuarto = List.of(new ItemQuarto(), new ItemQuarto());

        // Act
        when(itemQuartoRepository.findAll()).thenReturn(itensQuarto);
        List<ItemQuarto> foundItensQuarto = itemQuartoService.buscarTodosItensQuartos();

        // Assert
        assertEquals(itensQuarto.size(), foundItensQuarto.size());
    }

    // Outros métodos de teste para buscarTodosItensQuartos() podem ser implementados para cobrir outros cenários

    // Testes semelhantes para os métodos restantes como buscarPorId, atualizarItemQuarto e deletarItemQuarto
}
