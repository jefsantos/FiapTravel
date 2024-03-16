package com.FiapTravel.repository;

import com.FiapTravel.model.Item;
import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;
import com.FiapTravel.model.Quarto;
import com.FiapTravel.service.ItemQuartoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ItemQuartoRepositoryTest {

    @Mock
    private ItemQuartoRepository itemQuartoRepository;

    @InjectMocks
    private ItemQuartoService itemQuartoService; // Supondo que existe uma classe de serviço para ItemQuarto

    @Test
    public void testFindById() {
        // Cria um objeto ItemQuartoId simulado
        Item item = new Item(/* dados do item */);
        Quarto quarto = new Quarto(/* dados do quarto */);
        ItemQuartoId id = new ItemQuartoId();

        // Cria um ItemQuarto simulado
        ItemQuarto itemQuarto = new ItemQuarto(id, quarto, item, 2);

        // Configura o comportamento simulado do repositório
        when(itemQuartoRepository.findById(id)).thenReturn(Optional.of(itemQuarto));

        // Chama o método da classe de serviço que usa o repositório
        Optional<ItemQuarto> result = itemQuartoService.buscarPorId(id);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao ItemQuarto simulado
        verify(itemQuartoRepository, times(1)).findById(id);
        assertEquals(itemQuarto.getQuantidade(), result.get().getQuantidade());
    }

}
