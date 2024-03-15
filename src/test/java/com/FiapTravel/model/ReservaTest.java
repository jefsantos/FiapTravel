package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import com.FiapTravel.model.enums.UserRole;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReservaTest {

    @Test
    void testNoArgsConstructor() {
        Reserva reserva = new Reserva();
        assertNotNull(reserva);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idReserva = UUID.randomUUID();
        String dataEntradaReserva = "2024-03-15";
        String dataSaidaReserva = "2024-03-20";
        String quantidadePessoasRererva = "2";
        BigDecimal valorTotalReserva = new BigDecimal("500.00");
        User user = new User("username", "password", UserRole.USER);
        Reserva reserva = new Reserva(idReserva, dataEntradaReserva, dataSaidaReserva, quantidadePessoasRererva, valorTotalReserva, user);

        assertEquals(idReserva, reserva.getIdReserva());
        assertEquals(dataEntradaReserva, reserva.getDataEntradaReserva());
        assertEquals(dataSaidaReserva, reserva.getDataSaidaReserva());
        assertEquals(quantidadePessoasRererva, reserva.getQuantidadePessoasRererva());
        assertEquals(valorTotalReserva, reserva.getValorTotalReserva());
        assertEquals(user, reserva.getUser());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID idReserva1 = UUID.randomUUID();
        String dataEntradaReserva1 = "2024-03-15";
        String dataSaidaReserva1 = "2024-03-20";
        String quantidadePessoasRererva1 = "2";
        BigDecimal valorTotalReserva1 = new BigDecimal("500.00");
        User user1 = new User("username", "password", UserRole.USER);
        Reserva reserva1 = new Reserva(idReserva1, dataEntradaReserva1, dataSaidaReserva1, quantidadePessoasRererva1, valorTotalReserva1, user1);

        UUID idReserva2 = UUID.randomUUID();
        String dataEntradaReserva2 = "2024-03-15";
        String dataSaidaReserva2 = "2024-03-20";
        String quantidadePessoasRererva2 = "2";
        BigDecimal valorTotalReserva2 = new BigDecimal("500.00");
        User user2 = new User("username", "password", UserRole.USER);
        Reserva reserva2 = new Reserva(idReserva2, dataEntradaReserva2, dataSaidaReserva2, quantidadePessoasRererva2, valorTotalReserva2, user2);

        assertEquals(reserva1, reserva2); // Devem ser iguais porque têm os mesmos atributos
        assertEquals(reserva1.hashCode(), reserva2.hashCode());

        // Modificar um atributo deve torná-los diferentes
        reserva2.setDataSaidaReserva("2024-03-21");
        assertNotEquals(reserva1, reserva2);
        assertNotEquals(reserva1.hashCode(), reserva2.hashCode());
    }

    @Test
    void testToString() {
        UUID idReserva = UUID.randomUUID();
        String dataEntradaReserva = "2024-03-15";
        String dataSaidaReserva = "2024-03-20";
        String quantidadePessoasRererva = "2";
        BigDecimal valorTotalReserva = new BigDecimal("500.00");
        User user = new User("username", "password", UserRole.USER);
        Reserva reserva = new Reserva(idReserva, dataEntradaReserva, dataSaidaReserva, quantidadePessoasRererva, valorTotalReserva, user);
        String expectedString = "Reserva(idReserva=" + idReserva + ", dataEntradaReserva=" + dataEntradaReserva +
                ", dataSaidaReserva=" + dataSaidaReserva + ", quantidadePessoasRererva=" + quantidadePessoasRererva +
                ", valorTotalReserva=" + valorTotalReserva + ", user=" + user + ")";
        assertEquals(expectedString, reserva.toString());
    }
}