package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.QuartoReserva;
import com.FiapTravel.model.QuartoReservaId;
import com.FiapTravel.repository.QuartoReservaRepository;
import com.FiapTravel.service.QuartoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoReservaServiceImpl implements QuartoReservaService {

    private final QuartoReservaRepository quartoReservaRepository;

    @Autowired
    public QuartoReservaServiceImpl(QuartoReservaRepository quartoReservaRepository) {
        this.quartoReservaRepository = quartoReservaRepository;
    }

    @Override
    public QuartoReserva save(QuartoReserva quartoReserva) {
        if (quartoReserva == null) {
            throw new IllegalArgumentException("A reserva de quarto não pode ser nula.");
        }
        return quartoReservaRepository.save(quartoReserva);
    }

    @Override
    public List<QuartoReserva> buscarTodasQuartoReservas() {
        return quartoReservaRepository.findAll();
    }

    @Override
    public Optional<QuartoReserva> buscarPorId(QuartoReservaId id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID da reserva de quarto não pode ser nulo.");
        }
        return quartoReservaRepository.findById(id);
    }

    @Override
    public QuartoReserva atualizarQuartoReserva(QuartoReservaId id, QuartoReserva quartoReserva) {
        if (id == null || quartoReserva == null) {
            throw new IllegalArgumentException("O ID e a reserva de quarto não podem ser nulos.");
        }
        Optional<QuartoReserva> optionalQuartoReserva = quartoReservaRepository.findById(id);
        if (optionalQuartoReserva.isPresent()) {
            quartoReserva.setId(id);
            return quartoReservaRepository.save(quartoReserva);
        } else {
            throw new IllegalArgumentException("Reserva de quarto não encontrada para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarQuartoReserva(QuartoReservaId id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID da reserva de quarto não pode ser nulo.");
        }
        quartoReservaRepository.deleteById(id);
    }
}