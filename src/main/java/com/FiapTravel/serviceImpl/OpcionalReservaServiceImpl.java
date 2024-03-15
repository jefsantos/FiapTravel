package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.OpcionalReserva;
import com.FiapTravel.model.OpcionalReservaId;
import com.FiapTravel.repository.OpcionalReservaRepository;
import com.FiapTravel.service.OpcionalReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionalReservaServiceImpl implements OpcionalReservaService {
    private final OpcionalReservaRepository opcionalReservaRepository;

    @Autowired
    public OpcionalReservaServiceImpl(OpcionalReservaRepository opcionalReservaRepository) {
        this.opcionalReservaRepository = opcionalReservaRepository;
    }

    @Override
    public OpcionalReserva save(OpcionalReserva opcionalReserva) {
        if (opcionalReserva == null) {
            throw new IllegalArgumentException("O opcional de reserva não pode ser nulo.");
        }
        return opcionalReservaRepository.save(opcionalReserva);
    }

    @Override
    public List<OpcionalReserva> buscarTodosOpcionaisReserva() {
        return opcionalReservaRepository.findAll();
    }

    @Override
    public Optional<OpcionalReserva> buscarPorId(OpcionalReservaId opcionalReservaId) {
        if (opcionalReservaId == null) {
            throw new IllegalArgumentException("O ID do opcional de reserva não pode ser nulo.");
        }
        return opcionalReservaRepository.findById(opcionalReservaId);
    }

    @Override
    public OpcionalReserva atualizarOpcionalReserva(OpcionalReservaId opcionalReservaId,
                                                    OpcionalReserva opcionalReserva) {
        if (opcionalReservaId == null || opcionalReserva == null) {
            throw new IllegalArgumentException("O ID e o opcional de reserva não podem ser nulos.");
        }
        Optional<OpcionalReserva> optionalOpcionalReserva =
                opcionalReservaRepository.findById(opcionalReservaId);
        if (optionalOpcionalReserva.isPresent()) {
            opcionalReserva.setId(opcionalReservaId);
            return opcionalReservaRepository.save(opcionalReserva);
        } else {
            throw new IllegalArgumentException("Opcional de reserva não encontrado para o ID fornecido: "
                    + opcionalReservaId);
        }
    }

    @Override
    public void deletarOpcionalReserva(OpcionalReservaId opcionalReservaId) {
        if (opcionalReservaId == null) {
            throw new IllegalArgumentException("O ID do opcional de reserva não pode ser nulo.");
        }
        opcionalReservaRepository.deleteById(opcionalReservaId);
    }

}