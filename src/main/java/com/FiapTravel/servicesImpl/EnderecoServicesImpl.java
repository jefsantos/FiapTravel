package com.FiapTravel.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FiapTravel.model.Endereco;
import com.FiapTravel.repositories.EnderecoRepository;
import com.FiapTravel.services.EnderecoService;

@Service
public class EnderecoServicesImpl implements EnderecoService{

	@Autowired
	EnderecoRepository repo;
	
	@Override
	public Endereco save(Endereco Endereco) {
		return repo.save(Endereco);
	}
	

	@Override
	public List<Endereco> buscarTodasEnderecos() {
		return repo.findAll();
	}

	@Override
	public Optional<Endereco> buscarPorId(UUID id) {
		return repo.findById(id);
	}

	@Override
	public void deletarEndereco(UUID id) {
		repo.deleteById(id);
		
	}

}
