package com.FiapTravel.controller;

import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.service.TipoQuartoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TipoQuartoControllerTest {

    @Test
    public void testCriarTipoQuarto() {
        TipoQuarto tipoQuarto = new TipoQuarto();

        TipoQuartoService tipoQuartoService = Mockito.mock(TipoQuartoService.class);
        Mockito.when(tipoQuartoService.save(tipoQuarto)).thenReturn(tipoQuarto);

        TipoQuartoController tipoQuartoController = new TipoQuartoController(tipoQuartoService);

        ResponseEntity<TipoQuarto> response = tipoQuartoController.criarTipoQuarto(tipoQuarto);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(tipoQuarto, response.getBody());
    }

    @Test
    public void testBuscarTodosTiposQuartos() {
        List<TipoQuarto> tiposQuartos = new ArrayList<>();
        tiposQuartos.add(new TipoQuarto());
        tiposQuartos.add(new TipoQuarto());

        TipoQuartoService tipoQuartoService = Mockito.mock(TipoQuartoService.class);
        Mockito.when(tipoQuartoService.buscarTodosTiposQuartos()).thenReturn(tiposQuartos);

        TipoQuartoController tipoQuartoController = new TipoQuartoController(tipoQuartoService);

        ResponseEntity<List<TipoQuarto>> response = tipoQuartoController.buscarTodosTiposQuartos();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(tiposQuartos, response.getBody());
    }

    // Outros testes para os métodos restantes podem ser implementados de maneira semelhante
}
