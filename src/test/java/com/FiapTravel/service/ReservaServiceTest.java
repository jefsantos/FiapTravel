package com.FiapTravel.service;

import com.FiapTravel.model.Reserva;
import com.FiapTravel.repository.ReservaRepository;
import com.FiapTravel.serviceImpl.ReservaServiceImpl;
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

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveReserva() {
        Reserva reserva = new Reserva();
        Mockito.when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva savedReserva = reservaService.save(reserva);

        Assertions.assertEquals(reserva, savedReserva);
    }

    @Test
    public void testBuscarTodasReservas() {
        List<Reserva> reservas = new ArrayList<>();
        Mockito.when(reservaRepository.findAll()).thenReturn(reservas);

        List<Reserva> result = reservaService.buscarTodasReservas();

        Assertions.assertEquals(reservas, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Reserva> optional = Optional.of(new Reserva());
        Mockito.when(reservaRepository.findById(id)).thenReturn(optional);

        Optional<Reserva> result = reservaService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }

    @Test
    public void testAtualizarReserva() {
        UUID id = UUID.randomUUID();
        Reserva reserva = new Reserva();
        Mockito.when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva updatedReserva = reservaService.atualizarReserva(id, reserva);

        Assertions.assertEquals(reserva, updatedReserva);
    }

    @Test
    public void testDeletarReserva() {
        UUID id = UUID.randomUUID();
        reservaService.deletarReserva(id);
        Mockito.verify(reservaRepository, Mockito.times(1)).deleteById(id);
    }
}
