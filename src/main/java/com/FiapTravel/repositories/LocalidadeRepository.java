package com.FiapTravel.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FiapTravel.model.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, UUID >{

}
