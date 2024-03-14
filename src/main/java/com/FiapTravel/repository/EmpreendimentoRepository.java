package com.FiapTravel.repository;

import com.FiapTravel.model.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, UUID> {
}
