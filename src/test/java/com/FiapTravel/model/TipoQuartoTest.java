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
    void testEqualsAndHashCode() {
        UUID idTipoQuarto1 = UUID.randomUUID();
        String nomeTipoQuarto1 = "Suite Master";
        TipoQuarto tipoQuarto1 = new TipoQuarto(idTipoQuarto1, nomeTipoQuarto1);

        UUID idTipoQuarto2 = UUID.randomUUID();
        String nomeTipoQuarto2 = "Suite Master";
        TipoQuarto tipoQuarto2 = new TipoQuarto(idTipoQuarto2, nomeTipoQuarto2);

        assertEquals(tipoQuarto1, tipoQuarto2); // Devem ser iguais porque têm os mesmos atributos
        assertEquals(tipoQuarto1.hashCode(), tipoQuarto2.hashCode());

        // Modificar um atributo deve torná-los diferentes
        tipoQuarto2.setNomeTipoQuarto("Suite Simples");
        assertNotEquals(tipoQuarto1, tipoQuarto2);
        assertNotEquals(tipoQuarto1.hashCode(), tipoQuarto2.hashCode());
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