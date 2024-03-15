package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OpcionalLocalidadeIdTest {

    @Test
    void testNoArgsConstructor() {
        OpcionalLocalidadeId opcionalLocalidadeId = new OpcionalLocalidadeId();
        assertNotNull(opcionalLocalidadeId);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();

        OpcionalLocalidadeId opcionalLocalidadeId = new OpcionalLocalidadeId(idLocalidade, idOpcional);

        assertEquals(idLocalidade, opcionalLocalidadeId.getIdLocalidade());
        assertEquals(idOpcional, opcionalLocalidadeId.getIdOpcional());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();

        OpcionalLocalidadeId opcionalLocalidadeId1 = new OpcionalLocalidadeId(idLocalidade, idOpcional);
        OpcionalLocalidadeId opcionalLocalidadeId2 = new OpcionalLocalidadeId(idLocalidade, idOpcional);

        assertEquals(opcionalLocalidadeId1, opcionalLocalidadeId2); // Deve ser igual porque têm os mesmos IDs
        assertEquals(opcionalLocalidadeId1.hashCode(), opcionalLocalidadeId2.hashCode());
    }

    @Test
    void testToString() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();

        OpcionalLocalidadeId opcionalLocalidadeId = new OpcionalLocalidadeId(idLocalidade, idOpcional);
        String expectedString = "OpcionalLocalidadeId(idLocalidade=" + idLocalidade + ", idOpcional=" + idOpcional + ")";
        assertEquals(expectedString, opcionalLocalidadeId.toString());
    }
}