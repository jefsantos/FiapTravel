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
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        User user1 = new User("username1", "password1", UserRole.USER);
        User user2 = new User("username2", "password2", UserRole.ADMIN);

        Empreendimento empreendimento1 = new Empreendimento(id, "Meu Empreendimento", user1);
        Empreendimento empreendimento2 = new Empreendimento(id, "Meu Empreendimento", user2);
        Empreendimento empreendimento3 = new Empreendimento(UUID.randomUUID(), "Meu Empreendimento", user1);

        assertEquals(empreendimento1, empreendimento2); // Deve ser igual porque têm o mesmo ID
        assertNotEquals(empreendimento1, empreendimento3); // Deve ser diferente porque têm IDs diferentes

        assertEquals(empreendimento1.hashCode(), empreendimento2.hashCode());
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