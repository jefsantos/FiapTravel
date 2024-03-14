package com.FiapTravel.servicesImpl;

import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;
import com.FiapTravel.repositories.OpcionalLocalidadeRepository;
import com.FiapTravel.services.OpcionalLocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionalLocalidadeServiceImpl implements OpcionalLocalidadeService {
    private final OpcionalLocalidadeRepository opcionalLocalidadeRepository;

    @Autowired
    public OpcionalLocalidadeServiceImpl(OpcionalLocalidadeRepository opcionalLocalidadeRepository) {
        this.opcionalLocalidadeRepository = opcionalLocalidadeRepository;
    }

    @Override
    public OpcionalLocalidade save(OpcionalLocalidade opcionalLocalidade) {
        if (opcionalLocalidade == null) {
            throw new IllegalArgumentException("O opcional de localidade não pode ser nulo.");
        }
        return opcionalLocalidadeRepository.save(opcionalLocalidade);
    }

    @Override
    public List<OpcionalLocalidade> buscarTodosOpcionaisLocalidades() {
        return opcionalLocalidadeRepository.findAll();
    }

    @Override
    public Optional<OpcionalLocalidade> buscarPorId(OpcionalLocalidadeId opcionalLocalidadeId) {
        if (opcionalLocalidadeId == null) {
            throw new IllegalArgumentException("O ID do opcional de localidade não pode ser nulo.");
        }
        return opcionalLocalidadeRepository.findById(opcionalLocalidadeId);
    }

    @Override
    public OpcionalLocalidade atualizarOpcionalLocalidade(OpcionalLocalidadeId opcionalLocalidadeId,
                                                  OpcionalLocalidade opcionalLocalidade) {
        if (opcionalLocalidadeId == null || opcionalLocalidade == null) {
            throw new IllegalArgumentException("O ID e o opcional de localidade não podem ser nulos.");
        }
        Optional<OpcionalLocalidade> optionalOpcionalLocalidade =
                opcionalLocalidadeRepository.findById(opcionalLocalidadeId);
        if (optionalOpcionalLocalidade.isPresent()) {
            opcionalLocalidade.setId(opcionalLocalidadeId);
            return opcionalLocalidadeRepository.save(opcionalLocalidade);
        } else {
            throw new IllegalArgumentException("Opcional de localidade não encontrado para o ID fornecido: "
                    + opcionalLocalidadeId);
        }
    }

    @Override
    public void deletarOpcionalLocalidade(OpcionalLocalidadeId opcionalLocalidadeId) {
        if (opcionalLocalidadeId == null) {
            throw new IllegalArgumentException("O ID do opcional de localidade não pode ser nulo.");
        }
        opcionalLocalidadeRepository.deleteById(opcionalLocalidadeId);
    }

}