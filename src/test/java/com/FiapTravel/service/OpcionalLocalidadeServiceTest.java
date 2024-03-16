package com.FiapTravel.service;

import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;
import com.FiapTravel.repository.OpcionalLocalidadeRepository;
import com.FiapTravel.serviceImpl.OpcionalLocalidadeServiceImpl;
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

public class OpcionalLocalidadeServiceTest {

    @Mock
    private OpcionalLocalidadeRepository opcionalLocalidadeRepository;

    @InjectMocks
    private OpcionalLocalidadeServiceImpl opcionalLocalidadeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOpcionalLocalidade() {
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        Mockito.when(opcionalLocalidadeRepository.save(opcionalLocalidade)).thenReturn(opcionalLocalidade);

        OpcionalLocalidade savedOpcionalLocalidade = opcionalLocalidadeService.save(opcionalLocalidade);

        Assertions.assertEquals(opcionalLocalidade, savedOpcionalLocalidade);
    }

    @Test
    public void testBuscarTodosOpcionaisLocalidades() {
        List<OpcionalLocalidade> opcionaisLocalidades = new ArrayList<>();
        Mockito.when(opcionalLocalidadeRepository.findAll()).thenReturn(opcionaisLocalidades);

        List<OpcionalLocalidade> result = opcionalLocalidadeService.buscarTodosOpcionaisLocalidades();

        Assertions.assertEquals(opcionaisLocalidades, result);
    }

    @Test
    public void testBuscarPorId() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        Optional<OpcionalLocalidade> optional = Optional.of(new OpcionalLocalidade());
        Mockito.when(opcionalLocalidadeRepository.findById(id)).thenReturn(optional);

        Optional<OpcionalLocalidade> result = opcionalLocalidadeService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }



    @Test
    public void testDeletarOpcionalLocalidade() {
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        opcionalLocalidadeService.deletarOpcionalLocalidade(id);
        Mockito.verify(opcionalLocalidadeRepository, Mockito.times(1)).deleteById(id);
    }
}
