package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OpcionalTest {

    @Test
    void testNoArgsConstructor() {
        Opcional opcional = new Opcional();
        assertNotNull(opcional);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idOpcional = UUID.randomUUID();
        String descricaoOpcional = "Descrição do Opcional";

        Opcional opcional = new Opcional(idOpcional, descricaoOpcional);

        assertEquals(idOpcional, opcional.getIdOpcional());
        assertEquals(descricaoOpcional, opcional.getDescricaoOpcional());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idOpcional = UUID.randomUUID();
        String descricaoOpcional = "Descrição do Opcional";

        Opcional opcional1 = new Opcional(idOpcional, descricaoOpcional);
        Opcional opcional2 = new Opcional(idOpcional, descricaoOpcional);

        assertEquals(opcional1, opcional2); // Deve ser igual porque têm o mesmo ID
        assertEquals(opcional1.hashCode(), opcional2.hashCode());
    }

    @Test
    void testToString() {
        UUID idOpcional = UUID.randomUUID();
        String descricaoOpcional = "Descrição do Opcional";

        Opcional opcional = new Opcional(idOpcional, descricaoOpcional);
        String expectedString = "Opcional(idOpcional=" + idOpcional + ", descricaoOpcional=" + descricaoOpcional + ")";
        assertEquals(expectedString, opcional.toString());
    }
}