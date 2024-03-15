package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PredioTest {

    @Test
    void testNoArgsConstructor() {
        Predio predio = new Predio();
        assertNotNull(predio);
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        Localidade localidade = new Localidade();
        Predio predio = new Predio(id, "Nome do Predio", localidade);

        assertEquals(id, predio.getIdPredio());
        assertEquals("Nome do Predio", predio.getNomePredio());
        assertEquals(localidade, predio.getLocalidade());
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        Localidade localidade = new Localidade();
        localidade.setIdLocalidade(UUID.randomUUID());

        Predio predio = new Predio(id, "Nome do Predio", localidade);
        String expectedString = "Predio(idPredio=" + id + ", nomePredio=Nome do Predio, localidade=" + localidade + ")";
        assertEquals(expectedString, predio.toString());
    }
}