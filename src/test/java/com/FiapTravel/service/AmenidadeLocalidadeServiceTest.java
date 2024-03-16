package com.FiapTravel.service;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;
import com.FiapTravel.repository.AmenidadeLocalidadeRepository;
import com.FiapTravel.serviceImpl.AmenidadeLocalidadeServiceImpl;
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

public class AmenidadeLocalidadeServiceTest {

    @Mock
    private AmenidadeLocalidadeRepository amenidadeLocalidadeRepository;

    @InjectMocks
    private AmenidadeLocalidadeServiceImpl amenidadeLocalidadeService; // Use a implementação concreta aqui

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAmenidadeLocalidade() {
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade();
        Mockito.when(amenidadeLocalidadeRepository.save(amenidadeLocalidade)).thenReturn(amenidadeLocalidade);

        AmenidadeLocalidade savedAmenidadeLocalidade = amenidadeLocalidadeService.save(amenidadeLocalidade);

        Assertions.assertEquals(amenidadeLocalidade, savedAmenidadeLocalidade);
    }

    @Test
    public void testBuscarTodasAmenidadesLocalidades() {
        List<AmenidadeLocalidade> amenidades = new ArrayList<>();
        Mockito.when(amenidadeLocalidadeRepository.findAll()).thenReturn(amenidades);

        List<AmenidadeLocalidade> result = amenidadeLocalidadeService.buscarTodasAmenidadesLocalidades();

        Assertions.assertEquals(amenidades, result);
    }

    @Test
    public void testBuscarPorId() {
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        Optional<AmenidadeLocalidade> optional = Optional.of(new AmenidadeLocalidade());
        Mockito.when(amenidadeLocalidadeRepository.findById(id)).thenReturn(optional);

        Optional<AmenidadeLocalidade> result = amenidadeLocalidadeService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }

    @Test
    public void testDeletarAmenidadeLocalidade() {
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        amenidadeLocalidadeService.deletarAmenidadeLocalidade(id);
        Mockito.verify(amenidadeLocalidadeRepository, Mockito.times(1)).deleteById(id);
    }
}
