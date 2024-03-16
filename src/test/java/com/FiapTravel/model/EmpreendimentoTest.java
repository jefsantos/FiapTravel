package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import com.FiapTravel.model.enums.UserRole;

import static org.junit.jupiter.api.Assertions.*;

class EmpreendimentoTest {

    @Test
    void testNoArgsConstructor() {
        Empreendimento empreendimento = new Empreendimento();
        assertNotNull(empreendimento);
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        User user = new User("username", "password", UserRole.ADMIN);
        String nomeEmpreendimento = "Meu Empreendimento";

        Empreendimento empreendimento = new Empreendimento(id, nomeEmpreendimento, user);

        assertEquals(id, empreendimento.getIdEmpreendimento());
        assertEquals(nomeEmpreendimento, empreendimento.getNomeEmpreendimento());
        assertEquals(user, empreendimento.getUser());
    }



    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        User user = new User("username", "password", UserRole.ADMIN);
        String nomeEmpreendimento = "Meu Empreendimento";

        Empreendimento empreendimento = new Empreendimento(id, nomeEmpreendimento, user);
        String expectedString = "Empreendimento(idEmpreendimento=" + id + ", nomeEmpreendimento=Meu Empreendimento, user=" + user + ")";
        assertEquals(expectedString, empreendimento.toString());
    }
}