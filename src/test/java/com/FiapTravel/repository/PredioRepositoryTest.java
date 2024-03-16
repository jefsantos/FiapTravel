package com.FiapTravel.repository;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.model.Predio;
import com.FiapTravel.service.PredioService;
import org.junit.jupiter.api.BeforeEach;
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
public class PredioRepositoryTest {

    @Mock
    private PredioRepository predioRepository;

    @InjectMocks
    private PredioService predioService; // Supondo que existe uma classe de serviço para Predio

    private Predio predio;

    @BeforeEach
    public void setUp() {
        // Configura um predio simulado antes de cada teste
        Localidade localidade = new Localidade(UUID.randomUUID(), "Localidade A", "Rua ABC", "12345-678", "São Paulo", "Centro", "SP", null);
        predio = new Predio(UUID.randomUUID(), "Predio A", localidade);
    }

    @Test
    public void testFindById() {
        // Configura o comportamento simulado do repositório para encontrar o predio por ID
        when(predioRepository.findById(predio.getIdPredio())).thenReturn(Optional.of(predio));

        // Chama o método da classe de serviço que encontra o predio por ID
        Optional<Predio> foundPredio = predioService.buscarPorId(predio.getIdPredio());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao predio simulado
        verify(predioRepository, times(1)).findById(predio.getIdPredio());
        assertEquals(predio, foundPredio.get());
    }

    @Test
    public void testFindAll() {
        // Configura uma lista simulada de predios
        List<Predio> predios = new ArrayList<>();
        predios.add(predio);

        // Configura o comportamento simulado do repositório para encontrar todos os predios
        when(predioRepository.findAll()).thenReturn(predios);

        // Chama o método da classe de serviço que encontra todos os predios
        List<Predio> foundPredios = predioService.buscarTodosPredios();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada de predios
        verify(predioRepository, times(1)).findAll();
        assertEquals(predios.size(), foundPredios.size());
        assertEquals(predio, foundPredios.get(0));
    }

    @Test
    public void testSave() {
        // Configura o comportamento simulado do repositório para salvar o predio
        when(predioRepository.save(predio)).thenReturn(predio);

        // Chama o método da classe de serviço que salva o predio
        Predio savedPredio = predioService.save(predio);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao predio simulado
        verify(predioRepository, times(1)).save(predio);
        assertEquals(predio, savedPredio);
    }

    @Test
    public void testDelete() {
        // Chama o método da classe de serviço que deleta o predio
        predioService.deletarPredio(UUID.randomUUID());

        // Verifica se o método do repositório foi chamado para deletar o predio
        verify(predioRepository, times(1)).delete(predio);
    }

}
