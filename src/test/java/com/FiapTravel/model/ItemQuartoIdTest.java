package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemQuartoIdTest {

    @Test
    void testNoArgsConstructor() {
        ItemQuartoId itemQuartoId = new ItemQuartoId();
        assertNotNull(itemQuartoId);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idQuarto = UUID.randomUUID();
        UUID idItem = UUID.randomUUID();

        ItemQuartoId itemQuartoId = new ItemQuartoId(idQuarto, idItem);

        assertEquals(idQuarto, itemQuartoId.getIdQuarto());
        assertEquals(idItem, itemQuartoId.getIdItem());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idQuarto = UUID.randomUUID();
        UUID idItem = UUID.randomUUID();

        ItemQuartoId itemQuartoId1 = new ItemQuartoId(idQuarto, idItem);
        ItemQuartoId itemQuartoId2 = new ItemQuartoId(idQuarto, idItem);

        assertEquals(itemQuartoId1, itemQuartoId2); // Deve ser igual porque têm os mesmos IDs
        assertEquals(itemQuartoId1.hashCode(), itemQuartoId2.hashCode());
    }

    @Test
    void testToString() {
        UUID idQuarto = UUID.randomUUID();
        UUID idItem = UUID.randomUUID();

        ItemQuartoId itemQuartoId = new ItemQuartoId(idQuarto, idItem);
        String expectedString = "ItemQuartoId(idQuarto=" + idQuarto + ", idItem=" + idItem + ")";
        assertEquals(expectedString, itemQuartoId.toString());
    }
}