package com.FiapTravel.repositories;

import com.FiapTravel.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuartoRepository extends JpaRepository<Quarto, UUID> {
}
