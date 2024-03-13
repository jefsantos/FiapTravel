package com.FiapTravel.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.FiapTravel.model.Endereco;
import com.FiapTravel.model.Localidade;

@Service
public interface EnderecoService {
	
	Endereco save (Endereco endereco);
	List<Endereco> buscarTodasEnderecos();
	Optional<Endereco> buscarPorId(UUID id);
	void deletarEndereco (UUID id);
	

}
