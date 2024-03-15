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
    void testToString() {
        UUID idAmenidade = UUID.randomUUID();
        String descricaoAmenidade = "Descrição da amenidade";
        Amenidade amenidade = new Amenidade(idAmenidade, descricaoAmenidade);
        String expectedString = "Amenidade(idAmenidade=" + idAmenidade + ", descricaoAmenidade=" + descricaoAmenidade + ")";
        assertEquals(expectedString, amenidade.toString());
    }
}