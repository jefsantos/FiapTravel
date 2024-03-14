package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Quarto;
import com.FiapTravel.repository.QuartoRepository;
import com.FiapTravel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuartoServiceImpl implements QuartoService {

    private final QuartoRepository quartoRepository;

    @Autowired
    public QuartoServiceImpl(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    @Override
    public Quarto save(Quarto quarto) {
        if (quarto == null) {
            throw new IllegalArgumentException("O quarto não pode ser nulo.");
        }
        return quartoRepository.save(quarto);
    }

    @Override
    public List<Quarto> buscarTodosQuartos() {
        return quartoRepository.findAll();
    }

    @Override
    public Optional<Quarto> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do quarto não pode ser nulo.");
        }
        return quartoRepository.findById(id);
    }

    @Override
    public Quarto atualizarQuarto(UUID id, Quarto quarto) {
        if (id == null || quarto == null) {
            throw new IllegalArgumentException("O ID e o quarto não podem ser nulos.");
        }
        Optional<Quarto> optionalQuarto = quartoRepository.findById(id);
        if (optionalQuarto.isPresent()) {
            quarto.setIdQuarto(id);
            return quartoRepository.save(quarto);
        } else {
            throw new IllegalArgumentException("Quarto não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarQuarto(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do quarto não pode ser nulo.");
        }
        quartoRepository.deleteById(id);
    }

}