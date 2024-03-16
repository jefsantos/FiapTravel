package com.FiapTravel.repository;

import com.FiapTravel.model.Predio;
import com.FiapTravel.model.Quarto;
import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.service.QuartoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class QuartoRepositoryTest {

    @Mock
    private QuartoRepository quartoRepository;

    @InjectMocks
    private QuartoService quartoService; // Supondo que existe uma classe de serviço para Quarto

    private Quarto quarto;

    @BeforeEach
    public void setup() {
        // Configura um quarto simulado antes de cada teste
        TipoQuarto tipoQuarto = new TipoQuarto(/* dados do tipo de quarto */);
        Predio predio = new Predio(/* dados do prédio */);
        quarto = new Quarto(UUID.randomUUID(), "Quarto A", 2, 10, BigDecimal.valueOf(100.0), tipoQuarto, predio);
    }

    @Test
    public void testSaveQuarto() {
        // Configura o comportamento simulado do repositório para salvar o quarto
        when(quartoRepository.save(quarto)).thenReturn(quarto);

        // Chama o método da classe de serviço que salva o quarto
        Quarto savedQuarto = quartoService.save(quarto);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao quarto simulado
        verify(quartoRepository, times(1)).save(quarto);
        assertEquals(quarto, savedQuarto);
    }

    @Test
    public void testFindById() {
        // Configura o comportamento simulado do repositório para encontrar o quarto por ID
        when(quartoRepository.findById(quarto.getIdQuarto())).thenReturn(Optional.of(quarto));

        // Chama o método da classe de serviço que encontra o quarto por ID
        Optional<Quarto> foundQuarto = quartoService.buscarPorId(quarto.getIdQuarto());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao quarto simulado
        verify(quartoRepository, times(1)).findById(quarto.getIdQuarto());
        assertEquals(quarto, foundQuarto.get());
    }

    @Test
    public void testFindAll() {
        // Configura uma lista simulada de quartos
        List<Quarto> quartos = new ArrayList<>();
        quartos.add(quarto);

        // Configura o comportamento simulado do repositório para encontrar todos os quartos
        when(quartoRepository.findAll()).thenReturn(quartos);

        // Chama o método da classe de serviço que encontra todos os quartos
        List<Quarto> foundQuartos = quartoService.buscarTodosQuartos();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada de quartos
        verify(quartoRepository, times(1)).findAll();
        assertEquals(quartos.size(), foundQuartos.size());
        assertEquals(quarto, foundQuartos.get(0));
    }

    @Test
    public void testDelete() {
        // Chama o método da classe de serviço que deleta o quarto
        quartoService.deletarQuarto(UUID.randomUUID());

        // Verifica se o método do repositório foi chamado para deletar o quarto
        verify(quartoRepository, times(1)).delete(quarto);
    }

}
