package com.FiapTravel.service;

import com.FiapTravel.model.Quarto;
import com.FiapTravel.repository.QuartoRepository;
import com.FiapTravel.serviceImpl.QuartoServiceImpl;
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

public class QuartoServiceTest {

    @Mock
    private QuartoRepository quartoRepository;

    @InjectMocks
    private QuartoServiceImpl quartoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveQuarto() {
        Quarto quarto = new Quarto();
        Mockito.when(quartoRepository.save(quarto)).thenReturn(quarto);

        Quarto savedQuarto = quartoService.save(quarto);

        Assertions.assertEquals(quarto, savedQuarto);
    }

    @Test
    public void testBuscarTodosQuartos() {
        List<Quarto> quartos = new ArrayList<>();
        Mockito.when(quartoRepository.findAll()).thenReturn(quartos);

        List<Quarto> result = quartoService.buscarTodosQuartos();

        Assertions.assertEquals(quartos, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Quarto> optional = Optional.of(new Quarto());
        Mockito.when(quartoRepository.findById(id)).thenReturn(optional);

        Optional<Quarto> result = quartoService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }

    @Test
    public void testDeletarQuarto() {
        UUID id = UUID.randomUUID();
        quartoService.deletarQuarto(id);
        Mockito.verify(quartoRepository, Mockito.times(1)).deleteById(id);
    }
}
