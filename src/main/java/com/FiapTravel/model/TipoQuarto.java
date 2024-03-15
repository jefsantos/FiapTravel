package com.FiapTravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class TipoQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTipoQuarto;
    private String nomeTipoQuarto;
}
