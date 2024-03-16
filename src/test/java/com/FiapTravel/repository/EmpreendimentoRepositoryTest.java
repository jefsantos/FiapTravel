package com.FiapTravel.repository;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.model.User;
import com.FiapTravel.service.EmpreendimentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class EmpreendimentoRepositoryTest {

    @Mock
    private EmpreendimentoRepository empreendimentoRepository;

    @InjectMocks
    private EmpreendimentoService empreendimentoService; // Supondo que existe uma classe de serviço para Empreendimento

    @Test
    public void testFindById() {
        // Cria um empreendimento simulado
        User user = new User();
        Empreendimento empreendimento = new Empreendimento(UUID.randomUUID(), "Empreendimento A", user);

        // Configura o comportamento simulado do repositório
        when(empreendimentoRepository.findById(empreendimento.getIdEmpreendimento())).thenReturn(Optional.of(empreendimento));

        // Chama o método da classe de serviço que usa o repositório
        Optional<Empreendimento> result = empreendimentoService.buscarPorId(empreendimento.getIdEmpreendimento());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde ao empreendimento simulado
        verify(empreendimentoRepository, times(1)).findById(empreendimento.getIdEmpreendimento());
        assertEquals(empreendimento.getNomeEmpreendimento(), result.get().getNomeEmpreendimento());
    }

}
