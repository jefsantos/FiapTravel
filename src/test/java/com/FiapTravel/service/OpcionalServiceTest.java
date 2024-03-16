package com.FiapTravel.service;

import com.FiapTravel.model.Opcional;
import com.FiapTravel.repository.OpcionalRepository;
import com.FiapTravel.serviceImpl.OpcionalServiceImpl;
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

public class OpcionalServiceTest {

    @Mock
    private OpcionalRepository opcionalRepository;

    @InjectMocks
    private OpcionalServiceImpl opcionalService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOpcional() {
        Opcional opcional = new Opcional();
        Mockito.when(opcionalRepository.save(opcional)).thenReturn(opcional);

        Opcional savedOpcional = opcionalService.save(opcional);

        Assertions.assertEquals(opcional, savedOpcional);
    }

    @Test
    public void testBuscarTodosOpcionais() {
        List<Opcional> opcionais = new ArrayList<>();
        Mockito.when(opcionalRepository.findAll()).thenReturn(opcionais);

        List<Opcional> result = opcionalService.buscarTodosOpcionais();

        Assertions.assertEquals(opcionais, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Opcional> optional = Optional.of(new Opcional());
        Mockito.when(opcionalRepository.findById(id)).thenReturn(optional);

        Optional<Opcional> result = opcionalService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarOpcional() {
        UUID id = UUID.randomUUID();
        opcionalService.deletarOpcional(id);
        Mockito.verify(opcionalRepository, Mockito.times(1)).deleteById(id);
    }
}
