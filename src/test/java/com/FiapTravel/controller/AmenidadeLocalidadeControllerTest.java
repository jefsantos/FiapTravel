package com.FiapTravel.controller;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.service.AmenidadeLocalidadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AmenidadeLocalidadeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AmenidadeLocalidadeService amenidadeLocalidadeService;

    @InjectMocks
    private AmenidadeLocalidadeController amenidadeLocalidadeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(amenidadeLocalidadeController).build();
    }

    @Test
    void testCriarAmenidadeLocalidade() throws Exception {
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade();
        // Configurar comportamento do serviço mock
        when(amenidadeLocalidadeService.save(any())).thenReturn(amenidadeLocalidade);

        mockMvc.perform(post("/amenidadeslocalidades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    void testBuscarTodasAmenidadesLocalidades() throws Exception {
        AmenidadeLocalidade amenidadeLocalidade1 = new AmenidadeLocalidade();
        AmenidadeLocalidade amenidadeLocalidade2 = new AmenidadeLocalidade();
        List<AmenidadeLocalidade> amenidadesLocalidades = Arrays.asList(amenidadeLocalidade1, amenidadeLocalidade2);
        // Configurar comportamento do serviço mock
        when(amenidadeLocalidadeService.buscarTodasAmenidadesLocalidades()).thenReturn(amenidadesLocalidades);

        mockMvc.perform(get("/amenidadeslocalidades"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }




}
