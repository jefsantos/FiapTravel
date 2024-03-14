package com.FiapTravel.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.repositories.LocalidadeRepository;
import com.FiapTravel.services.LocalidadeService;

@Service
public class LocalidadeServiceImpl implements LocalidadeService{

	@Autowired
	LocalidadeRepository repo;
	
	@Override
	public Localidade save(Localidade localidade) {
		return repo.save(localidade);
	}

	@Override
	public List<Localidade> buscarTodasLocalidades() {
		return repo.findAll();
	}

	@Override
	public Optional<Localidade> buscarPorId(UUID id) {
		return repo.findById(id);
	}

	@Override
	public void deletarLocalidade(UUID id) {
		repo.deleteById(id);
		
	}

}
