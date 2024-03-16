package com.FiapTravel.service;

import com.FiapTravel.model.Predio;
import com.FiapTravel.repository.PredioRepository;
import com.FiapTravel.serviceImpl.PredioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PredioServiceTest {

    @Mock
    private PredioRepository predioRepository;

    @InjectMocks
    private PredioServiceImpl predioService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePredio() {
        Predio predio = new Predio();
        Mockito.when(predioRepository.save(predio)).thenReturn(predio);

        Predio savedPredio = predioService.save(predio);

        Assertions.assertEquals(predio, savedPredio);
    }

    @Test
    public void testBuscarTodosPredios() {
        List<Predio> predios = new ArrayList<>();
        Mockito.when(predioRepository.findAll()).thenReturn(predios);

        List<Predio> result = predioService.buscarTodosPredios();

        Assertions.assertEquals(predios, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Predio> optional = Optional.of(new Predio());
        Mockito.when(predioRepository.findById(id)).thenReturn(optional);

        Optional<Predio> result = predioService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarPredio() {
        UUID id = UUID.randomUUID();
        predioService.deletarPredio(id);
        Mockito.verify(predioRepository, Mockito.times(1)).deleteById(id);
    }
}
