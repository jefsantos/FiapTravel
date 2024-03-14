package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.repository.EmpreendimentoRepository;
import com.FiapTravel.service.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpreendimentoServiceImpl implements EmpreendimentoService {

    private final EmpreendimentoRepository empreendimentoRepository;

    @Autowired
    public EmpreendimentoServiceImpl(EmpreendimentoRepository empreendimentoRepository) {
        this.empreendimentoRepository = empreendimentoRepository;
    }

    @Override
    public Empreendimento save(Empreendimento empreendimento) {
        if (empreendimento == null) {
            throw new IllegalArgumentException("O empreendimento não pode ser nulo.");
        }
        return empreendimentoRepository.save(empreendimento);
    }

    @Override
    public List<Empreendimento> buscarTodosEmpreendimentos() {
        return empreendimentoRepository.findAll();
    }

    @Override
    public Optional<Empreendimento> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do empreendimento não pode ser nulo.");
        }
        return empreendimentoRepository.findById(id);
    }

    @Override
    public Empreendimento atualizarEmpreendimento(UUID id, Empreendimento empreendimento) {
        if (id == null || empreendimento == null) {
            throw new IllegalArgumentException("O ID e o empreendimento não podem ser nulos.");
        }
        Optional<Empreendimento> optionalEmpreendimento = empreendimentoRepository.findById(id);
        if (optionalEmpreendimento.isPresent()) {
            empreendimento.setIdEmpreendimento(id);
            return empreendimentoRepository.save(empreendimento);
        } else {
            throw new IllegalArgumentException("Empreendimento não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarEmpreendimento(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do empreendimento não pode ser nulo.");
        }
        empreendimentoRepository.deleteById(id);
    }
}
