package com.FiapTravel.service;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.repository.LocalidadeRepository;
import com.FiapTravel.serviceImpl.LocalidadeServiceImpl;
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

public class LocalidadeServiceTest {

    @Mock
    private LocalidadeRepository localidadeRepository;

    @InjectMocks
    private LocalidadeServiceImpl localidadeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveLocalidade() {
        Localidade localidade = new Localidade();
        Mockito.when(localidadeRepository.save(localidade)).thenReturn(localidade);

        Localidade savedLocalidade = localidadeService.save(localidade);

        Assertions.assertEquals(localidade, savedLocalidade);
    }

    @Test
    public void testBuscarTodasLocalidades() {
        List<Localidade> localidades = new ArrayList<>();
        Mockito.when(localidadeRepository.findAll()).thenReturn(localidades);

        List<Localidade> result = localidadeService.buscarTodasLocalidades();

        Assertions.assertEquals(localidades, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Localidade> optional = Optional.of(new Localidade());
        Mockito.when(localidadeRepository.findById(id)).thenReturn(optional);

        Optional<Localidade> result = localidadeService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarLocalidade() {
        UUID id = UUID.randomUUID();
        localidadeService.deletarLocalidade(id);
        Mockito.verify(localidadeRepository, Mockito.times(1)).deleteById(id);
    }
}
