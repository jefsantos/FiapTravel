package com.FiapTravel.repository;

import com.FiapTravel.model.Reserva;
import com.FiapTravel.model.User;
import com.FiapTravel.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ReservaRepositoryTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService; // Supondo que existe uma classe de serviço para Reserva

    private Reserva reserva;

    @BeforeEach
    public void setup() {
        // Configura uma reserva simulada antes de cada teste
        User user = new User(/* dados do usuário */);
        reserva = new Reserva(UUID.randomUUID(), "2024-03-15", "2024-03-20", "2", BigDecimal.valueOf(500.0), user);
    }

    @Test
    public void testSaveReserva() {
        // Configura o comportamento simulado do repositório para salvar a reserva
        when(reservaRepository.save(reserva)).thenReturn(reserva);

        // Chama o método da classe de serviço que salva a reserva
        Reserva savedReserva = reservaService.save(reserva);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à reserva simulada
        verify(reservaRepository, times(1)).save(reserva);
        assertEquals(reserva, savedReserva);
    }

    @Test
    public void testFindById() {
        // Configura o comportamento simulado do repositório para encontrar a reserva por ID
        when(reservaRepository.findById(reserva.getIdReserva())).thenReturn(Optional.of(reserva));

        // Chama o método da classe de serviço que encontra a reserva por ID
        Optional<Reserva> foundReserva = reservaService.buscarPorId(reserva.getIdReserva());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à reserva simulada
        verify(reservaRepository, times(1)).findById(reserva.getIdReserva());
        assertEquals(reserva, foundReserva.get());
    }

    @Test
    public void testFindAll() {
        // Configura uma lista simulada de reservas
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reserva);

        // Configura o comportamento simulado do repositório para encontrar todas as reservas
        when(reservaRepository.findAll()).thenReturn(reservas);

        // Chama o método da classe de serviço que encontra todas as reservas
        List<Reserva> foundReservas = reservaService.buscarTodasReservas();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada de reservas
        verify(reservaRepository, times(1)).findAll();
        assertEquals(reservas.size(), foundReservas.size());
        assertEquals(reserva, foundReservas.get(0));
    }

    @Test
    public void testDelete() {
        // Chama o método da classe de serviço que deleta a reserva
        reservaService.deletarReserva(UUID.randomUUID());

        // Verifica se o método do repositório foi chamado para deletar a reserva
        verify(reservaRepository, times(1)).delete(reserva);
    }

}
