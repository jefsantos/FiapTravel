package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AmenidadeTest {

    @Test
    void testNoArgsConstructor() {
        Amenidade amenidade = new Amenidade();
        assertNotNull(amenidade);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idAmenidade = UUID.randomUUID();
        String descricaoAmenidade = "Descrição da amenidade";
        Amenidade amenidade = new Amenidade(idAmenidade, descricaoAmenidade);

        assertEquals(idAmenidade, amenidade.getIdAmenidade());
        assertEquals(descricaoAmenidade, amenidade.getDescricaoAmenidade());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idAmenidade1 = UUID.randomUUID();
        String descricaoAmenidade1 = "Descrição da amenidade";
        Amenidade amenidade1 = new Amenidade(idAmenidade1, descricaoAmenidade1);

        UUID idAmenidade2 = UUID.randomUUID();
        String descricaoAmenidade2 = "Descrição da amenidade";
        Amenidade amenidade2 = new Amenidade(idAmenidade2, descricaoAmenidade2);

        assertEquals(amenidade1, amenidade2); // Devem ser iguais porque têm os mesmos atributos
        assertEquals(amenidade1.hashCode(), amenidade2.hashCode());

        // Modificar um atributo deve torná-los diferentes
        amenidade2.setDescricaoAmenidade("Nova descrição da amenidade");
        assertNotEquals(amenidade1, amenidade2);
        assertNotEquals(amenidade1.hashCode(), amenidade2.hashCode());
    }

    @Test
    void testToString() {
        UUID idAmenidade = UUID.randomUUID();
        String descricaoAmenidade = "Descrição da amenidade";
        Amenidade amenidade = new Amenidade(idAmenidade, descricaoAmenidade);
        String expectedString = "Amenidade(idAmenidade=" + idAmenidade + ", descricaoAmenidade=" + descricaoAmenidade + ")";
        assertEquals(expectedString, amenidade.toString());
    }
}