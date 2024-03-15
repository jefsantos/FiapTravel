package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Amenidade;
import com.FiapTravel.repository.AmenidadeRepository;
import com.FiapTravel.service.AmenidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AmenidadeServiceImpl implements AmenidadeService {

    private final AmenidadeRepository amenidadeRepository;

    @Autowired
    public AmenidadeServiceImpl(AmenidadeRepository amenidadeRepository) {
        this.amenidadeRepository = amenidadeRepository;
    }

    @Override
    public Amenidade save(Amenidade amenidade) {
        if (amenidade == null) {
            throw new IllegalArgumentException("A amenidade não pode ser nula.");
        }
        return amenidadeRepository.save(amenidade);
    }

    @Override
    public List<Amenidade> buscarTodasAmenidades() {
        return amenidadeRepository.findAll();
    }

    @Override
    public Optional<Amenidade> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID da amenidade não pode ser nulo.");
        }
        return amenidadeRepository.findById(id);
    }

    @Override
    public Amenidade atualizarAmenidade(UUID id, Amenidade amenidade) {
        if (id == null || amenidade == null) {
            throw new IllegalArgumentException("O ID e a amenidade não podem ser nulos.");
        }
        Optional<Amenidade> optionalAmenidade = amenidadeRepository.findById(id);
        if (optionalAmenidade.isPresent()) {
            amenidade.setIdAmenidade(id);
            return amenidadeRepository.save(amenidade);
        } else {
            throw new IllegalArgumentException("Amenidade não encontrada para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarAmenidade(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID da amenidade não pode ser nulo.");
        }
        amenidadeRepository.deleteById(id);
    }
}