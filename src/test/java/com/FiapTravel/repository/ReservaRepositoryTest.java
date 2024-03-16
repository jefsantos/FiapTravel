package com.FiapTravel.repository;

import com.FiapTravel.model.Reserva;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservaRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Reserva> expectedReservas = Arrays.asList(
                new Reserva(UUID.randomUUID(), "Data de entrada 1", "Data de saída 1", "Quantidade de pessoas 1", null, null),
                new Reserva(UUID.randomUUID(), "Data de entrada 2", "Data de saída 2", "Quantidade de pessoas 2", null, null)
        );
        ReservaRepository reservaRepositoryMock = Mockito.mock(ReservaRepository.class);
        when(reservaRepositoryMock.findAll()).thenReturn(expectedReservas);

        // Act
        List<Reserva> actualReservas = reservaRepositoryMock.findAll();

        // Assert
        assertEquals(expectedReservas, actualReservas);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Reserva expectedReserva = new Reserva(id, "Data de entrada", "Data de saída", "Quantidade de pessoas", null, null);
        ReservaRepository reservaRepositoryMock = Mockito.mock(ReservaRepository.class);
        when(reservaRepositoryMock.findById(id)).thenReturn(Optional.of(expectedReserva));

        // Act
        Optional<Reserva> actualReservaOptional = reservaRepositoryMock.findById(id);

        // Assert
        assertTrue(actualReservaOptional.isPresent());
        assertEquals(expectedReserva, actualReservaOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Reserva reservaToSave = new Reserva(id, "Data de entrada", "Data de saída", "Quantidade de pessoas", null, null);
        ReservaRepository reservaRepositoryMock = Mockito.mock(ReservaRepository.class);
        when(reservaRepositoryMock.save(reservaToSave)).thenReturn(reservaToSave);

        // Act
        Reserva savedReserva = reservaRepositoryMock.save(reservaToSave);

        // Assert
        assertEquals(reservaToSave, savedReserva);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        ReservaRepository reservaRepositoryMock = Mockito.mock(ReservaRepository.class);

        // Act
        reservaRepositoryMock.deleteById(id);

        // Assert
        verify(reservaRepositoryMock, times(1)).deleteById(id);
    }
}
