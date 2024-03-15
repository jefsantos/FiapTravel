package com.FiapTravel.service;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.repository.AmenidadeRepository;
import com.FiapTravel.serviceImpl.AmenidadeServiceImpl;
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

public class AmenidadeServiceTest {

    @Mock
    private AmenidadeRepository amenidadeRepository;

    @InjectMocks
    private AmenidadeServiceImpl amenidadeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAmenidade() {
        Amenidade amenidade = new Amenidade();
        Mockito.when(amenidadeRepository.save(amenidade)).thenReturn(amenidade);

        Amenidade savedAmenidade = amenidadeService.save(amenidade);

        Assertions.assertEquals(amenidade, savedAmenidade);
    }

    @Test
    public void testBuscarTodasAmenidades() {
        List<Amenidade> amenidades = new ArrayList<>();
        Mockito.when(amenidadeRepository.findAll()).thenReturn(amenidades);

        List<Amenidade> result = amenidadeService.buscarTodasAmenidades();

        Assertions.assertEquals(amenidades, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Amenidade> optional = Optional.of(new Amenidade());
        Mockito.when(amenidadeRepository.findById(id)).thenReturn(optional);

        Optional<Amenidade> result = amenidadeService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }

    @Test
    public void testAtualizarAmenidade() {
        UUID id = UUID.randomUUID();
        Amenidade amenidade = new Amenidade();
        Mockito.when(amenidadeRepository.save(amenidade)).thenReturn(amenidade);

        Amenidade updatedAmenidade = amenidadeService.atualizarAmenidade(id, amenidade);

        Assertions.assertEquals(amenidade, updatedAmenidade);
    }

    @Test
    public void testDeletarAmenidade() {
        UUID id = UUID.randomUUID();
        amenidadeService.deletarAmenidade(id);
        Mockito.verify(amenidadeRepository, Mockito.times(1)).deleteById(id);
    }
}
