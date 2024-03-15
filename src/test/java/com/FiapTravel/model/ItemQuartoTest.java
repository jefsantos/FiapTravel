package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemQuartoTest {

    @Test
    void testNoArgsConstructor() {
        ItemQuartoId id = new ItemQuartoId();
        ItemQuarto itemQuarto = new ItemQuarto();
        itemQuarto.setId(id);
        assertNotNull(itemQuarto);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idQuarto = UUID.randomUUID();
        UUID idItem = UUID.randomUUID();
        ItemQuartoId id = new ItemQuartoId();
        Quarto quarto = new Quarto();
        Item item = new Item();
        int quantidade = 3;

        ItemQuarto itemQuarto = new ItemQuarto(id, quarto, item, quantidade);

        assertEquals(id, itemQuarto.getId());
        assertEquals(quarto, itemQuarto.getQuarto());
        assertEquals(item, itemQuarto.getItem());
        assertEquals(quantidade, itemQuarto.getQuantidade());
    }

    @Test
    void testToString() {
        UUID idQuarto = UUID.randomUUID();
        UUID idItem = UUID.randomUUID();
        ItemQuartoId id = new ItemQuartoId();
        Quarto quarto = new Quarto();
        Item item = new Item();
        int quantidade = 3;

        ItemQuarto itemQuarto = new ItemQuarto(id, quarto, item, quantidade);
        String expectedString = "ItemQuarto(id=" + id + ", quarto=" + quarto + ", item=" + item + ", quantidade=" + quantidade + ")";
        assertEquals(expectedString, itemQuarto.toString());
    }
}