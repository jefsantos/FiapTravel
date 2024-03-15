package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuartoReservaIdTest {

    @Test
    void testNoArgsConstructor() {
        QuartoReservaId quartoReservaId = new QuartoReservaId();
        assertNotNull(quartoReservaId);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idQuarto = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        QuartoReservaId quartoReservaId = new QuartoReservaId(idQuarto, idReserva);
        assertEquals(idQuarto, quartoReservaId.getIdQuarto());
        assertEquals(idReserva, quartoReservaId.getIdReserva());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idQuarto1 = UUID.randomUUID();
        UUID idReserva1 = UUID.randomUUID();
        UUID idQuarto2 = UUID.randomUUID();
        UUID idReserva2 = UUID.randomUUID();

        QuartoReservaId quartoReservaId1 = new QuartoReservaId(idQuarto1, idReserva1);
        QuartoReservaId quartoReservaId2 = new QuartoReservaId(idQuarto1, idReserva1);
        QuartoReservaId quartoReservaId3 = new QuartoReservaId(idQuarto2, idReserva2);

        assertEquals(quartoReservaId1, quartoReservaId2); // Deve ser igual porque têm os mesmos IDs
        assertEquals(quartoReservaId1.hashCode(), quartoReservaId2.hashCode());
        assertNotEquals(quartoReservaId1, quartoReservaId3); // Não devem ser iguais porque têm IDs diferentes
        assertNotEquals(quartoReservaId1.hashCode(), quartoReservaId3.hashCode());
    }

    @Test
    void testToString() {
        UUID idQuarto = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        QuartoReservaId quartoReservaId = new QuartoReservaId(idQuarto, idReserva);
        String expectedString = "QuartoReservaId(idQuarto=" + idQuarto + ", idReserva=" + idReserva + ")";
        assertEquals(expectedString, quartoReservaId.toString());
    }
}