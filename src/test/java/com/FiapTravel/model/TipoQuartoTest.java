package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TipoQuartoTest {

    @Test
    void testNoArgsConstructor() {
        TipoQuarto tipoQuarto = new TipoQuarto();
        assertNotNull(tipoQuarto);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idTipoQuarto = UUID.randomUUID();
        String nomeTipoQuarto = "Suite Master";
        TipoQuarto tipoQuarto = new TipoQuarto(idTipoQuarto, nomeTipoQuarto);

        assertEquals(idTipoQuarto, tipoQuarto.getIdTipoQuarto());
        assertEquals(nomeTipoQuarto, tipoQuarto.getNomeTipoQuarto());
    }

    @Test
    void testToString() {
        UUID idTipoQuarto = UUID.randomUUID();
        String nomeTipoQuarto = "Suite Master";
        TipoQuarto tipoQuarto = new TipoQuarto(idTipoQuarto, nomeTipoQuarto);
        String expectedString = "TipoQuarto(idTipoQuarto=" + idTipoQuarto + ", nomeTipoQuarto=" + nomeTipoQuarto + ")";
        assertEquals(expectedString, tipoQuarto.toString());
    }
}