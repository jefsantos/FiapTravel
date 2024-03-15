package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;
import com.FiapTravel.repository.AmenidadeLocalidadeRepository;
import com.FiapTravel.service.AmenidadeLocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenidadeLocalidadeServiceImpl implements AmenidadeLocalidadeService {

    private final AmenidadeLocalidadeRepository amenidadeLocalidadeRepository;

    @Autowired
    public AmenidadeLocalidadeServiceImpl(AmenidadeLocalidadeRepository amenidadeLocalidadeRepository) {
        this.amenidadeLocalidadeRepository = amenidadeLocalidadeRepository;
    }

    @Override
    public AmenidadeLocalidade save(AmenidadeLocalidade amenidadeLocalidade) {
        if (amenidadeLocalidade == null) {
            throw new IllegalArgumentException("A amenidade de localidade não pode ser nula.");
        }
        return amenidadeLocalidadeRepository.save(amenidadeLocalidade);
    }

    @Override
    public List<AmenidadeLocalidade> buscarTodasAmenidadesLocalidades() {
        return amenidadeLocalidadeRepository.findAll();
    }

    @Override
    public Optional<AmenidadeLocalidade> buscarPorId(AmenidadeLocalidadeId amenidadeLocalidadeId) {
        if (amenidadeLocalidadeId == null) {
            throw new IllegalArgumentException("O ID da amenidade de localidade não pode ser nulo.");
        }
        return amenidadeLocalidadeRepository.findById(amenidadeLocalidadeId);
    }

    @Override
    public AmenidadeLocalidade atualizarAmenidadeLocalidade(AmenidadeLocalidadeId amenidadeLocalidadeId,
                                                            AmenidadeLocalidade amenidadeLocalidade) {
        if (amenidadeLocalidadeId == null || amenidadeLocalidade == null) {
            throw new IllegalArgumentException("O ID e a amenidade de localidade não podem ser nulos.");
        }
        Optional<AmenidadeLocalidade> optionalAmenidadeLocalidade =
                amenidadeLocalidadeRepository.findById(amenidadeLocalidadeId);
        if (optionalAmenidadeLocalidade.isPresent()) {
            amenidadeLocalidade.setId(amenidadeLocalidadeId);
            return amenidadeLocalidadeRepository.save(amenidadeLocalidade);
        } else {
            throw new IllegalArgumentException("Amenidade de localidade não encontrada para o ID fornecido: "
                    + amenidadeLocalidadeId);
        }
    }

    @Override
    public void deletarAmenidadeLocalidade(AmenidadeLocalidadeId amenidadeLocalidadeId) {
        if (amenidadeLocalidadeId == null) {
            throw new IllegalArgumentException("O ID da amenidade de localidade não pode ser nulo.");
        }
        amenidadeLocalidadeRepository.deleteById(amenidadeLocalidadeId);
    }
}