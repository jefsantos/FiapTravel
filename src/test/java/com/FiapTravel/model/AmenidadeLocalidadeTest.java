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
    void testEqualsAndHashCode() {
        UUID idLocalidade1 = UUID.randomUUID();
        UUID idAmenidade1 = UUID.randomUUID();
        AmenidadeLocalidadeId id1 = new AmenidadeLocalidadeId(idLocalidade1, idAmenidade1);
        Localidade localidade1 = new Localidade(idLocalidade1, "Localidade 1", "Rua 1", "12345", "Cidade 1", "Bairro 1", "UF 1", null);
        AmenidadeLocalidade amenidadeLocalidade1 = new AmenidadeLocalidade(id1, localidade1, null, 2);

        UUID idLocalidade2 = UUID.randomUUID();
        UUID idAmenidade2 = UUID.randomUUID();
        AmenidadeLocalidadeId id2 = new AmenidadeLocalidadeId(idLocalidade2, idAmenidade2);
        Localidade localidade2 = new Localidade(idLocalidade2, "Localidade 2", "Rua 2", "54321", "Cidade 2", "Bairro 2", "UF 2", null);
        AmenidadeLocalidade amenidadeLocalidade2 = new AmenidadeLocalidade(id2, localidade2, null, 2);

        assertEquals(amenidadeLocalidade1, amenidadeLocalidade2); // Devem ser iguais porque têm os mesmos IDs
        assertEquals(amenidadeLocalidade1.hashCode(), amenidadeLocalidade2.hashCode());

        // Modificar um atributo deve torná-los diferentes
        amenidadeLocalidade2.setQuantidade(3);
        assertNotEquals(amenidadeLocalidade1, amenidadeLocalidade2);
        assertNotEquals(amenidadeLocalidade1.hashCode(), amenidadeLocalidade2.hashCode());
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