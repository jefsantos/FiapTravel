package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LocalidadeTest {

    @Test
    void testNoArgsConstructor() {
        Localidade localidade = new Localidade();
        assertNotNull(localidade);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        String nomeLocalidade = "Local Test";
        String logradouroLocalidade = "Rua Test";
        String codigoPostalLocalidade = "123456";
        String cidadeLocalidade = "City";
        String bairroLocalidade = "District";
        String ufLocalidade = "State";
        Empreendimento empreendimento = new Empreendimento();

        Localidade localidade = new Localidade(idLocalidade, nomeLocalidade, logradouroLocalidade,
                codigoPostalLocalidade, cidadeLocalidade, bairroLocalidade, ufLocalidade, empreendimento);

        assertEquals(idLocalidade, localidade.getIdLocalidade());
        assertEquals(nomeLocalidade, localidade.getNomeLocalidade());
        assertEquals(logradouroLocalidade, localidade.getLogradouroLocalidade());
        assertEquals(codigoPostalLocalidade, localidade.getCodigoPostalLocalidade());
        assertEquals(cidadeLocalidade, localidade.getCidadeLocalidade());
        assertEquals(bairroLocalidade, localidade.getBairroLocalidade());
        assertEquals(ufLocalidade, localidade.getUfLocalidade());
        assertEquals(empreendimento, localidade.getEmpreendimento());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idLocalidade = UUID.randomUUID();
        String nomeLocalidade = "Local Test";
        String logradouroLocalidade = "Rua Test";
        String codigoPostalLocalidade = "123456";
        String cidadeLocalidade = "City";
        String bairroLocalidade = "District";
        String ufLocalidade = "State";
        Empreendimento empreendimento1 = new Empreendimento();
        Empreendimento empreendimento2 = new Empreendimento();

        Localidade localidade1 = new Localidade(idLocalidade, nomeLocalidade, logradouroLocalidade,
                codigoPostalLocalidade, cidadeLocalidade, bairroLocalidade, ufLocalidade, empreendimento1);
        Localidade localidade2 = new Localidade(idLocalidade, nomeLocalidade, logradouroLocalidade,
                codigoPostalLocalidade, cidadeLocalidade, bairroLocalidade, ufLocalidade, empreendimento2);

        assertEquals(localidade1, localidade2); // Deve ser igual porque têm o mesmo ID
        assertEquals(localidade1.hashCode(), localidade2.hashCode());
    }

    @Test
    void testToString() {
        UUID idLocalidade = UUID.randomUUID();
        String nomeLocalidade = "Local Test";
        String logradouroLocalidade = "Rua Test";
        String codigoPostalLocalidade = "123456";
        String cidadeLocalidade = "City";
        String bairroLocalidade = "District";
        String ufLocalidade = "State";
        Empreendimento empreendimento = new Empreendimento();

        Localidade localidade = new Localidade(idLocalidade, nomeLocalidade, logradouroLocalidade,
                codigoPostalLocalidade, cidadeLocalidade, bairroLocalidade, ufLocalidade, empreendimento);
        String expectedString = "Localidade(idLocalidade=" + idLocalidade + ", nomeLocalidade=" + nomeLocalidade +
                ", logradouroLocalidade=" + logradouroLocalidade + ", codigoPostalLocalidade=" + codigoPostalLocalidade +
                ", cidadeLocalidade=" + cidadeLocalidade + ", bairroLocalidade=" + bairroLocalidade +
                ", ufLocalidade=" + ufLocalidade + ", empreendimento=" + empreendimento + ")";
        assertEquals(expectedString, localidade.toString());
    }
}