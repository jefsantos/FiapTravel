package com.FiapTravel.servicesImpl;

import com.FiapTravel.model.Predio;
import com.FiapTravel.repositories.PredioRepository;
import com.FiapTravel.services.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PredioServiceImpl implements PredioService {

    private final PredioRepository predioRepository;

    @Autowired
    public PredioServiceImpl(PredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    @Override
    public Predio save(Predio predio) {
        if (predio == null) {
            throw new IllegalArgumentException("O prédio não pode ser nulo.");
        }
        return predioRepository.save(predio);
    }

    @Override
    public List<Predio> buscarTodosPredios() {
        return predioRepository.findAll();
    }

    @Override
    public Optional<Predio> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do prédio não pode ser nulo.");
        }
        return predioRepository.findById(id);
    }

    @Override
    public Predio atualizarPredio(UUID id, Predio predio) {
        if (id == null || predio == null) {
            throw new IllegalArgumentException("O ID e o prédio não podem ser nulos.");
        }
        Optional<Predio> optionalPredio = predioRepository.findById(id);
        if (optionalPredio.isPresent()) {
            predio.setIdPredio(id);
            return predioRepository.save(predio);
        } else {
            throw new IllegalArgumentException("Prédio não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarPredio(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do prédio não pode ser nulo.");
        }
        predioRepository.deleteById(id);
    }
}
