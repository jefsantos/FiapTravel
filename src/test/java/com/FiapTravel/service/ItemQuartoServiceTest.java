package com.FiapTravel.service;

import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;
import com.FiapTravel.repository.ItemQuartoRepository;
import com.FiapTravel.serviceImpl.ItemQuartoServiceImpl;
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

public class ItemQuartoServiceTest {

    @Mock
    private ItemQuartoRepository itemQuartoRepository;

    @InjectMocks
    private ItemQuartoServiceImpl itemQuartoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveItemQuarto() {
        ItemQuarto itemQuarto = new ItemQuarto();
        Mockito.when(itemQuartoRepository.save(itemQuarto)).thenReturn(itemQuarto);

        ItemQuarto savedItemQuarto = itemQuartoService.save(itemQuarto);

        Assertions.assertEquals(itemQuarto, savedItemQuarto);
    }

    @Test
    public void testBuscarTodosItensQuartos() {
        List<ItemQuarto> itensQuartos = new ArrayList<>();
        Mockito.when(itemQuartoRepository.findAll()).thenReturn(itensQuartos);

        List<ItemQuarto> result = itemQuartoService.buscarTodosItensQuartos();

        Assertions.assertEquals(itensQuartos, result);
    }

    @Test
    public void testBuscarPorId() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();
        Optional<ItemQuarto> optional = Optional.of(new ItemQuarto());
        Mockito.when(itemQuartoRepository.findById(itemQuartoId)).thenReturn(optional);

        Optional<ItemQuarto> result = itemQuartoService.buscarPorId(itemQuartoId);

        Assertions.assertEquals(optional, result);
    }

    @Test
    public void testAtualizarItemQuarto() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();
        ItemQuarto itemQuarto = new ItemQuarto();
        Mockito.when(itemQuartoRepository.save(itemQuarto)).thenReturn(itemQuarto);

        ItemQuarto updatedItemQuarto = itemQuartoService.atualizarItemQuarto(itemQuartoId, itemQuarto);

        Assertions.assertEquals(itemQuarto, updatedItemQuarto);
    }

    @Test
    public void testDeletarItemQuarto() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();
        itemQuartoService.deletarItemQuarto(itemQuartoId);
        Mockito.verify(itemQuartoRepository, Mockito.times(1)).deleteById(itemQuartoId);
    }
}
