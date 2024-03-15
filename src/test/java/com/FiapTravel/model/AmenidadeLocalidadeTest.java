package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AmenidadeLocalidadeTest {

    @Test
    void testNoArgsConstructor() {
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade();
        assertNotNull(amenidadeLocalidade);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idAmenidade = UUID.randomUUID();
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId(idLocalidade, idAmenidade);
        Localidade localidade = new Localidade();
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade(id, localidade, null, 2);

        assertEquals(id, amenidadeLocalidade.getId());
        assertEquals(localidade, amenidadeLocalidade.getLocalidade());
        assertEquals(2, amenidadeLocalidade.getQuantidade());
    }

    @Test
    void testToString() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idAmenidade = UUID.randomUUID();
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId(idLocalidade, idAmenidade);
        Localidade localidade = new Localidade(idLocalidade, "Localidade", "Rua", "12345", "Cidade", "Bairro", "UF", null);
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade(id, localidade, null, 2);
        String expectedString = "AmenidadeLocalidade(id=" + id + ", localidade=" + localidade +
                ", amenidadeLocalidade=null, quantidade=2)";
        assertEquals(expectedString, amenidadeLocalidade.toString());
    }
}
