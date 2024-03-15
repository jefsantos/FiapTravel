package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OpcionalReservaIdTest {

    @Test
    void testNoArgsConstructor() {
        OpcionalReservaId opcionalReservaId = new OpcionalReservaId();
        assertNotNull(opcionalReservaId);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();

        OpcionalReservaId opcionalReservaId = new OpcionalReservaId(idLocalidade, idReserva, idOpcional);

        assertEquals(idLocalidade, opcionalReservaId.getIdLocalidade());
        assertEquals(idReserva, opcionalReservaId.getIdReserva());
        assertEquals(idOpcional, opcionalReservaId.getIdOpcional());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idLocalidade1 = UUID.randomUUID();
        UUID idReserva1 = UUID.randomUUID();
        UUID idOpcional1 = UUID.randomUUID();
        OpcionalReservaId id1 = new OpcionalReservaId(idLocalidade1, idReserva1, idOpcional1);

        UUID idLocalidade2 = UUID.randomUUID();
        UUID idReserva2 = UUID.randomUUID();
        UUID idOpcional2 = UUID.randomUUID();
        OpcionalReservaId id2 = new OpcionalReservaId(idLocalidade2, idReserva2, idOpcional2);

        assertNotEquals(id1, id2); // Deve ser diferente porque têm IDs diferentes
        assertNotEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void testGetters() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();

        OpcionalReservaId opcionalReservaId = new OpcionalReservaId(idLocalidade, idReserva, idOpcional);

        assertEquals(idLocalidade, opcionalReservaId.getIdLocalidade());
        assertEquals(idReserva, opcionalReservaId.getIdReserva());
        assertEquals(idOpcional, opcionalReservaId.getIdOpcional());
    }
}