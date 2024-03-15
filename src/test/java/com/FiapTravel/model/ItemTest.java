package com.FiapTravel.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class ItemTest {

    @Test
    public void testNoArgsConstructor() {
        // Arrange
        // Nenhum argumento é necessário, pois estamos testando o construtor padrão

        // Act
        Item item = new Item();

        // Assert
        assertNotNull(item);
    }

    @Test
    public void testAllArgsConstructor() {
        // Arrange
        UUID id = UUID.randomUUID();
        String descricao = "Descrição do item";

        // Act
        Item item = new Item(id, descricao);

        // Assert
        assertNotNull(item);
        assertEquals(id, item.getIdItem());
        assertEquals(descricao, item.getDescricaoItem());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        Item item = new Item();
        UUID id = UUID.randomUUID();
        String descricao = "Descrição do item";

        // Act
        item.setIdItem(id);
        item.setDescricaoItem(descricao);

        // Assert
        assertEquals(id, item.getIdItem());
        assertEquals(descricao, item.getDescricaoItem());
    }

    @Test
    public void testEqualsAndHashCode() {
// Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Item item1 = new Item(id1, "Descrição 1");
        Item item2 = new Item(id1, "Descrição 1"); // Corrigido para ter a mesma descrição
        Item item3 = new Item(id2, "Descrição 1");

        // Act & Assert
        assertEquals(item1, item1); // Reflexividade
        assertNotEquals(item1, null); // Não deve ser igual a null
        assertNotEquals(item1, new Object()); // Não deve ser igual a outro objeto
        assertEquals(item1, item2); // Deve ser igual se tiverem o mesmo id e a mesma descrição
        assertNotEquals(item1, item3); // Não deve ser igual se tiverem ids diferentes
        assertEquals(item1.hashCode(), item2.hashCode()); // HashCodes iguais para objetos iguais
        assertNotEquals(item1.hashCode(), item3.hashCode()); // HashCodes diferentes para objetos diferentes
    }

    @Test
    public void testToString() {
        // Arrange
        UUID id = UUID.randomUUID();
        String descricao = "Descrição do item";
        Item item = new Item(id, descricao);

        // Act
        String expectedToString = "Item(idItem=" + id + ", descricaoItem=" + descricao + ")";

        // Assert
        assertEquals(expectedToString, item.toString());
    }
}

