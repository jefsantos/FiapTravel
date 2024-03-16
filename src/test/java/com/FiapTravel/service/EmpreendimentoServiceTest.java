package com.FiapTravel.service;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.repository.EmpreendimentoRepository;
import com.FiapTravel.serviceImpl.EmpreendimentoServiceImpl;
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

public class EmpreendimentoServiceTest {

    @Mock
    private EmpreendimentoRepository empreendimentoRepository;

    @InjectMocks
    private EmpreendimentoServiceImpl empreendimentoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEmpreendimento() {
        Empreendimento empreendimento = new Empreendimento();
        Mockito.when(empreendimentoRepository.save(empreendimento)).thenReturn(empreendimento);

        Empreendimento savedEmpreendimento = empreendimentoService.save(empreendimento);

        Assertions.assertEquals(empreendimento, savedEmpreendimento);
    }

    @Test
    public void testBuscarTodosEmpreendimentos() {
        List<Empreendimento> empreendimentos = new ArrayList<>();
        Mockito.when(empreendimentoRepository.findAll()).thenReturn(empreendimentos);

        List<Empreendimento> result = empreendimentoService.buscarTodosEmpreendimentos();

        Assertions.assertEquals(empreendimentos, result);
    }

    @Test
    public void testBuscarPorId() {
        UUID id = UUID.randomUUID();
        Optional<Empreendimento> optional = Optional.of(new Empreendimento());
        Mockito.when(empreendimentoRepository.findById(id)).thenReturn(optional);

        Optional<Empreendimento> result = empreendimentoService.buscarPorId(id);

        Assertions.assertEquals(optional, result);
    }


    @Test
    public void testDeletarEmpreendimento() {
        UUID id = UUID.randomUUID();
        empreendimentoService.deletarEmpreendimento(id);
        Mockito.verify(empreendimentoRepository, Mockito.times(1)).deleteById(id);
    }
}
