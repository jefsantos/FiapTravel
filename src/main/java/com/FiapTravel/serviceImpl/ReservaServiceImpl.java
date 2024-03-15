package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Reserva;
import com.FiapTravel.repository.ReservaRepository;
import com.FiapTravel.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva save(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("A reserva não pode ser nula.");
        }
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> buscarTodasReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID da reserva não pode ser nulo.");
        }
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva atualizarReserva(UUID id, Reserva reserva) {
        if (id == null || reserva == null) {
            throw new IllegalArgumentException("O ID e a reserva não podem ser nulos.");
        }
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            reserva.setIdReserva(id);
            return reservaRepository.save(reserva);
        } else {
            throw new IllegalArgumentException("Reserva não encontrada para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarReserva(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID da reserva não pode ser nulo.");
        }
        reservaRepository.deleteById(id);
    }
}