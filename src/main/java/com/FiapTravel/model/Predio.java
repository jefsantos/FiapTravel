package com.FiapTravel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Predio {
    @Id
    private UUID idPredio;
    private String nomePredio;
    @ManyToOne
    @JoinColumn(name = "id_localidade")
    private Localidade localidade;
}
