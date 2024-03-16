package com.FiapTravel.repository;

import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.service.TipoQuartoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class TipoQuartoRepositoryTest {

    @Mock
    private TipoQuartoRepository tipoQuartoRepository;

    @InjectMocks
    private TipoQuartoService tipoQuartoService; // Supondo que existe uma classe de serviço para TipoQuarto

    @Test
    public void testSaveTipoQuarto() {
        // Configura um tipo de quarto simulado
        UUID id = UUID.randomUUID();
        TipoQuarto tipoQuarto = new TipoQuarto(id, "Quarto Simples");

        // Configura o comportamento simulado do repositório para salvar o tipo de quarto
        when(tipoQuartoRepository.save(tipoQuarto)).thenReturn(tipoQuarto);

        // Chama o método da classe de serviço que salva o tipo de quarto
        TipoQuarto savedTipoQuarto = tipoQuartoService.save(tipoQuarto);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao tipo de quarto simulado
        verify(tipoQuartoRepository, times(1)).save(tipoQuarto);
        assertEquals(tipoQuarto, savedTipoQuarto);
    }

    @Test
    public void testFindById() {
        // Configura um tipo de quarto simulado
        UUID id = UUID.randomUUID();
        TipoQuarto tipoQuarto = new TipoQuarto(id, "Quarto Duplo");

        // Configura o comportamento simulado do repositório para encontrar o tipo de quarto por ID
        when(tipoQuartoRepository.findById(id)).thenReturn(Optional.of(tipoQuarto));

        // Chama o método da classe de serviço que encontra o tipo de quarto por ID
        Optional<TipoQuarto> foundTipoQuarto = tipoQuartoService.buscarPorId(id);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao tipo de quarto simulado
        verify(tipoQuartoRepository, times(1)).findById(id);
        assertEquals(tipoQuarto, foundTipoQuarto.get());
    }

    @Test
    public void testFindAll() {
        // Configura uma lista simulada de tipos de quartos
        List<TipoQuarto> tiposQuarto = new ArrayList<>();
        tiposQuarto.add(new TipoQuarto(UUID.randomUUID(), "Quarto Individual"));
        tiposQuarto.add(new TipoQuarto(UUID.randomUUID(), "Quarto Duplo"));
        tiposQuarto.add(new TipoQuarto(UUID.randomUUID(), "Quarto Triplo"));

        // Configura o comportamento simulado do repositório para encontrar todos os tipos de quartos
        when(tipoQuartoRepository.findAll()).thenReturn(tiposQuarto);

        // Chama o método da classe de serviço que encontra todos os tipos de quartos
        List<TipoQuarto> foundTiposQuarto = tipoQuartoService.buscarTodosTiposQuartos();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada de tipos de quartos
        verify(tipoQuartoRepository, times(1)).findAll();
        assertEquals(tiposQuarto.size(), foundTiposQuarto.size());
        assertEquals(tiposQuarto, foundTiposQuarto);
    }

    @Test
    public void testDelete() {
        // Configura um tipo de quarto simulado para deletar
        UUID id = UUID.randomUUID();
        TipoQuarto tipoQuarto = new TipoQuarto(id, "Quarto Individual");

        // Chama o método da classe de serviço que deleta o tipo de quarto
        tipoQuartoService.deletarTipoQuarto(UUID.randomUUID());

        // Verifica se o método do repositório foi chamado para deletar o tipo de quarto
        verify(tipoQuartoRepository, times(1)).delete(tipoQuarto);
    }

}
