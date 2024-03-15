package com.FiapTravel.service;

import com.FiapTravel.model.OpcionalReserva;
import com.FiapTravel.model.OpcionalReservaId;
import com.FiapTravel.repository.OpcionalReservaRepository;
import com.FiapTravel.serviceImpl.OpcionalReservaServiceImpl;
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

public class OpcionalReservaServiceTest {

    @Mock
    private OpcionalReservaRepository opcionalReservaRepository;

    @InjectMocks
    private OpcionalReservaServiceImpl opcionalReservaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOpcionalReserva() {
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        Mockito.when(opcionalReservaRepository.save(opcionalReserva)).thenReturn(opcionalReserva);

        OpcionalReserva savedOpcionalReserva = opcionalReservaService.save(opcionalReserva);

        Assertions.assertEquals(opcionalReserva, savedOpcionalReserva);
    }

    @Test
    public void testBuscarTodosOpcionaisReserva() {
        List<OpcionalReserva> opcionaisReserva = new ArrayList<>();
        Mockito.when(opcionalReservaRepository.findAll()).thenReturn(opcionaisReserva);

        List<OpcionalReserva> result = opcionalReservaService.buscarTodosOpcionaisReserva();

        Assertions.assertEquals(opcionaisReserva, result);
    }

    @Test
    public void testBuscarPorId() {
        OpcionalReservaId id = new OpcionalReservaId();
        Optional<OpcionalReserva> optional = Optional.of(new OpcionalReserva());
        Mockito.when(opcionalReservaRepository.findById(id)).thenReturn(optional);

        Optional<OpcionalReserva> result = opcionalReservaService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }

    @Test
    public void testAtualizarOpcionalReserva() {
        OpcionalReservaId id = new OpcionalReservaId();
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        Mockito.when(opcionalReservaRepository.save(opcionalReserva)).thenReturn(opcionalReserva);

        OpcionalReserva updatedOpcionalReserva = opcionalReservaService.atualizarOpcionalReserva(id, opcionalReserva);

        Assertions.assertEquals(opcionalReserva, updatedOpcionalReserva);
    }

    @Test
    public void testDeletarOpcionalReserva() {
        OpcionalReservaId id = new OpcionalReservaId();
        opcionalReservaService.deletarOpcionalReserva(id);
        Mockito.verify(opcionalReservaRepository, Mockito.times(1)).deleteById(id);
    }
}
