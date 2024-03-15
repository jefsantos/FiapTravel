package com.FiapTravel.serviceImpl;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.repository.LocalidadeRepository;
import com.FiapTravel.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocalidadeServiceImpl implements LocalidadeService {

	private final LocalidadeRepository localidadeRepository;

	@Autowired
	public LocalidadeServiceImpl(LocalidadeRepository localidadeRepository) {
		this.localidadeRepository = localidadeRepository;
	}

	@Override
	public Localidade save(Localidade localidade) {
		if (localidade == null) {
			throw new IllegalArgumentException("A localidade não pode ser nula.");
		}
		return localidadeRepository.save(localidade);
	}

	@Override
	public List<Localidade> buscarTodasLocalidades() {
		return localidadeRepository.findAll();
	}

	@Override
	public Optional<Localidade> buscarPorId(UUID id) {
		if (id == null) {
			throw new IllegalArgumentException("O ID da localidade não pode ser nula.");
		}
		return localidadeRepository.findById(id);
	}

	@Override
	public Localidade atualizarLocalidade(UUID id, Localidade localidade) {
		if (id == null || localidade == null) {
			throw new IllegalArgumentException("O ID e a localidade não podem ser nulos.");
		}
		Optional<Localidade> optionalLocalidade = localidadeRepository.findById(id);
		if (optionalLocalidade.isPresent()) {
			localidade.setIdLocalidade(id);
			return localidadeRepository.save(localidade);
		} else {
			throw new IllegalArgumentException("Localidade não encontrada para o ID fornecido: " + id);
		}
	}

	@Override
	public void deletarLocalidade(UUID id) {
		if (id == null) {
			throw new IllegalArgumentException("O ID da localidade não pode ser nulo.");
		}
		localidadeRepository.deleteById(id);
	}
}