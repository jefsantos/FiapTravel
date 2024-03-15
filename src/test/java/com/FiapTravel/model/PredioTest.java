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
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        Localidade localidade1 = new Localidade();
        localidade1.setIdLocalidade(UUID.randomUUID());
        Localidade localidade2 = new Localidade();
        localidade2.setIdLocalidade(UUID.randomUUID());

        Predio predio1 = new Predio(id, "Nome do Predio", localidade1);
        Predio predio2 = new Predio(id, "Nome do Predio", localidade2);
        Predio predio3 = new Predio(UUID.randomUUID(), "Nome do Predio", localidade1);

        assertEquals(predio1, predio2); // Deve ser igual porque têm o mesmo ID
        assertNotEquals(predio1, predio3); // Deve ser diferente porque têm IDs diferentes

        assertEquals(predio1.hashCode(), predio2.hashCode());
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