package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuartoReservaTest {

    @Test
    void testNoArgsConstructor() {
        QuartoReserva quartoReserva = new QuartoReserva();
        assertNotNull(quartoReserva);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idQuarto = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        QuartoReservaId id = new QuartoReservaId(idQuarto, idReserva);
        Quarto quarto = new Quarto(idQuarto, "Quarto Test", 2, 5, BigDecimal.valueOf(100.00), null, null);
        Reserva reserva = new Reserva(idReserva, "Descrição da Reserva", "2024-03-15", "2024-03-20", null, null);

        QuartoReserva quartoReserva = new QuartoReserva(id, quarto, reserva);

        assertEquals(id, quartoReserva.getId());
        assertEquals(quarto, quartoReserva.getQuarto());
        assertEquals(reserva, quartoReserva.getReserva());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idQuarto1 = UUID.randomUUID();
        UUID idReserva1 = UUID.randomUUID();
        QuartoReservaId id1 = new QuartoReservaId(idQuarto1, idReserva1);
        QuartoReservaId id2 = new QuartoReservaId(idQuarto1, idReserva1);
        Quarto quarto1 = new Quarto(idQuarto1, "Quarto Test", 2, 5, BigDecimal.valueOf(100.00), null, null);
        Reserva reserva1 = new Reserva(idReserva1, "Descrição da Reserva", "2024-03-15", "2024-03-20", null, null);
        QuartoReserva quartoReserva1 = new QuartoReserva(id1, quarto1, reserva1);
        QuartoReserva quartoReserva2 = new QuartoReserva(id2, quarto1, reserva1);

        assertEquals(quartoReserva1, quartoReserva2); // Deve ser igual porque têm os mesmos IDs
        assertEquals(quartoReserva1.hashCode(), quartoReserva2.hashCode());
    }

    @Test
    void testToString() {
        UUID idQuarto = UUID.randomUUID();
        UUID idReserva = UUID.randomUUID();
        QuartoReservaId id = new QuartoReservaId(idQuarto, idReserva);
        Quarto quarto = new Quarto(idQuarto, "Quarto Test", 2, 5, BigDecimal.valueOf(100.00), null, null);
        Reserva reserva = new Reserva(idReserva, "Descrição da Reserva", "2024-03-15", "2024-03-20", null, null);

        QuartoReserva quartoReserva = new QuartoReserva(id, quarto, reserva);
        String expectedString = "QuartoReserva(id=" + id + ", quarto=" + quarto + ", reserva=" + reserva + ")";
        assertEquals(expectedString, quartoReserva.toString());
    }
}