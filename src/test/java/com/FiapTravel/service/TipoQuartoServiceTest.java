package com.FiapTravel.service;

import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.repository.TipoQuartoRepository;
import com.FiapTravel.serviceImpl.TipoQuartoServiceImpl;
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

public class TipoQuartoServiceTest {

    @Mock
    private TipoQuartoRepository tipoQuartoRepository;

    @InjectMocks
    private TipoQuartoServiceImpl tipoQuartoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveTipoQuarto() {
        TipoQuarto tipoQuarto = new TipoQuarto();
        Mockito.when(tipoQuartoRepository.save(tipoQuarto)).thenReturn(tipoQuarto);

        TipoQuarto savedTipoQuarto = tipoQuartoService.save(tipoQuarto);

        Assertions.assertEquals(tipoQuarto, savedTipoQuarto);
    }

    @Test
    public void testBuscarTodosTiposQuartos() {
        List<TipoQuarto> tiposQuartos = new ArrayList<>();
        Mockito.when(tipoQuartoRepository.findAll()).thenReturn(tiposQuartos);

        List<TipoQuarto> result = tipoQuartoService.buscarTodosTiposQuartos();

        Assertions.assertEquals(tiposQuartos, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<TipoQuarto> optional = Optional.of(new TipoQuarto());
        Mockito.when(tipoQuartoRepository.findById(id)).thenReturn(optional);

        Optional<TipoQuarto> result = tipoQuartoService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarTipoQuarto() {
        UUID id = UUID.randomUUID();
        tipoQuartoService.deletarTipoQuarto(id);
        Mockito.verify(tipoQuartoRepository, Mockito.times(1)).deleteById(id);
    }
}
