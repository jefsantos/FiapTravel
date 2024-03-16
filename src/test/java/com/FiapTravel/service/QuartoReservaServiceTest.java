package com.FiapTravel.service;

import com.FiapTravel.model.QuartoReserva;
import com.FiapTravel.model.QuartoReservaId;
import com.FiapTravel.repository.QuartoReservaRepository;
import com.FiapTravel.serviceImpl.QuartoReservaServiceImpl;
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

public class QuartoReservaServiceTest {

    @Mock
    private QuartoReservaRepository quartoReservaRepository;

    @InjectMocks
    private QuartoReservaServiceImpl quartoReservaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveQuartoReserva() {
        QuartoReserva quartoReserva = new QuartoReserva();
        Mockito.when(quartoReservaRepository.save(quartoReserva)).thenReturn(quartoReserva);

        QuartoReserva savedQuartoReserva = quartoReservaService.save(quartoReserva);

        Assertions.assertEquals(quartoReserva, savedQuartoReserva);
    }

    @Test
    public void testBuscarTodasQuartoReservas() {
        List<QuartoReserva> quartoReservas = new ArrayList<>();
        Mockito.when(quartoReservaRepository.findAll()).thenReturn(quartoReservas);

        List<QuartoReserva> result = quartoReservaService.buscarTodasQuartoReservas();

        Assertions.assertEquals(quartoReservas, result);
    }

    @Test
    public void testBuscarPorId() {
        QuartoReservaId id = new QuartoReservaId();
        Optional<QuartoReserva> optional = Optional.of(new QuartoReserva());
        Mockito.when(quartoReservaRepository.findById(id)).thenReturn(optional);

        Optional<QuartoReserva> result = quartoReservaService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarQuartoReserva() {
        QuartoReservaId id = new QuartoReservaId();
        quartoReservaService.deletarQuartoReserva(id);
        Mockito.verify(quartoReservaRepository, Mockito.times(1)).deleteById(id);
    }
}
