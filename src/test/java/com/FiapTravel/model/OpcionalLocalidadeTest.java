package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OpcionalLocalidadeTest {

    @Test
    void testNoArgsConstructor() {
        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade();
        assertNotNull(opcionalLocalidade);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();
        OpcionalLocalidadeId id = new OpcionalLocalidadeId(idLocalidade, idOpcional);
        Localidade localidade = new Localidade(idLocalidade, "Local Test", "Rua Test", "123456", "City", "District", "State", new Empreendimento());
        Opcional opcional = new Opcional(idOpcional, "Descrição do Opcional");
        BigDecimal valorOpcional = BigDecimal.valueOf(100.00);

        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade(id, localidade, opcional, valorOpcional);

        assertEquals(id, opcionalLocalidade.getId());
        assertEquals(localidade, opcionalLocalidade.getLocalidade());
        assertEquals(opcional, opcionalLocalidade.getOpcional());
        assertEquals(valorOpcional, opcionalLocalidade.getValorOpcional());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();
        OpcionalLocalidadeId id1 = new OpcionalLocalidadeId(idLocalidade, idOpcional);
        OpcionalLocalidadeId id2 = new OpcionalLocalidadeId(idLocalidade, idOpcional);
        Localidade localidade = new Localidade(idLocalidade, "Local Test", "Rua Test", "123456", "City", "District", "State", new Empreendimento());
        Opcional opcional = new Opcional(idOpcional, "Descrição do Opcional");
        BigDecimal valorOpcional = BigDecimal.valueOf(100.00);

        OpcionalLocalidade opcionalLocalidade1 = new OpcionalLocalidade(id1, localidade, opcional, valorOpcional);
        OpcionalLocalidade opcionalLocalidade2 = new OpcionalLocalidade(id2, localidade, opcional, valorOpcional);

        assertEquals(opcionalLocalidade1, opcionalLocalidade2); // Deve ser igual porque têm o mesmo ID
        assertEquals(opcionalLocalidade1.hashCode(), opcionalLocalidade2.hashCode());
    }

    @Test
    void testToString() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();
        OpcionalLocalidadeId id = new OpcionalLocalidadeId(idLocalidade, idOpcional);
        Localidade localidade = new Localidade(idLocalidade, "Local Test", "Rua Test", "123456", "City", "District", "State", new Empreendimento());
        Opcional opcional = new Opcional(idOpcional, "Descrição do Opcional");
        BigDecimal valorOpcional = BigDecimal.valueOf(100.00);

        OpcionalLocalidade opcionalLocalidade = new OpcionalLocalidade(id, localidade, opcional, valorOpcional);
        String expectedString = "OpcionalLocalidade(id=" + id + ", localidade=" + localidade +
                ", opcional=" + opcional + ", valorOpcional=" + valorOpcional + ")";
        assertEquals(expectedString, opcionalLocalidade.toString());
    }
}