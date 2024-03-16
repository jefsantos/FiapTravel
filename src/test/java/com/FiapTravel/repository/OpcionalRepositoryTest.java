package com.FiapTravel.repository;

import com.FiapTravel.model.Opcional;
import com.FiapTravel.service.OpcionalService;
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
public class OpcionalRepositoryTest {

    @Mock
    private OpcionalRepository opcionalRepository;

    @InjectMocks
    private OpcionalService opcionalService; // Supondo que existe uma classe de serviço para Opcional

    @Test
    public void testFindAll() {
        // Cria uma lista simulada de opcionais
        List<Opcional> opcionais = new ArrayList<>();
        opcionais.add(new Opcional(UUID.randomUUID(), "Opcional A"));
        opcionais.add(new Opcional(UUID.randomUUID(), "Opcional B"));

        // Configura o comportamento simulado do repositório
        when(opcionalRepository.findAll()).thenReturn(opcionais);

        // Chama o método da classe de serviço que usa o repositório
        List<Opcional> result = opcionalService.buscarTodosOpcionais();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada
        verify(opcionalRepository, times(1)).findAll();
        assertEquals(opcionais.size(), result.size());
        assertEquals(opcionais.get(0).getDescricaoOpcional(), result.get(0).getDescricaoOpcional());
        assertEquals(opcionais.get(1).getDescricaoOpcional(), result.get(1).getDescricaoOpcional());
    }

    @Test
    public void testFindById() {
        // Cria um opcional simulado
        Opcional opcional = new Opcional(UUID.randomUUID(), "Opcional C");

        // Configura o comportamento simulado do repositório
        when(opcionalRepository.findById(opcional.getIdOpcional())).thenReturn(Optional.of(opcional));

        // Chama o método da classe de serviço que usa o repositório
        Optional<Opcional> result = opcionalService.buscarPorId(opcional.getIdOpcional());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao opcional simulado
        verify(opcionalRepository, times(1)).findById(opcional.getIdOpcional());
        assertEquals(opcional.getDescricaoOpcional(), result.get().getDescricaoOpcional());
    }

    // Adicione outros casos de teste conforme necessário
}
