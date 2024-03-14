package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Predio {
    @Id
    private UUID idPredio;
    private String nomePredio;
    @ManyToOne
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;
}
