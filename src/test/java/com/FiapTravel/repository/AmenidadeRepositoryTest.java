package com.FiapTravel.repository;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.service.AmenidadeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class AmenidadeRepositoryTest {

    @Mock
    private AmenidadeRepository amenidadeRepository;

    @InjectMocks
    private AmenidadeService amenidadeService;

    @Test
    public void testFindAll() {
        // Cria uma lista simulada de amenidades
        List<Amenidade> amenidades = new ArrayList<>();
        amenidades.add(new Amenidade(UUID.randomUUID(), "Piscina"));
        amenidades.add(new Amenidade(UUID.randomUUID(), "Academia"));

        // Configura o comportamento simulado do repositório
        when(amenidadeRepository.findAll()).thenReturn(amenidades);

        // Chama o método da classe de serviço que usa o repositório
        List<Amenidade> result = amenidadeService.buscarTodasAmenidades();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada
        verify(amenidadeRepository, times(1)).findAll();
        assertEquals(amenidades.size(), result.size());
        assertEquals(amenidades.get(0).getDescricaoAmenidade(), result.get(0).getDescricaoAmenidade());
        assertEquals(amenidades.get(1).getDescricaoAmenidade(), result.get(1).getDescricaoAmenidade());
    }

    @Test
    public void testFindById() {
        // Cria uma amenidade simulada
        Amenidade amenidade = new Amenidade(UUID.randomUUID(), "Piscina");

        // Configura o comportamento simulado do repositório
        when(amenidadeRepository.findById(amenidade.getIdAmenidade())).thenReturn(Optional.of(amenidade));

        // Chama o método da classe de serviço que usa o repositório
        Optional<Amenidade> result = amenidadeService.buscarPorId(amenidade.getIdAmenidade());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à amenidade simulada
        verify(amenidadeRepository, times(1)).findById(amenidade.getIdAmenidade());
        assertEquals(amenidade.getDescricaoAmenidade(), result.get().getDescricaoAmenidade());
    }

}