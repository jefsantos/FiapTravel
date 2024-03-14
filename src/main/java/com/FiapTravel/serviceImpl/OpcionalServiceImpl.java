package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Opcional;
import com.FiapTravel.repository.OpcionalRepository;
import com.FiapTravel.service.OpcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OpcionalServiceImpl implements OpcionalService {

    private final OpcionalRepository opcionalRepository;

    @Autowired
    public OpcionalServiceImpl(OpcionalRepository opcionalRepository) {
        this.opcionalRepository = opcionalRepository;
    }

    @Override
    public Opcional save(Opcional opcional) {
        if (opcional == null) {
            throw new IllegalArgumentException("O opcional não pode ser nulo.");
        }
        return opcionalRepository.save(opcional);
    }

    @Override
    public List<Opcional> buscarTodosOpcionais() {
        return opcionalRepository.findAll();
    }

    @Override
    public Optional<Opcional> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do opcional não pode ser nulo.");
        }
        return opcionalRepository.findById(id);
    }

    @Override
    public Opcional atualizarOpcional(UUID id, Opcional opcional) {
        if (id == null || opcional == null) {
            throw new IllegalArgumentException("O ID e o opcional não podem ser nulos.");
        }
        Optional<Opcional> optionalOpcional = opcionalRepository.findById(id);
        if (optionalOpcional.isPresent()) {
            opcional.setIdOpcional(id);
            return opcionalRepository.save(opcional);
        } else {
            throw new IllegalArgumentException("Opcional não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarOpcional(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do opcional não pode ser nulo.");
        }
        opcionalRepository.deleteById(id);
    }

}