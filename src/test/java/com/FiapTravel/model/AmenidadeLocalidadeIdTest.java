package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AmenidadeLocalidadeIdTest {

    @Test
    void testNoArgsConstructor() {
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        assertNotNull(id);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idAmenidade = UUID.randomUUID();
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId(idLocalidade, idAmenidade);

        assertEquals(idLocalidade, id.getIdLocalidade());
        assertEquals(idAmenidade, id.getIdAmenidade());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idLocalidade1 = UUID.randomUUID();
        UUID idAmenidade1 = UUID.randomUUID();
        AmenidadeLocalidadeId id1 = new AmenidadeLocalidadeId(idLocalidade1, idAmenidade1);

        UUID idLocalidade2 = UUID.randomUUID();
        UUID idAmenidade2 = UUID.randomUUID();
        AmenidadeLocalidadeId id2 = new AmenidadeLocalidadeId(idLocalidade2, idAmenidade2);

        assertEquals(id1, id1); // Reflexive
        assertEquals(id1.hashCode(), id1.hashCode());

        assertEquals(id1, new AmenidadeLocalidadeId(idLocalidade1, idAmenidade1)); // Symmetric
        assertEquals(new AmenidadeLocalidadeId(idLocalidade1, idAmenidade1), id1);
        assertEquals(id1.hashCode(), new AmenidadeLocalidadeId(idLocalidade1, idAmenidade1).hashCode());

        assertNotEquals(id1, id2); // Different IDs
        assertNotEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void testToString() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idAmenidade = UUID.randomUUID();
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId(idLocalidade, idAmenidade);
        String expectedString = "AmenidadeLocalidadeId(idLocalidade=" + idLocalidade +
                ", idAmenidade=" + idAmenidade + ")";
        assertEquals(expectedString, id.toString());
    }
}