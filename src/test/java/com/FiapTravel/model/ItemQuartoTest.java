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
    void testEqualsAndHashCode() {
        UUID idQuarto1 = UUID.randomUUID();
        UUID idQuarto2 = UUID.randomUUID();
        UUID idItem1 = UUID.randomUUID();
        UUID idItem2 = UUID.randomUUID();

        ItemQuartoId id1 = new ItemQuartoId();
        ItemQuartoId id2 = new ItemQuartoId();
        ItemQuartoId id3 = new ItemQuartoId();

        Quarto quarto1 = new Quarto();
        Quarto quarto2 = new Quarto();
        Item item1 = new Item();
        Item item2 = new Item();
        int quantidade1 = 3;
        int quantidade2 = 4;

        ItemQuarto itemQuarto1 = new ItemQuarto(id1, quarto1, item1, quantidade1);
        ItemQuarto itemQuarto2 = new ItemQuarto(id2, quarto2, item2, quantidade2);
        ItemQuarto itemQuarto3 = new ItemQuarto(id3, quarto1, item1, quantidade1);

        assertEquals(itemQuarto1, itemQuarto2); // Deve ser igual porque têm o mesmo ID
        assertNotEquals(itemQuarto1, itemQuarto3); // Deve ser diferente porque têm IDs diferentes

        assertEquals(itemQuarto1.hashCode(), itemQuarto2.hashCode());
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