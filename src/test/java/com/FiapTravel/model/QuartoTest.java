package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuartoTest {

    @Test
    void testNoArgsConstructor() {
        Quarto quarto = new Quarto();
        assertNotNull(quarto);
    }

    @Test
    void testAllArgsConstructor() {
        UUID idQuarto = UUID.randomUUID();
        String nomeQuarto = "Quarto Test";
        int quantidadeLimitePessoas = 2;
        int quantidadeNoPredio = 5;
        BigDecimal valorDiaria = BigDecimal.valueOf(100.00);
        TipoQuarto tipoQuarto = new TipoQuarto(UUID.randomUUID(), "Tipo Test");
        Predio predio = new Predio(UUID.randomUUID(), "Predio Test", null);

        Quarto quarto = new Quarto(idQuarto, nomeQuarto, quantidadeLimitePessoas, quantidadeNoPredio,
                valorDiaria, tipoQuarto, predio);

        assertEquals(idQuarto, quarto.getIdQuarto());
        assertEquals(nomeQuarto, quarto.getNomeQuarto());
        assertEquals(quantidadeLimitePessoas, quarto.getQuantidadeLimitePessoas());
        assertEquals(quantidadeNoPredio, quarto.getQuantidadeNoPredio());
        assertEquals(valorDiaria, quarto.getValorDiaria());
        assertEquals(tipoQuarto, quarto.getTipoQuarto());
        assertEquals(predio, quarto.getPredio());
    }

    @Test
    void testToString() {
        UUID idQuarto = UUID.randomUUID();
        String nomeQuarto = "Quarto Test";
        int quantidadeLimitePessoas = 2;
        int quantidadeNoPredio = 5;
        BigDecimal valorDiaria = BigDecimal.valueOf(100.00);
        TipoQuarto tipoQuarto = new TipoQuarto(UUID.randomUUID(), "Tipo Test");
        Predio predio = new Predio(UUID.randomUUID(), "Predio Test", null);

        Quarto quarto = new Quarto(idQuarto, nomeQuarto, quantidadeLimitePessoas, quantidadeNoPredio,
                valorDiaria, tipoQuarto, predio);
        String expectedString = "Quarto(idQuarto=" + idQuarto + ", nomeQuarto=" + nomeQuarto +
                ", quantidadeLimitePessoas=" + quantidadeLimitePessoas + ", quantidadeNoPredio=" + quantidadeNoPredio +
                ", valorDiaria=" + valorDiaria + ", tipoQuarto=" + tipoQuarto + ", predio=" + predio + ")";
        assertEquals(expectedString, quarto.toString());
    }
}