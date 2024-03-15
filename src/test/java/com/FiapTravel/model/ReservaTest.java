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