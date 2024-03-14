package com.FiapTravel.repositories;

import com.FiapTravel.model.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, UUID> {
}
