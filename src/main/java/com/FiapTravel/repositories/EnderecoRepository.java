package com.FiapTravel.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapTravel.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID >{

}
