package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OpcionalReservaTest {

    @Test
    void testNoArgsConstructor() {
        OpcionalReserva opcionalReserva = new OpcionalReserva();
        assertNotNull(opcionalReserva);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();
        OpcionalReservaId id = new OpcionalReservaId(idLocalidade, idReserva, idOpcional);
        Localidade localidade = new Localidade(idLocalidade, "Local Test", "Rua Test", "123456", "City", "District", "State", new Empreendimento());
        Reserva reserva = new Reserva(idReserva, "Descrição da Reserva", "2024-03-15", "2024-03-20", new BigDecimal("10.0"), new User());
        Opcional opcional = new Opcional(idOpcional, "Descrição do Opcional");
        int quantidade = 2;

        OpcionalReserva opcionalReserva = new OpcionalReserva(id, localidade, reserva, opcional, quantidade);

        assertEquals(id, opcionalReserva.getId());
        assertEquals(localidade, opcionalReserva.getLocalidade());
        assertEquals(reserva, opcionalReserva.getReserva());
        assertEquals(opcional, opcionalReserva.getOpcional());
        assertEquals(quantidade, opcionalReserva.getQuantidade());
    }
    @Test
    void testEqualsAndHashCode() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();
        OpcionalReservaId id1 = new OpcionalReservaId(idLocalidade, idReserva, idOpcional);
        OpcionalReservaId id2 = new OpcionalReservaId(idLocalidade, idReserva, idOpcional);
        Localidade localidade = new Localidade(idLocalidade, "Local Test", "Rua Test", "123456", "City", "District", "State", new Empreendimento());
        Reserva reserva = new Reserva(idReserva, "Descrição da Reserva", "2024-03-15", "2024-03-20", new BigDecimal("10.0"), new User());
        Opcional opcional = new Opcional(idOpcional, "Descrição do Opcional");
        int quantidade = 2;

        OpcionalReserva opcionalReserva1 = new OpcionalReserva(id1, localidade, reserva, opcional, quantidade);
        OpcionalReserva opcionalReserva2 = new OpcionalReserva(id2, localidade, reserva, opcional, quantidade);

        assertEquals(opcionalReserva1, opcionalReserva2); // Deve ser igual porque têm os mesmos IDs
        assertEquals(opcionalReserva1.hashCode(), opcionalReserva2.hashCode());
    }

    @Test
    void testToString() {
        UUID idLocalidade = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        UUID idOpcional = UUID.randomUUID();
        OpcionalReservaId id = new OpcionalReservaId(idLocalidade, idReserva, idOpcional);
        Localidade localidade = new Localidade(idLocalidade, "Local Test", "Rua Test", "123456", "City", "District", "State", new Empreendimento());
        Reserva reserva = new Reserva(idReserva, "Descrição da Reserva", "2024-03-15", "2024-03-20", new BigDecimal("10.0"), new User());
        Opcional opcional = new Opcional(idOpcional, "Descrição do Opcional");
        int quantidade = 2;

        OpcionalReserva opcionalReserva = new OpcionalReserva(id, localidade, reserva, opcional, quantidade);
        String expectedString = "OpcionalReserva(id=" + id + ", localidade=" + localidade +
                ", reserva=" + reserva + ", opcional=" + opcional + ", quantidade=" + quantidade + ")";
        assertEquals(expectedString, opcionalReserva.toString());
    }
}