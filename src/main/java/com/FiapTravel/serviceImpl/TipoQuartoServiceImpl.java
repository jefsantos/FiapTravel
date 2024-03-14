package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.TipoQuarto;
import com.FiapTravel.repository.TipoQuartoRepository;
import com.FiapTravel.service.TipoQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoQuartoServiceImpl implements TipoQuartoService {

    private final TipoQuartoRepository tipoQuartoRepository;

    @Autowired
    public TipoQuartoServiceImpl(TipoQuartoRepository tipoQuartoRepository) {
        this.tipoQuartoRepository = tipoQuartoRepository;
    }

    @Override
    public TipoQuarto save(TipoQuarto tipoQuarto) {
        if (tipoQuarto == null) {
            throw new IllegalArgumentException("O tipo quarto não pode ser nulo.");
        }
        return tipoQuartoRepository.save(tipoQuarto);
    }

    @Override
    public List<TipoQuarto> buscarTodosTiposQuartos() {
        return tipoQuartoRepository.findAll();
    }

    @Override
    public Optional<TipoQuarto> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do tipo quarto não pode ser nulo.");
        }
        return tipoQuartoRepository.findById(id);
    }

    @Override
    public TipoQuarto atualizarTipoQuarto(UUID id, TipoQuarto tipoQuarto) {
        if (id == null || tipoQuarto == null) {
            throw new IllegalArgumentException("O ID e o tipo quarto não podem ser nulos.");
        }
        Optional<TipoQuarto> optionalTipoQuarto = tipoQuartoRepository.findById(id);
        if (optionalTipoQuarto.isPresent()) {
            tipoQuarto.setIdTipoQuarto(id);
            return tipoQuartoRepository.save(tipoQuarto);
        } else {
            throw new IllegalArgumentException("Tipo quarto não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarTipoQuarto(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do tipo quarto não pode ser nulo.");
        }
        tipoQuartoRepository.deleteById(id);
    }

}