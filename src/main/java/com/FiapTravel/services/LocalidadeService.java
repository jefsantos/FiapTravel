package com.FiapTravel.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.FiapTravel.model.Localidade;

@Service
public interface LocalidadeService {
	
	Localidade save (Localidade localidade);
	List<Localidade> buscarTodasLocalidades();
	Optional<Localidade> buscarPorId(UUID id);
	void deletarLocalidade (UUID id);
	

}
